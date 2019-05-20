package 抽象建模能力;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/5/11 0011 - 9:56
 */
public class Solution_扑克牌顺子 {
    public static void main(String[] args) {

    }

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0 || numbers == null) {
            return false;
        }
        int min = 14;
        int max = 0;
        ArrayList<Integer> copy = new ArrayList<>();
        ArrayList<Integer> contain = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            contain.add(i);
        }
        for (int i : numbers
        ) {
            if (contain.contains(i)) {
                if (copy.contains(i)) {
                    return false;
                } else {
                    copy.add(i);
                }
                if (i > max) {
                    max = i;
                }
                if (i < min) {
                    min = i;
                }
            } else {
                continue;
            }
        }
        if (min == max || max - min <= 4) {
            return true;
        } else {
            return false;
        }
    }
}
