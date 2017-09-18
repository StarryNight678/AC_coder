package HuaWei;

import java.util.Scanner;

/**
 * create by  ZhouJianhua  2017/9/3
 * Email: zjhua678@163.com
 */
public class PassWord {

    /*

    题目描述
    密码要求:
    1.长度超过8位
    2.包括大小写字母.数字.其它符号,以上四种至少三种
    3.不能有相同长度超2的子串重复

    说明:长度超过2的子串

    输入描述:
    一组或多组长度超过2的子符串。每组占一行
    输出描述:
    如果符合要求输出：OK，否则输出NG
     */
    String fun(String s1) {
        char[] strArr = s1.toCharArray();
        //1.长度超过8位
        if (s1.length() <= 8) {
            return "NG";
        }
        //2.包括大小写字母.数字.其它符号,以上四种至少三种
        int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
        for (int i = 0; i < strArr.length; i++) {

            if (strArr[i] >= 'A' && strArr[i] <= 'Z') {
                n1 = 1;
            } else if (strArr[i] >= 'a' && strArr[i] <= 'z') {
                n2 = 1;
            } else if (strArr[i] >= '0' && strArr[i] <= '9') {
                n3 = 1;
            } else {
                n4 = 1;
            }
        }
        if (n1 + n2 + n3 + n3 < 3) {
            return "NG";
        }

        //3.不能有相同长度超2的子串重复
        for (int i = 0; i < s1.length() - 3; i++) {
            String m1 = s1.substring(i, i + 3);
            String m2 = s1.substring(i + 3, s1.length());
            if (m2.contains(m1)) {
                return "NG";
            }
        }
        return "OK";
    }

    public static void main(String[] args) {
        PassWord main = new PassWord();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(main.fun(str));

        }
    }
}



