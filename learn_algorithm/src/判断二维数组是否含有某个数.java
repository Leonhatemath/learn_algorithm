/**
 * @author WangXu
 * @date 2019/3/7 0007 - 15:04
 */
public class 判断二维数组是否含有某个数 {
    public static void main(String[] args) {

    }

    public class Solution {
        public boolean Find(int target, int [][] array) {
            if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
                return false;
            }
            if (array[0][0] > target || array[array.length - 1][array[0].length - 1] < target) {
                return false;
            }
            for (int[] subarray :array
            ) {
                if (subarray[0] <= target || subarray[subarray.length - 1] >= target) {
                    int i = 0;
                    int j = subarray.length - 1;
                    while (i < j) {
                        if (subarray[i] == target || subarray[j] == target) {
                            return true;
                        } else if (subarray[(i + j) / 2] <= target) {
                            i = (i + j) / 2;
                        } else {
                            j = (i + j) / 2;
                        }
                        if (i == j - 1) {
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
            return false;
        }
    }
}
