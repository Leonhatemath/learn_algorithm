package 递归和循环;

/**
 * @author WangXu
 * @date 2019/3/28 0028 - 20:23
 */
public class 变态跳台阶 {
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法。*/
    public static void main(String[] args) {
        //分析发现f(n) = 2*f(n-1)
        int target = 10;
        System.out.println(JumpFloorII_one(target));
        System.out.println(JumpFloorII_two(target));
    }

    //迭代
    public static int JumpFloorII_one(int target) {
        if (target <= 0) {
            return 0;
        }
        int n = 1;
        while (target-- > 1) {
            n = 2 * n;
        }
        return n;
    }

    //递归
    public static int JumpFloorII_two(int target) {
        if(target <= 0){
            return -1;
        }else if(target == 1){
            return 1;
        }else{
            return 2 * JumpFloorII_two(target - 1);
        }
    }
}
