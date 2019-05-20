package 栈和队列;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/4/22 0022 - 21:32
 */
public class Solution_滑动窗口的最大值 {
    public static void main(String[] args) {
        Solution_滑动窗口的最大值 s = new Solution_滑动窗口的最大值();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> result = s.maxInWindows(num, size);
        for (Integer e : result
        ) {
            System.out.println(e + ",");
        }
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if (size == 0 || size > num.length) {
            //两种特例
            return arr;
        }
        Integer max = num[0];
        int MaxIndex = 0;
        for (int i = 1; i < num.length; i++) {
            if (i < size) {
                //窗口大小还没到滑动的时候
                if (max < num[i]) {
                    max = num[i];
                    MaxIndex = i;
                }
            } else {
                arr.add(max);
                if (max <= num[i]) {
                    //新进来的这一位数字比前面的max值还要大，直接添加这个数字
                    max = num[i];
                    MaxIndex = i;
                }
                if (i - size + 1 > MaxIndex) {
                    //新进来的数字比max小但是前面的max的在窗口之外，重新寻找最大值
                    max = num[i - size + 1];
                    for (int j = i - size + 1; j <= i; j++) {
                        if (max < num[j]) {
                            max = num[j];
                            MaxIndex = j;
                        }
                    }
                }
                if (i == num.length - 1) {
                    //如果是最后一次，不会添加而是直接跳出，所以要添加
                    arr.add(max);
                }
            }
        }
        if (arr.size() == 0) {
            //有num长度正好跟size相等的情况，算特例
            arr.add(max);
        }
        return arr;
    }
}
