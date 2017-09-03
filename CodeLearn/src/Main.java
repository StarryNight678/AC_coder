import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * create by  ZhouJianhua  2017/9/3
 * Email: zjhua678@163.com
 */
public class Main {

    /*
    题目描述
    现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
    每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量，问能称出多少中不同的重量。

    注：
    称重重量包括0

    方法原型：public static int fama(int n, int[] weight, int[] nums)

    输入描述:
    输入包含多组测试数据。

    对于每组测试数据：

    第一行：n --- 砝码数(范围[1,10])

    第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])

    第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
    输出描述:
    利用给定的砝码可以称出的不同的重量数
    示例1
    输入

    2
    1 2
    2 1
    输出

    5
     */
    public static int fama(int n, int[] weight, int[] nums) {


        return 0;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> hashSet = new HashSet<>();

        while (sc.hasNext()) {
            hashSet.clear();
            int N = sc.nextInt();
            int[] weight = new int[N];
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                num[i] = sc.nextInt();
            }


        }
    }
}



