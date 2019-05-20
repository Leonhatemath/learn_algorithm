package 抽象建模能力;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/5/8 0008 - 20:44
 */
public class Solution_圆圈中最后剩下的数 {
    public static void main(String[] args) {

    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        ArrayList<Integer> kids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            kids.add(i);
        }
        int index = 0;
        while (kids.size() > 1) {
            index = (index + m - 1) % kids.size();
            kids.remove(index);
        }
        return kids.get(0);
    }
}
