import java.util.*;

public class Main {


    int fun(int n, int m, int[] w) {


        if (m >= n) {
            int max = w[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, w[i]);
            }
            return max;
        }

        int t = 0;
        int[] q = new int[m];
        int count = 0;
        while (count != n) {

            for (int i = 0; i < m; i++) {
                if (q[i] == 0 && count <= (n - 1)) {
                    q[i] = w[count];
                    count++;
                }
                q[i]--;
            }
            t++;
        }

        int max1 = 0;
        for (int i = 1; i < m; i++) {
            max1 = Math.max(max1, q[i]);
        }
        t = t + max1;

        return t;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] w = new int[n];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();

            }


            System.out.println(main.fun(n, m, w));


        }


    }
}