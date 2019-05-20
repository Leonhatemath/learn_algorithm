import java.lang.annotation.Repeatable;

/**
 * @author WangXu
 * @date 2019/3/9 0009 - 11:24
 */
public class 替换空格 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("helloworld ");
        Solution s = new Solution();
        System.out.println(s.replaceSpace(str));

    }

    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            if (str == null || str.length() == 0) {
                return str.toString();
            }
            boolean flag;
            for (int i = 0; i <= str.length() - 1; i += (flag == true) ? 3 : 1) {
                flag = false;
                char c = str.charAt(i);
                if (c == ' ') {
                    str.replace(i, i, "%20");
                    str.deleteCharAt(i + 3);
                    flag = true;
                }
            }
            return str.toString();
        }
    }
}
