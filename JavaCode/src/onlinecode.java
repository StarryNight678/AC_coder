package src;

/**
 * create by  ZhouJianhua  2017/9/6
 * Email: zjhua678@163.com
 */
public class onlinecode {

/*
刷题准备

scanner
关于nextLine（）和next()的使用 关键在于：next() 方法遇见第一个有效字符（非空格，换行符）时，
开始扫描，当遇见第一个分隔符或结束符(空格或换行符)时，结束扫描。 这时使用nextLine()，
继续读，有可能读入第一个字符是空格或换行符。
推荐使用next()
取整问题

ceil的英文意义是天花板，该方法就表示向上取整，Math.ceil（11.3）的结果为12，
Math.ceil(-11.6)的结果为-11；floor的英文是地板，该方法就表示向下取整，
Math.floor(11.6)的结果是11，Math.floor(-11.4)的结果-12；

        舍掉小数取整:Math.floor(2)=2
        舍掉小数取整:Math.floor(2.1)=2
        舍掉小数取整:Math.floor(2.5)=2
        舍掉小数取整:Math.floor(2.9)=2
        凑整:Math.ceil(2)=3
        凑整:Math.ceil(2.1)=3
        凑整:Math.ceil(2.5)=3
        凑整:Math.ceil(2.9)=3
        舍掉小数取整:Math.floor(-2)=-3
        舍掉小数取整:Math.floor(-2.1)=-3
        舍掉小数取整:Math.floor(-2.5)=-3
        舍掉小数取整:Math.floor(-2.9)=-3
        凑整:Math.ceil(-2)=-2
        凑整:Math.ceil(-2.1)=-2
        凑整:Math.ceil(-2.5)=-2
        凑整:Math.ceil(-2.9)=-2
        最难掌握的是round方法，他表示“四舍五入”，算法为Math.floor(x+0.5),
        即将原来的数字加上0.5后再向下取整，所以，Math.round(11.5)的结果是12，
        Math.round(-11.5)的结果为-11 .Math.round( )符合这样的规律：小数点后大于5全部加，等于5正数加，小于5全不加。

        舍掉小数取整:Math.round(2)=2
        舍掉小数取整:Math.round(2.1)=2
        舍掉小数取整:Math.round(2.5)=3
        舍掉小数取整:Math.round(2.9)=3
        舍掉小数取整:Math.round(-2)=-2
        舍掉小数取整:Math.round(-2.1)=-2
        舍掉小数取整:Math.round(-2.5)=-2
        舍掉小数取整:Math.round(-2.9)=-3
        输入数据

        int n = sc.nextInt();

        do {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //注意一定要换行
            sc.nextLine();
            double[][] rectangle = new double[n][m];
            for (int i = 0; i < n; i++) {
                String[] conten = sc.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    conten[0].charAt(0)
                    rectangle[i][j] = Double.parseDouble(conten[j]);
                    Double.valueOf(conten[j]).doubleValue();
                }
            }
            //处理函数
            fish();
        } while (sc.hasNext());
        如何将字串 String 转换成整数 int?

        A. 有两个方法:

        1). int i = Integer.parseInt([String]); 或 i = Integer.parseInt([String],[int radix]);

        2). int i = Integer.valueOf(my_str).intValue();

        注: 字串转成 Double, Float, Long 的方法大同小异.

                如何将整数 int 转换成字串 String ?

                A. 有3种方法: 1.) String s = String.valueOf(i);
                2.) String s = Integer.toString(i);
                3.) String s = "" + i; 注: Double, Float, Long 转成字串的方法大同小异.

                获取字符串的特定位置char

        String conten;
        conten[0].charAt(0)
        输出格式化

        System.out.println(String.format("%.3f", double );
        数组长度

        int[] aa=new int[3][4];
        aa.length  为3
        aa[0].length  为4
                - 格式化
        System.out.println(String.format("%.3f", double );
        - 输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {}
        int n = sc.nextInt();
        sc.nextLine();
        String str;  char [] arr=str.toCharArray();
        - Map
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.containsKey(a);
        tm.put(a, c + b);
        for (Integer m : tm.keySet()) {
            System.out.println(m + " " + tm.get(m));
        }
        - 数组排序
        int [] arr={3,4,7,8,2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        - 获取字符串的特定位置char
        String ss="abc";        ss.charAt(0);
        - 如何将整数 int 转换成字串 String ? (Double, Float, Long)
        String s = String.valueOf(i);
        String s = Integer.toString(i);
        String s = "" + i;
        - 如何将字串 String 转换成整数 int?
        int i = Integer.parseInt([String]);
        int i = Integer.valueOf(my_str);
        - ArrayList
        ArrayList<Integer> List = new ArrayList<>();
        List.add(5);List.add(2);List.add(7);List.add(9);List.add(3);
        Collections.sort(List);
        Collections.sort(List, new Comparator() {
            public int compare(Object o1, Object o2) {
                return (Integer)o2 - (Integer)o1;
            }
        });
// System.out.println(List.toString());
for (Integer s : List)  {
 System.out.println(s);
}
        */

//String 类
/*
startsWith()和endsWith()　　startsWith()方法决定是否以特定字符串开始，endWith()方法决定是否以特定字符串结束
dexOf()和lastIndexOf()
　　indexOf() 查找字符或者子串第一次出现的地方。
　　lastIndexOf() 查找字符或者子串是后一次出现的地方。
 */

    public static void main(String[] args) {


        String s1 = " a bcd e  fg  hi ";
        String s2 = "abcd";

        //indexOf
        System.out.println(s1.indexOf("b"));//3
        System.out.println(s1.indexOf("m"));//-1
        //startsWith
        System.out.println(s1.startsWith(" a"));//true
        System.out.println(s1.startsWith("mn"));// false
        //substring
        System.out.println(s1.substring(1, 3));//   s1[1] s1[2]
        //replace
        System.out.println(s1.replace("b", "m"));//amcdefghi
        //contains
        System.out.println(s1.contains("gh"));//true
        System.out.println(s1.contains("mm"));//false

        //trim 去掉首尾的空格
        String d = s1.trim();//
        System.out.println(s1.trim());

        //split

        String[] strArr1=s1.split(" ");
        System.out.println("------------------");
        for(String s:strArr1){
            System.out.println("["+s+"]");
        }
        //[]
        //[a]
        //[bcd]
        //[e]
        //[]
        //[fg]
        //[]
        //[hi]
        //去除空格
        String[] strArr2=s1.trim().split("\\s+");
        System.out.println("------------------");
        for(String s:strArr2){
            System.out.println("["+s+"]");
        }
        //[a]
        //[bcd]
        //[e]
        //[fg]
        //[hi]

        //100以内质数表
//        2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
//        53 59 61 67 71 73 79 83 89 97
    }
}
