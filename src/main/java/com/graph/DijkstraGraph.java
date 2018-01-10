package com.graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * 最短路径:
 * 迪杰斯特拉(Dijkstra)算法
 * Dijkstra算法. 求有向网G的V0 顶点到其余顶点V的最短路径P[v] 及带权长度D[v]
 * input Vexs: A,B,C,D,E,F,G,H,I
 * input Matrix:
 * A-B-1,A-C-5,B-C-3,B-D-7,B-E-5,C-E-1,C-F-7,D-E-2,D-G-3,E-F-3,E-G-
 * 6,E-H-9,F-H-5,G-H-2,G-I-7,H-I-4
 *
 * @author Chaoqun Zheng
 */

// 测试参数：
// input Vexs: A,B,C,D,E,F,G,H,I
// input Matrix: A-B-1,A-C-5,B-C-3,B-D-7,B-E-5,C-E-1,C-F-7,D-E-2,D-G-3,E-F-3,E-G-6,E-H-9,F-H-5,G-H-2,G-I-7,H-I-4
//         A
//       /   \
//      B ——— C
//     /  \ /  \
//    D —— E —— F
//     \  / \  /
//      G ——— H
//       \   /
//         I
public class DijkstraGraph {

    private final static Scanner scanner = new Scanner(System.in);
    private final char[] mVexs;       // 顶点集合
    private final int[][] mMatrix;    // 邻接矩阵
    // 最大值
    private static final int INF = Short.MAX_VALUE;

    private int pathMatrix[]; //用于存储最短路径下标的数组
    private int shortPathTable[]; //用于存储到各点最短路径的权值和

    public static void main(String[] args) {
        DijkstraGraph dijkstraGraph = new DijkstraGraph();
        boolean redo = false;
        while (!redo) {
            redo = true;
            System.out.println("input start vex:");
            char start = DijkstraGraph.readChar();
            System.out.println("input end vex:");
            char end = DijkstraGraph.readChar();
            dijkstraGraph.printMinPath(start, end);
            redo = false;
        }
    }

    public void printMinPath(char start, char end) {
        int startIndex = this.getPosition(start);
        this.dijkstra(startIndex);
        int endIndex = this.getPosition(end);

        System.out.println(start + "->" + end + "最短路径长度为："
            + this.shortPathTable[endIndex]);
        String path = "" + end;
        while ((endIndex = this.pathMatrix[endIndex]) != startIndex) {
            path = this.mVexs[endIndex] + "-->" + path;
        }
        path = start + "-->" + path;
        System.out.println(start + "->" + end + "最短路径为：" + path);
    }

    public DijkstraGraph() {
        // 初始化"顶点"
        System.out.printf("input Vexs: ");
        String vexString = DijkstraGraph.readStr();
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
                    this.mMatrix[i][j] = DijkstraGraph.INF;
                }
            }
        }
        // 2. 初始化"边"的权值: 根据用户的输入进行初始化
        System.out.printf("input Matrix: ");
        String matrixString = DijkstraGraph.readStr();
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
    }

    private static String readStr() {
        return DijkstraGraph.scanner.next();
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
     * dijkstra算法计算某顶点到其余各顶点间的最小路径
     *
     * @param c
     *        顶点下标
     */
    private void dijkstra(int c) {
        int[] finalP = new int[this.mVexs.length];//finalP[w]=1 表示求得顶点c至w的最短路径
        this.shortPathTable = new int[this.mVexs.length];
        this.pathMatrix = new int[this.mVexs.length];
        for (int i = 0; i < finalP.length; i++) {
            finalP[i] = 0;
            this.shortPathTable[i] = this.mMatrix[c][i];//将与c顶点有连线的顶点加上权值
            this.pathMatrix[i] = 0;
        }
        this.shortPathTable[c] = 0;
        finalP[c] = 0;

        int k = 0, min;
        for (int v = 1; v < this.mVexs.length; v++) {
            min = DijkstraGraph.INF;//当常所知离c顶点的最近距离
            //寻找离c最近的顶点
            for (int w = 0; w < this.mVexs.length; w++) {
                if (finalP[w] == 0 && this.shortPathTable[w] < min) {
                    k = w;
                    min = this.shortPathTable[w];//w顶点离c顶点最近
                }
            }
            finalP[k] = 1;//将目前找到的最近的顶点置为1
            //修正当前最短路径及距离
            for (int w = 0; w < this.mVexs.length; w++) {
                //说明找到了更短的路径，修改shortPathTable[w]和pathMatirx[w]
                if (finalP[w] == 0
                    && min + this.mMatrix[k][w] < this.shortPathTable[w]) {
                    this.shortPathTable[w] = min + this.mMatrix[k][w];
                    this.pathMatrix[w] = k;
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
