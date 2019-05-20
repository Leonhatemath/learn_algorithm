package 知识迁移能力;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/4/9 0009 - 19:26
 */
public class 和为S的连续正数序列 {
    public static void main(String[] args) {
        Solution_one s1 = new Solution_one();
        System.out.println(s1.FindContinuousSequence(100));

        Solution_two s2 = new Solution_two();
        System.out.println(s2.FindContinuousSequence(100));

    }
}

class Solution_one {
    //下面的代码不能通过所有答案，但是解法思路正确
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int half = sum / 2;
        for (int divisor = 2; divisor <= half; divisor++) {
            BigDecimal divi_result = new BigDecimal(Double.toString((double)sum / divisor));
            BigDecimal half_divisor = new BigDecimal(Double.toString((double)divisor / 2));
            BigDecimal base_num = new BigDecimal("1");
            //判断是否被除数在2到除数的一半之间
            if (divi_result.subtract(half_divisor).compareTo(base_num) != -1) {
                int intvalue = divi_result.intValue();
                //获取除数结果的整数部分
                BigDecimal int_divi_result = new BigDecimal(intvalue);
                BigDecimal odd_judge = new BigDecimal("0.00");
                BigDecimal even_judeg = new BigDecimal("0.50");
                int int_half_divisor = divisor / 2;
                //判断是否被除数为奇数并且除得的结果为正整数
                if (divisor % 2 != 0 && divi_result.subtract(int_divi_result).compareTo(odd_judge) == 0) {
                    ArrayList<Integer> odd_result = new ArrayList<>();
                    for (int i = intvalue - int_half_divisor; i <= intvalue + int_half_divisor; i++) {
                        odd_result.add(i);
                    }
                    result.add(odd_result);
                //判断被除数是否为偶数并且除得的结果小数为0.5
                } else if (divi_result.subtract(int_divi_result).compareTo(even_judeg) == 0) {
                    ArrayList<Integer> even_result = new ArrayList<>();
                    for (int i = intvalue - int_half_divisor + 1; i <= intvalue + int_half_divisor; i++) {
                        even_result.add(i);
                    }
                    result.add(even_result);
                }
            }
        }
        return result;
    }
}

class Solution_two {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int n = 2; n < (int) Math.sqrt(2 * sum); n++) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                //这里考虑到偶数长度序列的中值的小数为0.5，那么每个数对余数的贡献就是0.5，0.5*n*2=n就出现了
                ArrayList<Integer> one_result = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    //这里的序列中的值从序列的中值减去序列的长度的一半为起始开始
                    one_result.add(k);
                }
                result.add(one_result);
            }
        }
        return result;
    }
}
