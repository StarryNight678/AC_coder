import java.util.*;

public class Main {


    double fun(int n, int m) {


        double  result=0;
        double p=n;
        for (int i = 0; i < m; i++) {

            p=Math.sqrt(p);
            result+=p;

        }

        return result;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(main.fun(n, m));
        }


    }
}