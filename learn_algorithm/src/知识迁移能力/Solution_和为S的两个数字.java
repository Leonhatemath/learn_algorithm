package 知识迁移能力;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/4/15 0015 - 20:57
 */
public class Solution_和为S的两个数字 {
    public static void main(String[] args) {
        Solution_和为S的两个数字 s = new Solution_和为S的两个数字();
        int[] array = {2, 5, 7, 10};
        int sum = 12;
        ArrayList<Integer> arr = s.FindNumbersWithSum(array, sum);
        for (Integer i : arr
        ) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length == 0 || sum == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int mid = sum / 2;
        int length = array.length - 1;
        for (int i = 0; array[i] < mid; i++) {
            int sub = sum - array[i];
            for (int j = length; array[j] > mid; j--) {
                if (array[j] == sub) {
                    arr.add(array[i]);
                    arr.add(array[j]);
                    return arr;
                }
            }
        }
        return arr;
    }

    public ArrayList<Integer> Other_FindNumbersWithSum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        while (i < j) {
            if (array[i] + array[j] == sum) {
                arr.add(array[i]);
                arr.add(array[j]);
                break;
            }
            while (i < j && array[i] + array[j] > sum) {
                --j;
            }
            while (i < j && array[i] + array[j] < sum) {
                ++i;
            }
        }
        return arr;
    }
}