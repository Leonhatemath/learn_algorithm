package 知识迁移能力;


/**
 * @author WangXu
 * @date 2019/4/10 0010 - 20:52
 */
public class Solution_数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        int k = 3;
        Solution_数字在排序数组中出现的次数 s = new Solution_数字在排序数组中出现的次数();
        System.out.println(s.GetNumberOfK(array, k));
        System.out.println(s.Other_GetNumberOfK(array, k));
    }
    //自己的
    public int GetNumberOfK(int [] array , int k) {
        int result = 0;
        int index = GetIndexOfK(array, k);
        if (index != -1) {
            result ++;
            int i = index - 1;
            int j = index + 1;
            while (j < array.length && array[j] == k) {
                result++;
                j++;
            }
            while (i >= 0 && array[i] == k) {
                result++;
                i--;
            }
        }
        return result;
    }

    private int GetIndexOfK(int[] array, int k) {
        int i = 0;
        int j = array.length - 1;
        int result = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (array[mid] == k) {
                result = mid;
                return result;
            } else if (array[mid] < k) {
                i = mid;
            } else {
                j = mid;
            }
        }
        return result;
    }

    //别人的
    public int Other_GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstIndex = GetFirstIndex(array, k, 0, length - 1);
        int lastIndex = GetLastIndex(array, k);
        if (firstIndex != -1 && lastIndex != -1) {
            return lastIndex - firstIndex + 1;
        }
        return 0;
    }

    private int GetFirstIndex(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return GetFirstIndex(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return GetFirstIndex(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return GetFirstIndex(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    private int GetLastIndex(int[] array, int k) {
        int i = 0;
        int j = array.length - 1;
        int result = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (array[mid] < k) {
                i = mid + 1;
            } else if (array[mid] > k) {
                j = mid - 1;
            } else if (mid + 1 < array.length && array[mid + 1] == k) {
                i = mid + 1;
            } else {
                result = mid;
                return result;
            }
        }
        return result;
    }

}
