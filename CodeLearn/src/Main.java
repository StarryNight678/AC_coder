import java.util.*;

/**
 * create by  ZhouJianhua  2017/9/2
 * Email: zjhua678@163.com
 */
public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            strArr[i] = str;
        }

        Arrays.sort(strArr);

        for (int i = 0; i < n; i++) {
            System.out.println(strArr[i]);
        }


    }
}
