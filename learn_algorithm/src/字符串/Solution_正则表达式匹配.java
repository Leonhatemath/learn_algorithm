package 字符串;

/**
 * @author WangXu
 * @date 2019/5/11 0011 - 10:14
 */
public class Solution_正则表达式匹配 {
    public static void main(String[] args) {
        Solution_正则表达式匹配 s = new Solution_正则表达式匹配();
//        char[] str = {'a', 'a', 'a'};
//        char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] str = {'a'};
        char[] pattern = {'.', '*'};
        System.out.println(s.match(str,pattern));

    }

    public boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        if (pattern.length == 0 && str.length != 0) {
            return false;
        }
        int strIndex = 0;
        int patIndex = 0;
        return matchCore(str, strIndex, pattern, patIndex);

    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patIndex) {
        //所有的str与pattern都被匹配到了最后一位
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        //str没有匹配完，而pattern没有了，说明整体并不匹配，返回false
        if (strIndex != str.length && patIndex == pattern.length) {
            return false;
        }
        //str匹配完了而pattern没有匹配完，这个时候仍然属于普通匹配的情况
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            //pattern下一位是*：
            //如果str的第一个字符与pattern的第一个字符不匹配，pattern后移两个字符，继续匹配
            //如果str的第一个字符与pattern的第一个字符匹配，那么有一下三种情况：
            //1.pattern后移两位，即x*被忽略
            //2.str后移一位，而pattern后移两位
            //3.str后移一位，pattern不变，继续匹配str的下一位，即*匹配大于一位
            if (strIndex != str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
                //考虑输入str为0的情况
                return matchCore(str, strIndex, pattern, patIndex + 2) || matchCore(str, strIndex + 1, pattern, patIndex + 2) || matchCore(str, strIndex + 1, pattern, patIndex);
            }else{
                return matchCore(str, strIndex, pattern, patIndex + 2);
            }
        }
        if (strIndex != str.length) {
            //pattern的下一位不是*，分两种情况：
            //如果str的第一个字符和pattern的第一个字符相匹配，都移动一位，继续匹配
            //如果不匹配，直接返回false
            if (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.') {
                return matchCore(str, strIndex + 1, pattern, patIndex + 1);
            } else {
                return false;
            }
        }
        return false;
    }
}
