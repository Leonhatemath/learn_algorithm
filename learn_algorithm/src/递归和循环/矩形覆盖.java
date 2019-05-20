package 递归和循环;

/**
 * @author WangXu
 * @date 2019/3/28 0028 - 20:48
 */
public class 矩形覆盖 {
    /*我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
    请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/
    public static void main(String[] args) {
        /*分析n时，要不然竖着放小方块，那就是f(n-1)
        * 如果横着放小方块，那就是f(n-2)
        * 所以f(n)=f(n-1)+f(n-2)，斐波那契数列*/
        int target = 10;
        System.out.println(RectCover(target));
    }

    public static int RectCover(int target) {
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
