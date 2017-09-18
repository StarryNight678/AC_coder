package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * create by  ZhouJianhua  2017/9/6
 * Email: zjhua678@163.com
 */
public class Input {

    public static void main(String[] args) throws IOException {

        Input main = new Input();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();
        while (null != str) {
            int n = Integer.parseInt(str);
            System.out.println(n);
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Double.parseDouble(bufferedReader.readLine());
                System.out.println(arr[i]);
            }
            str = bufferedReader.readLine();
        }


        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextDouble();
            }

        }
        */

    }
}
