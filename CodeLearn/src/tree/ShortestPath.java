package tree;

/**
 * 最短路径
 * <p>
 * 注意:
 * 1. k必须放到最外面
 * 2. path[i][j] = path[i][k];//这个需要注意
 *
 * 参考: https://github.com/StarryNight678/code_interview/blob/master/%E6%9C%80%E7%9F%AD%E8%B7%AF%E5%BE%84.md
 * create by  ZhouJianhua  2017/8/31
 * Email: zjhua678@163.com
 */
public class ShortestPath {

    private static final int MAX_INT = 99999;

    /**
     * 计算最短路径
     *
     * @param tree
     * @param path
     */
    void floydShortestPath(int[][] tree, int[][] path) {
        int size = tree.length;
        //路径初始化
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path[i][j] = j;
            }
        }

        //注意: k必须放到最外面
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (tree[i][j] > (tree[i][k] + tree[k][j])) {
                        tree[i][j] = tree[i][k] + tree[k][j];
                        //注意: 需要这样标记路径
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

    }

    /**
     * 输出最短路径
     *
     * @param path
     */
    void getPath(int[][] path, int start, int end) {
        System.out.print(start);
        while (end != start) {
            start = path[start][end];
            System.out.print(" --> " + start);
        }
    }

    /**
     * 显示数组
     *
     * @param arr
     */
    void printArr(int[][] arr) {
        int len = arr.length;
        int size = arr[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%6d\t", arr[i][j]));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int SIZE = 4;
        int[][] tree = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tree[i][j] = MAX_INT;
                if (i == j) {
                    tree[i][j] = 0;
                }
            }

        }
        tree[0][1] = 1;
        tree[0][3] = 4;
        tree[1][2] = 9;
        tree[1][3] = 2;
        tree[2][0] = 3;
        tree[2][1] = 5;
        tree[2][3] = 8;
        tree[3][2] = 6;
        int[][] path = new int[SIZE][SIZE];
        ShortestPath shortestPath = new ShortestPath();
        System.out.println("tree:");
        shortestPath.printArr(tree);
        shortestPath.floydShortestPath(tree, path);
        System.out.println("distance tree:");
        shortestPath.printArr(tree);
        System.out.println("path:");
        shortestPath.printArr(path);

        int start=1;
        int end=0;
        System.out.println("length:"+tree[start][end]);
        System.out.println("输出路径");
        shortestPath.getPath(path, start, end);

    }
}
