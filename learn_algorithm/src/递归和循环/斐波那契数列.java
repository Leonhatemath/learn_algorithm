package 递归和循环;

/**
 * @author WangXu
 * @date 2019/3/28 0028 - 11:23
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        int n = 10;
        int result_one = Fibonacci_one(n, 0, 1);
        System.out.println(result_one);
        int result_two = Fibonacci_two(n);
        System.out.println(result_two);
    }

    //递归
    public static int Fibonacci_one(int n, int n1, int n2) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return n2;
        } else {
            return Fibonacci_one(n - 1, n2, n1 + n2);
        }

    }

    //循环迭代
    public static int Fibonacci_two(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int fn1 = 1;
        int fn2 = 1;
        while (n-- > 2) {
            fn2 += fn1;
            fn1 = fn2 - fn1;
        }
        return fn2;
    }
}
