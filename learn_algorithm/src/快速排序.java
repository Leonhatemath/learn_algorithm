import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/3/13 0013 - 20:37
 */
public class 快速排序 {
    public static void main(String[] args) {
        Integer[] arr = {34, 3, 53, 2, 23, 7, 14, 10};
        int low = 0;
        int high = arr.length - 1;
        quicksort(arr, low, high);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int getMiddle(Integer[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] > temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void quicksort(Integer[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            quicksort(arr, low, middle - 1);
            quicksort(arr, middle + 1, high);
        }
    }

}
