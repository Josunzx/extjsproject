package com.graph;

/**
 * Java: Kruskal算法生成最小生成树(邻接矩阵)
 *
 * @author skywang
 * @date 2014/04/24
 */

import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {

    private int mEdgNum;        // 边的数量
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    /*
     * 创建图(自己输入数据)
     */
    public MatrixUDG() {

        // 输入"顶点数"和"边数"
        System.out.printf("input vertex number: ");
        int vlen = MatrixUDG.readInt();
        System.out.printf("input edge number: ");
        int elen = MatrixUDG.readInt();
        if (vlen < 1 || elen < 1 || elen > vlen * (vlen - 1)) {
            System.out.printf("input error: invalid parameters!\n");
            return;
        }

        // 初始化"顶点"
        this.mVexs = new char[vlen];
        for (int i = 0; i < this.mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            this.mVexs[i] = MatrixUDG.readChar();
        }

        // 1. 初始化"边"的权值
        this.mEdgNum = elen;
        this.mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i == j) {
                    this.mMatrix[i][j] = 0;
                } else {
                    this.mMatrix[i][j] = MatrixUDG.INF;
                }
            }
        }
        // 2. 初始化"边"的权值: 根据用户的输入进行初始化
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点,结束顶点,权值
            System.out.printf("edge(%d):", i);
            char c1 = MatrixUDG.readChar();       // 读取"起始顶点"
            char c2 = MatrixUDG.readChar();       // 读取"结束顶点"
            int weight = MatrixUDG.readInt();     // 读取"权值"

            int p1 = this.getPosition(c1);
            int p2 = this.getPosition(c2);
            if (p1 == -1 || p2 == -1) {
                System.out.printf("input error: invalid edge!\n");
                return;
            }

            this.mMatrix[p1][p2] = weight;
            this.mMatrix[p2][p1] = weight;
        }
    }

    /*
     * 创建图(用已提供的矩阵)
     * 参数说明：
     * vexs -- 顶点数组
     * matrix-- 矩阵(数据)
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {

        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;

        // 初始化"顶点"
        this.mVexs = new char[vlen];
        for (int i = 0; i < this.mVexs.length; i++) {
            this.mVexs[i] = vexs[i];
        }

        // 初始化"边"
        this.mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.mMatrix[i][j] = matrix[i][j];
            }
        }

        // 统计"边"
        this.mEdgNum = 0;
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.mMatrix[i][j] != MatrixUDG.INF) {
                    this.mEdgNum++;
                }
            }
        }
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

    /*
     * 读取一个输入字符
     */
    private static int readInt() {
        try (Scanner scanner = new Scanner(System.in);) {
            return scanner.nextInt();
        }
    }

    /*
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
     */
    private int firstVertex(int v) {

        if (v < 0 || v > this.mVexs.length - 1) {
            return -1;
        }

        for (int i = 0; i < this.mVexs.length; i++) {
            if (this.mMatrix[v][i] != 0 && this.mMatrix[v][i] != MatrixUDG.INF) {
                return i;
            }
        }

        return -1;
    }

    /*
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     */
    private int nextVertex(int v, int w) {

        if (v < 0 || v > this.mVexs.length - 1 || w < 0
            || w > this.mVexs.length - 1) {
            return -1;
        }

        for (int i = w + 1; i < this.mVexs.length; i++) {
            if (this.mMatrix[v][i] != 0 && this.mMatrix[v][i] != MatrixUDG.INF) {
                return i;
            }
        }

        return -1;
    }

    /*
     * 深度优先搜索遍历图的递归实现
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", this.mVexs[i]);
        // 遍历该顶点的所有邻接顶点。若是没有访问过，那么继续往下走
        for (int w = this.firstVertex(i); w >= 0; w = this.nextVertex(i, w)) {
            if (!visited[w]) {
                this.DFS(w, visited);
            }
        }
    }

    /*
     * 深度优先搜索遍历图
     */
    public void DFS() {
        boolean[] visited = new boolean[this.mVexs.length];       // 顶点访问标记

        // 初始化所有顶点都没有被访问
        for (int i = 0; i < this.mVexs.length; i++) {
            visited[i] = false;
        }

        System.out.printf("DFS: ");
        for (int i = 0; i < this.mVexs.length; i++) {
            if (!visited[i]) {
                this.DFS(i, visited);
            }
        }
        System.out.printf("\n");
    }

    /*
     * 广度优先搜索（类似于树的层次遍历）
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[this.mVexs.length];            // 辅组队列
        boolean[] visited = new boolean[this.mVexs.length];  // 顶点访问标记

        for (int i = 0; i < this.mVexs.length; i++) {
            visited[i] = false;
        }

        System.out.printf("BFS: ");
        for (int i = 0; i < this.mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", this.mVexs[i]);
                queue[rear++] = i;  // 入队列
            }

            while (head != rear) {
                int j = queue[head++];  // 出队列
                for (int k = this.firstVertex(j); k >= 0; k = this.nextVertex(
                    j, k)) { //k是为访问的邻接顶点
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", this.mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.printf("\n");
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < this.mVexs.length; i++) {
            for (int j = 0; j < this.mVexs.length; j++) {
                System.out.printf("%10d ", this.mMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }

    /*
     * prim最小生成树
     * 参数说明：
     * start -- 从图中的第start个元素开始，生成最小树
     */
    public void prim(int start) {
        int num = this.mVexs.length;         // 顶点个数
        int index = 0;                    // prim最小树的索引，即prims数组的索引
        char[] prims = new char[num];  // prim最小树的结果数组
        int[] weights = new int[num];   // 顶点间边的权值

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        prims[index++] = this.mVexs[start];

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (int i = 0; i < num; i++) {
            weights[i] = this.mMatrix[start][i];
        }
        // 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if (start == i) {
                continue;
            }

            int j = 0;
            int k = 0;
            int min = MatrixUDG.INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            while (j < num) {
                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            prims[index++] = this.mVexs[k];
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[k] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
            for (j = 0; j < num; j++) {
                // 当第j个节点没有被处理，并且需要更新时才被更新。
                if (weights[j] != 0 && this.mMatrix[k][j] < weights[j]) {
                    weights[j] = this.mMatrix[k][j];
                }
            }
        }

        // 计算最小生成树的权值
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = MatrixUDG.INF;
            // 获取prims[i]在mMatrix中的位置
            int n = this.getPosition(prims[i]);
            // 在vexs[0...i]中，找出到j的权值最小的顶点。
            for (int j = 0; j < i; j++) {
                int m = this.getPosition(prims[j]);
                if (this.mMatrix[m][n] < min) {
                    min = this.mMatrix[m][n];
                }
            }
            sum += min;
        }
        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", this.mVexs[start], sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("%c ", prims[i]);
        }
        System.out.printf("\n");
    }

    /*
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal() {
        int index = 0;                      // rets数组的索引
        int[] vends = new int[this.mEdgNum];     // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
        EData[] rets = new EData[this.mEdgNum];  // 结果数组，保存kruskal最小生成树的边
        EData[] edges;                      // 图对应的所有边

        // 获取"图中所有的边"
        edges = this.getEdges();
        // 将边按照"权"的大小进行排序(从小到大)
        MatrixUDG.sortEdges(edges, this.mEdgNum);

        for (int i = 0; i < this.mEdgNum; i++) {
            int p1 = this.getPosition(edges[i].start);      // 获取第i条边的"起点"的序号
            int p2 = this.getPosition(edges[i].end);        // 获取第i条边的"终点"的序号

            int m = MatrixUDG.getEnd(vends, p1);                 // 获取p1在"已有的最小生成树"中的终点
            int n = MatrixUDG.getEnd(vends, p2);                 // 获取p2在"已有的最小生成树"中的终点
            // 如果m!=n，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
            if (m != n) {
                vends[m] = n;                       // 设置m在"已有的最小生成树"中的终点为n
                rets[index++] = edges[i];           // 保存结果
            }
        }

        // 统计并打印"kruskal最小生成树"的信息
        int length = 0;
        for (int i = 0; i < index; i++) {
            length += rets[i].weight;
        }
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++) {
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        }
        System.out.printf("\n");
    }

    /*
     * 获取图中的边
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges;

        edges = new EData[this.mEdgNum];
        for (int i = 0; i < this.mVexs.length; i++) {
            for (int j = i + 1; j < this.mVexs.length; j++) {
                if (this.mMatrix[i][j] != MatrixUDG.INF) {
                    edges[index++] = new EData(this.mVexs[i], this.mVexs[j],
                        this.mMatrix[i][j]);
                }
            }
        }

        return edges;
    }

    /*
     * 对边按照权值大小进行排序(由小到大)
     */
    private static void sortEdges(EData[] edges, int elen) {

        for (int i = 0; i < elen; i++) {
            for (int j = i + 1; j < elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // 交换"边i"和"边j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
     * 获取i的终点
     */
    private static int getEnd(int[] vends, int i) {
        while (vends[i] != 0) {
            i = vends[i];
        }
        return i;
    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = {
            /* A *//* B *//* C *//* D *//* E *//* F *//* G */
            /* A */{ 0, 12, MatrixUDG.INF, MatrixUDG.INF, MatrixUDG.INF, 16, 14 },
            /* B */{ 12, 0, 10, MatrixUDG.INF, MatrixUDG.INF, 7, MatrixUDG.INF },
            /* C */{ MatrixUDG.INF, 10, 0, 3, 5, 6, MatrixUDG.INF },
            /* D */{ MatrixUDG.INF, MatrixUDG.INF, 3, 0, 4, MatrixUDG.INF,
                MatrixUDG.INF },
            /* E */{ MatrixUDG.INF, MatrixUDG.INF, 5, 4, 0, 2, 8 },
            /* F */{ 16, 7, 6, MatrixUDG.INF, 2, 0, 9 },
            /* G */{ 14, MatrixUDG.INF, MatrixUDG.INF, MatrixUDG.INF, 8, 9, 0 } };
        MatrixUDG pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixUDG();
        // 采用已有的"图"
        pG = new MatrixUDG(vexs, matrix);

        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树
        pG.kruskal();   // Kruskal算法生成最小生成树
    }
}