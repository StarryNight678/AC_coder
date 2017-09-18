package search;

import java.util.Scanner;

/**
 * 数独求解
 * http://blog.csdn.net/hll174/article/details/51090461
 * <p>
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */

/*
数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。

输入描述:
输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。


输出描述:
输出九行，每行九个空格隔开的数字，为解出的答案。


测试用例:
0 9 5 0 2 0 0 6 0
0 0 7 1 0 3 9 0 2
6 0 0 0 0 5 3 0 4
0 4 0 0 1 0 6 0 7
5 0 0 2 0 7 0 0 9
7 0 3 0 9 0 0 2 0
0 0 9 8 0 0 0 0 6
8 0 6 3 0 2 1 0 5
0 5 0 0 7 0 2 8 3

对应输出应该为:

3 9 5 7 2 4 8 6 1
4 8 7 1 6 3 9 5 2
6 2 1 9 8 5 3 7 4
9 4 2 5 1 8 6 3 7
5 6 8 2 3 7 4 1 9
7 1 3 4 9 6 5 2 8
2 3 9 8 5 1 7 4 6
8 7 6 3 4 2 1 9 5
1 5 4 6 7 9 2 8 3
*/

public class ShuDu {


    public static boolean DFS(int[][] a, boolean[][] cols, boolean[][] rows, boolean[][] blocks) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    int k = i / 3 * 3 + j / 3;
                    for (int l = 0; l < 9; l++) {
                        if (!cols[j][l] && !rows[i][l] && !blocks[k][l]) {//l对于的数字l+1没有在行列块中出现
                            rows[i][l] = cols[j][l] = blocks[k][l] = true;
                            a[i][j] = 1 + l;//下标加1
                            if (DFS(a, cols, rows, blocks)) return true;//递进则返回true
                            rows[i][l] = cols[j][l] = blocks[k][l] = false;//递进失败则回溯
                            a[i][j] = 0;
                        }
                    }
                    return false;//a[i][j]==0时，l发现都不能填进去
                }//the end of a[i][j]==0
            }
        }
        return true;//没有a[i][j]==0,则返回true
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int[][] a = new int[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] rows = new boolean[9][9];
            boolean[][] blocks = new boolean[9][9];//九大宫的九个数字

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    a[i][j] = sc.nextInt();
                    if (a[i][j] != 0) {
                        int k = i / 3 * 3 + j / 3;//划分九宫格,这里以行优先，自己也可以列优先
                        int val = a[i][j] - 1;
                        rows[i][val] = true;
                        cols[j][val] = true;
                        blocks[k][val] = true;
                    }
                }
            }//数据装载完毕
            DFS(a, cols, rows, blocks);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.print(a[i][8]);
                System.out.println();

            }
        }
    }
}
