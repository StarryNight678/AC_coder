import java.util.Arrays;

/**
 * create by  ZhouJianhua  2017/9/3
 * Email: zjhua678@163.com
 */
public class Test {

    public static void main(String[] args) {
        String str = "E:\\V1R2\\product\\fpgadrive.c";

        String[] strArrKey = str.split("\\\\");
        System.out.println(Arrays.toString(strArrKey));

    }
}
