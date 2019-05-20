package 知识迁移能力;

import java.math.BigDecimal;

/**
 * @author WangXu
 * @date 2019/4/9 0009 - 19:44
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
    }
}
