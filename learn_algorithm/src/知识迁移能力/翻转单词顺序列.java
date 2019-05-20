package 知识迁移能力;

import java.sql.SQLOutput;

/**
 * @author WangXu
 * @date 2019/4/10 0010 - 20:04
 */
public class 翻转单词顺序列 {
    public static void main(String[] args) {
        Solution_six s6 = new Solution_six();
        String s = "student. a am I";
        System.out.println(s6.ReverseSentence(s));
    }
}

class Solution_six {
    public String ReverseSentence(String str) {
        if (str.trim().length() == 0) {
            return str;
        }
        str = str.trim();
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
