package string;

import java.util.Arrays;

/**
 * 字符串匹配
 * <p>
 * create by ZhouJianhua 2017/8/28
 */
public class Kmp {

    /**
     * 基本比配模式
     *
     * @param str
     * @param pattern
     * @return
     */
    int basic(String str, String pattern) {

        char[] strCharArr = str.toCharArray();
        char[] patternCharArr = pattern.toCharArray();
        int m = str.length();
        int n = pattern.length();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (strCharArr[i] == patternCharArr[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == n) {
            return i - j;
        }
        return -1;
    }

    /**
     * 产生netxt数组
     *
     * @param pattern
     */
    void genNext(String pattern, int[] next) {
        char[] patternCharArr = pattern.toCharArray();
        int len = pattern.length();
        int j = 0;
        int k = -1;
        next[j] = k;

        while (j < len - 1) {
            if (k == -1 || patternCharArr[k] == patternCharArr[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    /**
     * kmp算法
     *
     * @param str
     * @param pattern
     * @return
     */
    int kmp(String str, String pattern, int[] next) {

        char[] strCharArr = str.toCharArray();
        char[] patternCharArr = pattern.toCharArray();
        int m = str.length();
        int n = pattern.length();

        int i = 0, j = 0;
        while (i < m && j < n) {

            //注意 j==-1
            if (j == -1 || strCharArr[i] == patternCharArr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == n) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "ababcabcacbab";
//        String pattern = "abcac";
        String pattern = "aabcaac";
        System.out.println(str);
        System.out.println(pattern);
        Kmp kmp = new Kmp();
        int pos = kmp.basic(str, pattern);
        System.out.println(pos);

        int[] next = new int[pattern.length()];
        kmp.genNext(pattern, next);
        System.out.println("next[]:" + Arrays.toString(next));
        int posKmp = kmp.kmp(str, pattern, next);
        System.out.println(posKmp);
    }

}
