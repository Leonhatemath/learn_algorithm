package 字符串;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/5/13 0013 - 16:28
 */
public class Solution_表示数值的字符 {
    public static void main(String[] args) {
        Solution_表示数值的字符 s = new Solution_表示数值的字符();
        ArrayList<String> input = new ArrayList<>(){
            {
                add("+100");
                add("5e2");
                add("-123");
                add("3.1416");
                add("-1E-16");
                add("12e");
                add("1a3.14");
                add("1.2.3");
                add("+-5");
                add("12e+4.3");
            }
        };
        for (String str : input
        ) {

            System.out.print(str + ":");
            char[] c = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                c[i] = str.charAt(i);
            }
            System.out.println(s.isNumeric(c));
        }


    }

    public boolean isNumeric(char[] str) {
        ArrayList<Character> num = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            num.add(String.valueOf(i).charAt(0));
        }
        int length = 0;
        char[] symbol = {'-', 'e', 'E','.','+'};
        ArrayList<Character> symbols = new ArrayList<>();
        for (char s : symbol
        ) {
            symbols.add(s);
        }
        boolean flag = true;
        //第一位数字只能为正负号或者是数字
        if (str[0] == '+' || str[0] == '-') {
            length = 1;
        } else if (!num.contains(str[0])) {
            return false;
        }
        for (int i = 1; i < str.length; i++) {
            if (num.contains(str[i])) {
                length = 0;
            } else if (symbols.contains(str[i])) {
                if (i + 1 == str.length){
                    //非数字字母为最后一位的话，直接返回false
                    return false;
                }
                length++;//记录非数字字母连续出现的长度
                if (length > 2) {
                    //非数字字母长度超过2直接返回false
                    return false;
                }
                if (str[i] == 'e' || str[i] == 'E') {
                    //如果出现e或者E，把.的flag变成false
                    flag = false;
                } else if (str[i] == '.') {
                    //.只能在e的左边出现
                    if (flag) {
                        flag = false;
                    } else {
                        return false;
                    }
                } else {//如果是-或者+号
                    if (length == 2 && (str[i - 1] == 'e' || str[i - 1] == 'E')) {
                        //长度为2的非数字字母只允许出现e-与E-,其余全部返回false
                        //还要把.的计数变成0，即不允许出现.
                        continue;
                    } else {
                        return false;
                    }

                }
            } else {
                return false;
            }
        }
        return true;
    }
}
