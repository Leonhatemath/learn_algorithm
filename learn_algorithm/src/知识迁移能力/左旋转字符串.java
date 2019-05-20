package 知识迁移能力;

/**
 * @author WangXu
 * @date 2019/4/10 0010 - 19:04
 */
public class 左旋转字符串 {
}

class Solution_three {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }
        int k = n % len;
        StringBuffer strb = new StringBuffer(str);
        String strlef = strb.substring(0, k);
        String stright = strb.substring(k, len);
        StringBuffer strblef = new StringBuffer(strlef);
        StringBuffer strbrig = new StringBuffer(stright);
        String result = strbrig.append(strblef).toString();
        return result;
    }
}

class Solution_four {
    //这是两个都截取然后拼接，用的是delete比substring好
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }
        StringBuffer strb1 = new StringBuffer(str);
        StringBuffer strb2 = new StringBuffer(str);
        strb1.delete(0, n);
        strb2.delete(n, len);
        String result = strb1.append(strb2).toString();
        return result;
    }
}

class Solution_five {
    //这是两个先拼接，然后在截取，这个更快
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }
        StringBuffer strb1 = new StringBuffer(str);
        StringBuffer strb2 = new StringBuffer(str);
        String result = strb1.append(strb2).substring(n, n + len);
        return result;
    }
}