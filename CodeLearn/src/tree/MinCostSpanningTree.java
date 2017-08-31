package tree;

import java.util.Arrays;

/**
 * 最小生成树
 * create by  ZhouJianhua  2017/8/31
 * Email: zjhua678@163.com
 */
public class MinCostSpanningTree {


    private static final int MAX_INT = 9999;

    int minCostTree(int[][] tree) {

        int length = 0;
        int size = tree.length;
        int[] path = new int[size];
        int minInt = MAX_INT;
        int minI = -1, minJ = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (minInt > tree[i][j]) {
                    minInt = tree[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }

        length += tree[minI][minJ];
        path[minI] = 1;
        path[minJ] = 1;
        System.out.println(Arrays.toString(path) + "  tree[i][j]:" + tree[minI][minJ]);


        for (int count = 1; count < size-1; count++) {
            minInt = MAX_INT;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (path[i] == 1 && path[j] == 0 && minInt > tree[i][j]) {
                        minInt = tree[i][j];
                        minI = i;
                        minJ = j;
                    }
                }
            }
            length += tree[minI][minJ];
            path[minJ] = 1;
            System.out.println(Arrays.toString(path) + "  tree[i][j]:" + tree[minI][minJ]);
        }

        return length;


    }

    public static void main(String[] args) {

        int SIZE = 7;
        int[][] tree = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tree[i][j] = MAX_INT;
            }
        }
        tree[0][1] = 28;
        tree[0][5] = 10;
        tree[5][4] = 25;
        tree[4][6] = 24;
        tree[4][3] = 22;
        tree[3][2] = 12;
        tree[2][1] = 16;
        tree[3][6] = 18;
        tree[1][6] = 14;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if( tree[i][j] < MAX_INT){
                    tree[j][i] = tree[i][j] ;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Arrays.toString(tree[i]));
        }

        MinCostSpanningTree minCostSpanningTree = new MinCostSpanningTree();
        int length = minCostSpanningTree.minCostTree(tree);
        System.out.println(length);

    }
}
