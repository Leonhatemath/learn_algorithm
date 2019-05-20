package 递归和循环;

/**
 * @author WangXu
 * @date 2019/3/28 0028 - 20:19
 */
public class 跳台阶 {
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/
    public static void main(String[] args) {
        int result = JumpFloor(10);
        System.out.println(result);
    }

    public static int JumpFloor(int target) {
        //分析发现就是一个斐波那契数列求解
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        while(target-- > 2){
            n2 += n1;
            n1 = n2 - n1;
        }
        return n2;
    }
}
