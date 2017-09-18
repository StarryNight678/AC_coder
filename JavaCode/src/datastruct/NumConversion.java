package datastruct;

import java.util.LinkedList;

/**
 * 进制转换
 * create by ZhouJianhua 2017/8/29
 * Email: zjhua678@163.com
 */
public class NumConversion {
    LinkedList<Integer> linkedList = new LinkedList<>();
    void numCon(int num, int s) {
        while (num>0) {
            int m = num % s;
            linkedList.push(m);
            num=num/s;
        }
        System.out.println("["+num+"] "+"In "+s+" Digital system");
        while (!linkedList.isEmpty()){
            int tmp= linkedList.pop();
            System.out.print(tmp+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NumConversion nc = new NumConversion();
        nc.numCon(13, 2);
        nc.numCon(32, 16);
    }
}
