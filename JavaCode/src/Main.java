import java.util.*;


public class Main {

    static void change(int start, int n, int[] arr) {
        for (int i = start; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

    }

    static int fun(int n, int[] arr, int flag) {
        int i = 0;
        for (i = 0; i < n; i++) {
            if (arr[i] != 0)
                break;
        }
        if (i == n) {
            return 0;
        }

        int result = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] == 1) {
                change(j, n, arr);
                result = 1 + fun(n, arr, flag + 1);
                if (0 == flag) {
                    if (result % 2 == 1) {
                        return 1;
                    }
                }

            }
        }
        return result;
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int result = fun(n, arr, 0);

            if (result % 2 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }

        }


    }
}