package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class AnalysLog {
    private static String projectName = "thread_loan";

    private static String filepath = "E:/个人工作/Thread-14256/access_logs_113";

    private static String pathSeparator = "/";

    private static Map<String, AtomicInteger> urlMap = new HashMap<>();

    private static String urlPath = "E:/个人工作/Thread-14256/urlCollections/";

    private static volatile Boolean cachePatterns = true;

    private static boolean trimTokens = true;

    private static final Map<String, String[]> tokenizedPatternCache = new ConcurrentHashMap<>(
        256);

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println("开始时间："
            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        AnalysLog.initUrlMap();
//        System.out.println(AnalysLog.urlMap);
        AnalysLog.readLogs();
        System.out.println(AnalysLog.urlMap);
        long end = System.currentTimeMillis();
        System.out.println("结束时间："
            + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        System.out.println("共耗时：" + (end - start));
    }

    public static void initUrlMap() {
        File file = new File(AnalysLog.urlPath + AnalysLog.projectName + ".txt");
        try (FileInputStream fis = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(
                    fis));) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String url = line.substring(line.indexOf("{") + 2,
                    line.indexOf("]"));
                if (line.indexOf("methods=") != -1) {
                    int methodIndex = line.indexOf("methods=") + 9;
                    String methodsStr = line.substring(methodIndex,
                        line.indexOf("]", methodIndex));
                    String[] methods = methodsStr.split(" \\|\\| ");
                    for (String method : methods) {
                        AnalysLog.urlMap.put(method + ":" + url,
                            new AtomicInteger(0));
                    }
                } else {
                    AnalysLog.urlMap.put("GET:" + url, new AtomicInteger(0));
                    AnalysLog.urlMap.put("PUT:" + url, new AtomicInteger(0));
                    AnalysLog.urlMap.put("POST:" + url, new AtomicInteger(0));
                    AnalysLog.urlMap.put("DELETE:" + url, new AtomicInteger(0));
                }
            }
        } catch (IOException e) {
            System.err.println("urlMap初始化失败。。。");
            e.printStackTrace();
        }
    }

    public static void readLogs() throws IOException {
        File folder = new File(AnalysLog.filepath);
        String[] list = folder.list();
        String fileStart = "113_" + AnalysLog.projectName;
        for (String string : list) {
            if (string.startsWith(fileStart)) {
                System.out.println("开始分析文件：" + string);
                File file = new File(AnalysLog.filepath + "/" + string);
                try (FileInputStream fis = new FileInputStream(file);
                        BufferedReader br = new BufferedReader(
                            new InputStreamReader(fis));) {
                    String line = null;
                    int i = 0;
                    while ((line = br.readLine()) != null) {
                        i++;
                        try {
                            String longUrl = line
                                .substring(line.indexOf("\"") + 1);
                            String method = longUrl.substring(0,
                                longUrl.indexOf(" "));
                            String url = longUrl.substring(
                                longUrl.indexOf(AnalysLog.projectName)
                                    + AnalysLog.projectName.length(), longUrl
                                    .indexOf("?") >= 0 ? longUrl.indexOf("?")
                                    : longUrl.indexOf(" HTTP"));
                            String lookupPath = method + ":" + url;
                            AnalysLog.countUrlMap(lookupPath);
                        } catch (Exception e) {
                            System.err.println("日志文件" + string + "的第" + i
                                + "行报错:line=" + line);
                            continue;
                        }
                    }
                }

                System.out.println(AnalysLog.urlMap);
            }
        }
    }

    public static void countUrlMap(String lookupPath) {
        Set<String> keySet = AnalysLog.urlMap.keySet();
        List<String> matches = new ArrayList<>();
        for (String pattern : keySet) {
            if (AnalysLog.getMatchingPattern(pattern, lookupPath)) {
                matches.add(pattern);
            }
        }
        Collections.sort(matches, new AntPatternComparator(lookupPath));
        AnalysLog.urlMap.get(matches.get(0)).incrementAndGet();
    }

    public static boolean getMatchingPattern(String pattern, String lookupPath) {
        if (pattern.equals(lookupPath)) {
            return true;
        }
        if (AnalysLog.doMatch(pattern, lookupPath, true)) {
            return true;
        }
        if (!pattern.endsWith("/")
            && AnalysLog.doMatch(pattern + "/", lookupPath, true)) {
            return true;
        }
        return false;
    }

    public static boolean doMatch(String pattern, String path, boolean fullMatch) {
        if (path.startsWith(AnalysLog.pathSeparator) != pattern
            .startsWith(AnalysLog.pathSeparator)) {
            return false;
        }

        String[] pattDirs = AnalysLog.tokenizePattern(pattern);
        String[] pathDirs = AnalysLog.tokenizePath(path);

        int pattIdxStart = 0;
        int pattIdxEnd = pattDirs.length - 1;
        int pathIdxStart = 0;
        int pathIdxEnd = pathDirs.length - 1;

        // Match all elements up to the first **
        while (pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            String pattDir = pattDirs[pattIdxStart];
            if ("**".equals(pattDir)) {
                break;
            }
            if (!AnalysLog.matchStrings(pattDir, pathDirs[pathIdxStart])) {
                return false;
            }
            pattIdxStart++;
            pathIdxStart++;
        }

        if (pathIdxStart > pathIdxEnd) {
            // Path is exhausted, only match if rest of pattern is * or **'s
            if (pattIdxStart > pattIdxEnd) {
                return pattern.endsWith(AnalysLog.pathSeparator) ? path
                    .endsWith(AnalysLog.pathSeparator) : !path
                    .endsWith(AnalysLog.pathSeparator);
            }
            if (!fullMatch) {
                return true;
            }
            if (pattIdxStart == pattIdxEnd
                && pattDirs[pattIdxStart].equals("*")
                && path.endsWith(AnalysLog.pathSeparator)) {
                return true;
            }
            for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
                if (!pattDirs[i].equals("**")) {
                    return false;
                }
            }
            return true;
        } else if (pattIdxStart > pattIdxEnd) {
            // String not exhausted, but pattern is. Failure.
            return false;
        } else if (!fullMatch && "**".equals(pattDirs[pattIdxStart])) {
            // Path start definitely matches due to "**" part in pattern.
            return true;
        }

        // up to last '**'
        while (pattIdxStart <= pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            String pattDir = pattDirs[pattIdxEnd];
            if (pattDir.equals("**")) {
                break;
            }
            if (!AnalysLog.matchStrings(pattDir, pathDirs[pathIdxEnd])) {
                return false;
            }
            pattIdxEnd--;
            pathIdxEnd--;
        }
        if (pathIdxStart > pathIdxEnd) {
            // String is exhausted
            for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
                if (!pattDirs[i].equals("**")) {
                    return false;
                }
            }
            return true;
        }

        while (pattIdxStart != pattIdxEnd && pathIdxStart <= pathIdxEnd) {
            int patIdxTmp = -1;
            for (int i = pattIdxStart + 1; i <= pattIdxEnd; i++) {
                if (pattDirs[i].equals("**")) {
                    patIdxTmp = i;
                    break;
                }
            }
            if (patIdxTmp == pattIdxStart + 1) {
                // '**/**' situation, so skip one
                pattIdxStart++;
                continue;
            }
            // Find the pattern between padIdxStart & padIdxTmp in str between
            // strIdxStart & strIdxEnd
            int patLength = patIdxTmp - pattIdxStart - 1;
            int strLength = pathIdxEnd - pathIdxStart + 1;
            int foundIdx = -1;

            strLoop:
            for (int i = 0; i <= strLength - patLength; i++) {
                for (int j = 0; j < patLength; j++) {
                    String subPat = pattDirs[pattIdxStart + j + 1];
                    String subStr = pathDirs[pathIdxStart + i + j];
                    if (!AnalysLog.matchStrings(subPat, subStr)) {
                        continue strLoop;
                    }
                }
                foundIdx = pathIdxStart + i;
                break;
            }

            if (foundIdx == -1) {
                return false;
            }

            pattIdxStart = patIdxTmp;
            pathIdxStart = foundIdx + patLength;
        }

        for (int i = pattIdxStart; i <= pattIdxEnd; i++) {
            if (!pattDirs[i].equals("**")) {
                return false;
            }
        }

        return true;
    }

    protected static String[] tokenizePattern(String pattern) {
        String[] tokenized = null;
        if (AnalysLog.cachePatterns == null
            || AnalysLog.cachePatterns.booleanValue()) {
            tokenized = AnalysLog.tokenizedPatternCache.get(pattern);
        }
        if (tokenized == null) {
            tokenized = AnalysLog.tokenizePath(pattern);
            if (AnalysLog.cachePatterns == null
                && AnalysLog.tokenizedPatternCache.size() >= 65536) {
                return tokenized;
            }
            if (AnalysLog.cachePatterns == null
                || AnalysLog.cachePatterns.booleanValue()) {
                AnalysLog.tokenizedPatternCache.put(pattern, tokenized);
            }
        }
        return tokenized;
    }

    protected static String[] tokenizePath(String path) {
        return StringUtils.tokenizeToStringArray(path, AnalysLog.pathSeparator,
            AnalysLog.trimTokens, true);
    }

    private static final Pattern GLOB_PATTERN = Pattern
        .compile("\\?|\\*|\\{((?:\\{[^/]+?\\}|[^/{}]|\\\\[{}])+?)\\}");
    private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";
    private static final List<String> variableNames = new LinkedList<>();

    public static boolean matchStrings(String pattern, String str) {
        StringBuilder patternBuilder = new StringBuilder();
        Matcher matcher = AnalysLog.GLOB_PATTERN.matcher(pattern);
        int end = 0;
        while (matcher.find()) {
            patternBuilder
                .append(AnalysLog.quote(pattern, end, matcher.start()));
            String match = matcher.group();
            if ("?".equals(match)) {
                patternBuilder.append('.');
            } else if ("*".equals(match)) {
                patternBuilder.append(".*");
            } else if (match.startsWith("{") && match.endsWith("}")) {
                int colonIdx = match.indexOf(':');
                if (colonIdx == -1) {
                    patternBuilder.append(AnalysLog.DEFAULT_VARIABLE_PATTERN);
                    AnalysLog.variableNames.add(matcher.group(1));
                } else {
                    String variablePattern = match.substring(colonIdx + 1,
                        match.length() - 1);
                    patternBuilder.append('(');
                    patternBuilder.append(variablePattern);
                    patternBuilder.append(')');
                    String variableName = match.substring(1, colonIdx);
                    AnalysLog.variableNames.add(variableName);
                }
            }
            end = matcher.end();
        }
        patternBuilder.append(AnalysLog.quote(pattern, end, pattern.length()));
        return Pattern.compile(patternBuilder.toString()).matcher(str)
            .matches();
    }

    private static String quote(String s, int start, int end) {
        if (start == end) {
            return "";
        }
        return Pattern.quote(s.substring(start, end));
    }

    protected static class AntPatternComparator implements Comparator<String> {

        private final String path;

        private static final Pattern VARIABLE_PATTERN = Pattern
            .compile("\\{[^/]+?\\}");

        public AntPatternComparator(String path) {
            this.path = path;
        }

        /**
         * Compare two patterns to determine which should match first, i.e.
         * which
         * is the most specific regarding the current path.
         *
         * @return a negative integer, zero, or a positive integer as pattern1
         *         is
         *         more specific, equally specific, or less specific than
         *         pattern2.
         */
        @Override
        public int compare(String pattern1, String pattern2) {
            PatternInfo info1 = new PatternInfo(pattern1);
            PatternInfo info2 = new PatternInfo(pattern2);

            if (info1.isLeastSpecific() && info2.isLeastSpecific()) {
                return 0;
            } else if (info1.isLeastSpecific()) {
                return 1;
            } else if (info2.isLeastSpecific()) {
                return -1;
            }

            boolean pattern1EqualsPath = pattern1.equals(this.path);
            boolean pattern2EqualsPath = pattern2.equals(this.path);
            if (pattern1EqualsPath && pattern2EqualsPath) {
                return 0;
            } else if (pattern1EqualsPath) {
                return -1;
            } else if (pattern2EqualsPath) {
                return 1;
            }

            if (info1.isPrefixPattern() && info2.getDoubleWildcards() == 0) {
                return 1;
            } else if (info2.isPrefixPattern()
                && info1.getDoubleWildcards() == 0) {
                return -1;
            }

            if (info1.getTotalCount() != info2.getTotalCount()) {
                return info1.getTotalCount() - info2.getTotalCount();
            }

            if (info1.getLength() != info2.getLength()) {
                return info2.getLength() - info1.getLength();
            }

            if (info1.getSingleWildcards() < info2.getSingleWildcards()) {
                return -1;
            } else if (info2.getSingleWildcards() < info1.getSingleWildcards()) {
                return 1;
            }

            if (info1.getUriVars() < info2.getUriVars()) {
                return -1;
            } else if (info2.getUriVars() < info1.getUriVars()) {
                return 1;
            }

            return 0;
        }

        /**
         * Value class that holds information about the pattern, e.g. number of
         * occurrences of "*", "**", and "{" pattern elements.
         */
        private static class PatternInfo {

            private final String pattern;

            private int uriVars;

            private int singleWildcards;

            private int doubleWildcards;

            private boolean catchAllPattern;

            private boolean prefixPattern;

            private Integer length;

            public PatternInfo(String pattern) {
                this.pattern = pattern;
                if (this.pattern != null) {
                    this.initCounters();
                    this.catchAllPattern = this.pattern.equals("/**");
                    this.prefixPattern = !this.catchAllPattern
                        && this.pattern.endsWith("/**");
                }
                if (this.uriVars == 0) {
                    this.length = this.pattern != null ? this.pattern.length()
                        : 0;
                }
            }

            protected void initCounters() {
                int pos = 0;
                while (pos < this.pattern.length()) {
                    if (this.pattern.charAt(pos) == '{') {
                        this.uriVars++;
                        pos++;
                    } else if (this.pattern.charAt(pos) == '*') {
                        if (pos + 1 < this.pattern.length()
                            && this.pattern.charAt(pos + 1) == '*') {
                            this.doubleWildcards++;
                            pos += 2;
                        } else if (pos > 0
                            && !this.pattern.substring(pos - 1).equals(".*")) {
                            this.singleWildcards++;
                            pos++;
                        } else {
                            pos++;
                        }
                    } else {
                        pos++;
                    }
                }
            }

            public int getUriVars() {
                return this.uriVars;
            }

            public int getSingleWildcards() {
                return this.singleWildcards;
            }

            public int getDoubleWildcards() {
                return this.doubleWildcards;
            }

            public boolean isLeastSpecific() {
                return this.pattern == null || this.catchAllPattern;
            }

            public boolean isPrefixPattern() {
                return this.prefixPattern;
            }

            public int getTotalCount() {
                return this.uriVars + this.singleWildcards + 2
                    * this.doubleWildcards;
            }

            /**
             * Returns the length of the given pattern, where template variables
             * are considered to be 1 long.
             *
             * @return
             */
            public int getLength() {
                if (this.length == null) {
                    this.length = AntPatternComparator.VARIABLE_PATTERN
                        .matcher(this.pattern).replaceAll("#").length();
                }
                return this.length;
            }
        }
    }
}
