package 时间空间效率的平衡;

/**
 * @author WangXu
 * @date 2019/4/29 0029 - 20:58
 */
public class Solution_数组中的逆序对 {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        Solution_数组中的逆序对 s = new Solution_数组中的逆序对();
        System.out.println(s.InversePairs(array));
    }

    public int InversePairs(int [] array) {
        int len = array.length;
        if (array == null || len == 0) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = array[i];
        }

        int count = InversePairsCore(array, copy, 0, len - 1);
        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        //先把数组分成两份，再每次分成两份，最后从最前面的两个数开始操作，依次递归回来
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftcount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightcount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            //从左边的数组的尾部开始向左移动，把大于左边数组的每个数的右边的数加进来到copy
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            //先把左边的数组中剩余的数加进来到copy
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            //再把右边的数组中剩余的数加进到copy
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            //把刚刚排序操作过的copy中的数放到array中，等下次重新操作
            array[s] = copy[s];
        }
        return (leftcount + rightcount + count) % 1000000007;
    }
}
