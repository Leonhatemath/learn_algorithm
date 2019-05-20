package 综合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangXu
 * @date 2019/3/28 0028 - 21:02
 */
public class 将字符串转换成整数 {
    /*将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
    但是string不符合数字要求时返回0)，
    要求不能使用字符串转换整数的库函数。
    数值为0或者字符串不是一个合法的数值则返回0。*/
    public static void main(String[] args) {
        String[] str = {"+21", "la33", "", "-3332"};
        for (String substr : str
        ) {
            int result = StrToInt(substr);
            System.out.println(result);
        }
    }

    public static int StrToInt(String str) {
        Map<Character, Integer> num = new HashMap<Character,Integer>(){{
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
        }};
        if (str == null || str.length() == 0) {
            return 0;
        }
        String firs = str.substring(0, 1);
        boolean flag = true;
        if ("+".equals(firs)) {
            str = str.substring(1, str.length());
        } else if ("-".equals(firs)) {
            str = str.substring(1, str.length());
            flag = false;
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (num.containsKey(letter)) {
                result *= 10;
                result += num.get(letter);
            } else {
                return 0;
            }
        }
        if (flag) {
            return result;
        } else {
            return -result;
        }
    }
}
