package datastruct;

import java.util.Arrays;

/**
 * 背包问题
 * http://love-oriented.com/pack/P01.html
 * create by ZhouJianhua 2017/8/28
 */
public class BaggageLoading {

    /**
     * Baggage Loading (背包问题)
     * 一个背包可以放入的物品重量T，
     * 现有n件物品，重量分别为w1,w2,…,wn
     * 问能否从这些物品中选若干件放入背包中，使得放入的重量之和正好是T。
     * <p>
     * fun= 1		t = 0
     * fun= 0		t < 0
     * fun= 0		t > 0, n < 1
     * fun= knap(t,n-1) 或 knap(t-wn, n-1);    当t>0, n>=1
     */

    //物品重量
    private int[] w;

    //物品价值
    private int[] value;

    //选择的标记
    private int[] valueSelect;

    BaggageLoading(int[] w) {
        this.w = w;
        this.value = new int[w.length];
        this.valueSelect = new int[w.length];
    }

    BaggageLoading(int[] w, int[] v) {
        this.w = w;
        this.value = v;
        this.valueSelect = new int[w.length];
    }

    /**
     * n个是否可以放下
     *
     * @param t 容量
     * @param n 第n个是否可以放
     * @return
     */
    int baggage(int t, int n) {
        if (0 == t) {
            return 1;
        }
        if (t < 0 || (t > 0 && n <= 0)) {
            return 0;
        }
        if (1 == baggage(t - w[n - 1], n - 1)) {
            valueSelect[n - 1] = 1;
            return 1;
        } else {
            //必须这样返回
            return baggage(t, n - 1);
        }
    }


    /**
     * 最大价值背包问题：
     * 给定 n 个背包，
     * 重量分别为 w1,w2,……,wn
     * 价值分别为 v1,v2,……,vn
     * 要放入总承重为 t 的箱子中，
     * 求可放入箱子的背包价值总和的最大值。
     * <p>
     * * 求解最优值：
     * 1. 若  j < wn, 则 ： v[n,j] = v[n-1,j];
     * 2. 若  j >= wn, 则：v[n,j] = max{v[n-1,j], vn + v[n-1,j-wn]}。
     *
     * @param t 容量
     * @param n 数量
     * @return
     */

    int baggageMaxValue(int t, int n) {

        if (0 == t) {
            return 0;
        }
        if (t < 0 || (t > 0 && n <= 0)) {
            return -100000;
        }

        if (t < w[n - 1]) {
            return baggageMaxValue(t, n - 1);
        } else {
            return Math.max(baggageMaxValue(t, n - 1), baggageMaxValue(t - w[n - 1], n - 1) + value[n - 1]);
        }
    }

    /**
     * 显示结果
     */
    void printSelect() {
        for (int i = 0; i < valueSelect.length; i++) {
            if (1 == valueSelect[i]) {
                System.out.println("w[" + i + "]:" + w[i] + "   value[" + i + "]:" + value[i]);
            }
        }
    }


    /**
     * 基本的0,1背包问题
     * <p>
     * 表示前n个物品装到剩余容量为t的背包中的最大重量
     * 参考:http://cache.baiducontent.com/c?m=9f65cb4a8c8507ed4fece7631046893b4c4380146d96864968d4e414c422461e0067e8b03a715042889422301cf91e1ab9ab68332a0625b79bc28b48c9fecf6879873044730bf64005a31bb8bf3732c050872b9eb86894ad814384d9d2&p=882a9546d39e00fe0ebe9b7c7f5283&newp=c033dc1a9ed512a05abd9b7e0e1394231610db2151d4da136b82c825d7331b001c3bbfb423241406d3c47c6403ad4b5cebfa3d74350025a3dda5c91d9fb4c57479&user=baidu&fm=sc&query=%B1%B3%B0%FC%CE%CA%CC%E2&qid=85c2be560001aafd&p1=2
     *
     * @param t 容量
     * @param n 数目
     * @return
     */
    int basicBaggage(int t, int n) {


        //d[i][j]  标示前i个,在容量为j时的最大价值
        int[][] d = new int[n + 1][t + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t; j++) {

                if (i == 0) {
                    d[i][j] = 0;
                }

                //  d[i][j]= max{ d[i-1][j] , d[i-1][j-w[i-1]]+value[i - 1]}
                if (i >= 1 && (j - w[i - 1]) >= 0 && (d[i][j - w[i - 1]] + value[i - 1]) > d[i - 1][j]) {
                    d[i][j] = d[i - 1][j - w[i - 1]] + value[i - 1];
                } else {

                    if (i >= 1) {
                        d[i][j] = d[i - 1][j];
                    }

                }
            }
        }


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                System.out.print(String.format("%d\t", d[i][j]));
            }
            System.out.println();
        }
        //打印结果
        printBaggageResult(d);
        return d[n][t];
    }

    /**
     * 显示0,1背包选择的结果
     *
     * @param d 标示数组
     */
    void printBaggageResult(int[][] d) {

        int m = d.length - 1;
        int n = d[0].length - 1;
        System.out.println(m + " " + n);

        int[] flag = new int[m];

        int j = n;
        for (int i = m; i >= 1; i--) {
            if (d[i][j] > d[i - 1][j]) {
                flag[i - 1] = 1;
                j = j - w[i - 1];
            }
        }
        System.out.println("0,1背包结果:");
        for (int i = 0; i < m; ++i) {
            if (1 == flag[i]) {
                System.out.println("weight:" + w[i] + " value:" + value[i]);
            }

        }


    }

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        System.out.println("w:" + Arrays.toString(w));
        System.out.println("v:" + Arrays.toString(value));
        BaggageLoading baggageLoading = new BaggageLoading(w);
        int T = 10;
        int len = baggageLoading.w.length;
        System.out.println("容量=" + T);
//        int result = baggageLoading.baggage(T, len);
//        System.out.println("是否可以填满:" + result);
//        BaggageLoading baggageMaxValue = new BaggageLoading(w, value);
//        int resultMaxValue = baggageMaxValue.baggageMaxValue(T, len);
//        System.out.println("resultMaxValue:" + resultMaxValue);


        BaggageLoading basicBaggage = new BaggageLoading(w, value);
        System.out.println("basicBaggage max vlaue:" + basicBaggage.basicBaggage(T, len));

        /*
        int[] w = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        动态规划数组
            0	0	0	0	0	0	0	0	0	0	0
            0	0	6	6	6	6	6	6	6	6	6
            0	0	6	6	9	9	9	9	9	9	9
            0	0	6	6	9	9	9	9	11	11	14
            0	0	6	6	9	9	9	10	11	13	14
            0	0	6	6	9	9	12	12	15	15	15
         */

    }
}
