package 字符串;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author WangXu
 * @date 2019/5/13 0013 - 20:46
 */
public class Solution_字符流中第一个不重复的字符 {
    public static void main(String[] args) {
        Solution_字符流中第一个不重复的字符 s = new Solution_字符流中第一个不重复的字符();
        String st = "google";
        for (int i = 0; i < st.length(); i++) {
            s.Insert(st.charAt(i));
            System.out.print(s.FirstAppearingOnce());
        }
        for (int i = 0; i < st.length(); i++) {
            s.OtherInsert(st.charAt(i));
            System.out.print(s.OtherFirstAppearingOnce());
        }

    }

    LinkedHashMap<Character, Boolean> map = new LinkedHashMap<Character, Boolean>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.keySet().contains(ch)) {
            map.put(ch, true);
        } else {
            if (map.get(ch)) {
                map.replace(ch, false);
            }
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (map.isEmpty()) {
            return '#';
        } else {
            for (Map.Entry<Character, Boolean> entry : map.entrySet()
            ) {
                if (entry.getValue()) {
                    return entry.getKey();
                }
            }
        }
        return '#';
    }

    int[] count = new int[256];
    int temp = 1;
    //Insert one char from stringstream
    public void OtherInsert(char ch)
    {
        if (count[ch] == 0) {
            count[ch] = temp++;
        } else {
            count[ch] = -1;
        }
    }
    //return the first appearence once char in current stringstream
    public char OtherFirstAppearingOnce()
    {
        int min = temp;
        int index = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] <= min){
                min = count[i];
                index = i;
            }
        }
        if (index == -1) {
            return '#';
        } else {
            return (char)index;
        }

    }
}
