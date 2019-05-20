package 时间空间效率的平衡;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author WangXu
 * @date 2019/4/24 0024 - 10:50
 */
public class Solution_第一个只出现一次的字符 {
    public static void main(String[] args) {
        String str = "google";
        Solution_第一个只出现一次的字符 s = new Solution_第一个只出现一次的字符();
        System.out.println(s.FirstNotRepeatingCharSecond(str));

    }

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        HashMap<Character, ArrayList<Integer>> save = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!save.containsKey(c)) {
                save.put(c, new ArrayList<>(Arrays.asList(i)));
            } else {
                ArrayList<Integer> arr = save.get(c);
                arr.add(i);
                save.replace(c, arr);
            }
        }
        for (Character c : str.toCharArray()
        ) {
            ArrayList<Integer> arr = save.get(c);
            if (arr.size() == 1) {
                return arr.get(0);
            }
        }
        return -1;
    }

    public int FirstNotRepeatingCharSecond(String str) {
        ArrayList<Character> once = new ArrayList<>();
        ArrayList<Character> twice = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (twice.contains(c)) {
                continue;
            } else if (once.contains(c)) {
                once.remove(c);
                twice.add(c);
            } else {
                once.add(c);
            }
        }
        return once.size() == 0 ? -1 : str.indexOf(once.get(0));
    }
}
