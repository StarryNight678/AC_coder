package datastruct;

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

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 9};
        BaggageLoading baggageLoading = new BaggageLoading(arr);
        int T = 18;
        int len = baggageLoading.w.length;
        System.out.println("t=" + T);


        int result = baggageLoading.baggage(T, len);
        System.out.println(result);
        baggageLoading.printSelect();

        int[] value = {1, 2, 3, 4, 5, 6};
        BaggageLoading baggageMaxValue = new BaggageLoading(arr, value);
        int resultMaxValue = baggageMaxValue.baggageMaxValue(T, len);
        System.out.println("resultMaxValue:" + resultMaxValue);
        baggageMaxValue.printSelect();
    }
}
