package 知识迁移能力;

import java.util.HashMap;

/**
 * @author WangXu
 * @date 2019/4/15 0015 - 16:06
 */
public class Solution_数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        Solution_数组中只出现一次的数字 s = new Solution_数组中只出现一次的数字();
        s.FindNumsAppearOnce(array, num1, num2);

        //测试:数组中有一个数字只有一次，其他的数字都有三次（或者四次，五次都可以）
        int[] a = {2, 2, 2, 7};
        System.out.println(s.Other_FindNumsAppearOnce(a,3));
        int[] b = {3, 3, 3, 3, 9};
        System.out.println(s.Other_FindNumsAppearOnce(b,4));
    }

    //这是自己的思路
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> NumCount = new HashMap<>();
        for (int num : array
        ) {
            if (NumCount.containsKey(num)) {
                NumCount.remove(num);
            } else {
                NumCount.put(num, 1);
            }
        }
        int count = 0;
        for (Integer key : NumCount.keySet()
        ) {
            if (count == 0) {
                num1[0] = key;
            } else {
                num2[0] = key;
            }
            count++;
        }
        System.out.println("num1[0]=" + num1[0]);
        System.out.println("num2[0]=" + num2[0]);
    }

    public int Other_FindNumsAppearOnce(int [] a,int n) {
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % n !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }
}
