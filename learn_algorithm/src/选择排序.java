import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinPool;

/**
 * @author WangXu
 * @date 2019/3/13 0013 - 21:54
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {34, 3, 53, 2, 23, 7, 14, 10};
        xuanzeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void xuanzeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
