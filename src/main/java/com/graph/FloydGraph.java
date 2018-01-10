package com.graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * 最短路径：
 * 弗洛伊德(Floyd)算法
 *
 * @author Chaoqun Zheng
 */

//测试参数：
//input Vexs: A,B,C,D,E,F,G,H,I
//input Matrix: A-B-1,A-C-5,B-C-3,B-D-7,B-E-5,C-E-1,C-F-7,D-E-2,D-G-3,E-F-3,E-G-6,E-H-9,F-H-5,G-H-2,G-I-7,H-I-4
//      A
//    /   \
//   B ——— C
//  /  \ /  \
// D —— E —— F
//  \  / \  /
//   G ——— H
//    \   /
//      I
public class FloydGraph {

    private final static Scanner scanner = new Scanner(System.in);
    private final char[] mVexs;       // 顶点集合
    private final int[][] mMatrix;    // 邻接矩阵
    // 最大值,这里最大值设置为Short的最大值，避免执行floyd方法时两个Integer.MAX_VALUE相加成为负值，影响逻辑判断
    private static final int INF = Short.MAX_VALUE;

    private int[][] pathMatrix;//网图G中各顶点v到其余各顶点最短路径径P[v][w]
    private int[][] shortPathTable;//网图G中各顶点v到其余各顶点最短路径的带权长度D[v][w]

    public static void main(String[] args) {
        FloydGraph floydGraph = new FloydGraph();
        boolean redo = false;
        while (!redo) {
            redo = true;
            System.out.println("input start vex:");
            char start = FloydGraph.readChar();
            System.out.println("input end vex:");
            char end = FloydGraph.readChar();
            floydGraph.printMinPath(start, end);
            redo = false;
        }
    }

    public void printMinPath(char start, char end) {
        int startIndex = this.getPosition(start);
        int endIndex = this.getPosition(end);

        System.out.println(start + "->" + end + "最短路径长度为："
            + this.shortPathTable[startIndex][endIndex]);
        String path = "" + start;
        while ((startIndex = this.pathMatrix[startIndex][endIndex]) != endIndex) {
            path += "-->" + this.mVexs[startIndex];
        }
        path += "-->" + end;
        System.out.println(start + "->" + end + "最短路径为：" + path);
    }

    public FloydGraph() {
        // 初始化"顶点"
        System.out.printf("input Vexs: ");
        String vexString = FloydGraph.readStr();
        String[] vexs = vexString.split(",");
        int vlen = vexs.length;
        this.mVexs = new char[vlen];
        for (int i = 0; i < this.mVexs.length; i++) {
            this.mVexs[i] = vexs[i].trim().charAt(0);
        }

        // 1. 初始化"边"的权值
        this.mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i == j) {
                    this.mMatrix[i][j] = 0;
                } else {
                    this.mMatrix[i][j] = FloydGraph.INF;
                }
            }
        }
        // 2. 初始化"边"的权值: 根据用户的输入进行初始化
        System.out.printf("input Matrix: ");
        String matrixString = FloydGraph.readStr();
        String[] edges = matrixString.split(",");
        for (String edge2 : edges) {
            // 读取边的起始顶点,结束顶点,权值
            String[] edge = edge2.split("-");

            int p1 = this.getPosition(edge[0].trim().charAt(0));
            int p2 = this.getPosition(edge[1].trim().charAt(0));

            int weight = Character.getNumericValue(edge[2].trim().charAt(0));
            this.mMatrix[p1][p2] = weight;
            this.mMatrix[p2][p1] = weight;
        }
        this.floyd();
    }

    private static String readStr() {
        return FloydGraph.scanner.next();
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < this.mVexs.length; i++) {
            if (this.mVexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * floyd算法计算各顶点间的最小路径
     */
    private void floyd() {
        int v, w, k;//k 代表的就是中转顶点的下标。v 代表起始顶点， W 代表结束顶点。
        int length = this.mVexs.length;
        this.shortPathTable = new int[length][length];
        this.pathMatrix = new int[length][length];
        for (v = 0; v < length; v++) {
            for (w = 0; w < length; w++) {
                this.shortPathTable[v][w] = this.mMatrix[v][w];
                this.pathMatrix[v][w] = w;
            }
        }
        for (k = 0; k < length; k++) {
            for (v = 0; v < length; v++) {
                for (w = 0; w < length; w++) {
                    //如果经过下标为k的顶点的枯井比原两点间路径更短，则将当前两点间权值设置为更小的一个
                    if (this.shortPathTable[v][w] > this.shortPathTable[v][k]
                        + this.shortPathTable[k][w]) {
                        this.shortPathTable[v][w] = this.shortPathTable[v][k]
                            + this.shortPathTable[k][w];
                        this.pathMatrix[v][w] = this.pathMatrix[v][k];//路径设置经过下标k的顶点
                    }
                }
            }
        }
    }

    /*
     * 读取一个输入字符
     */
    private static char readChar() {
        char ch = '0';

        do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'));

        return ch;
    }

}
