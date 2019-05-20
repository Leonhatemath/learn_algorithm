package 树;

import java.util.LinkedList;

/**
 * @author WangXu
 * @date 2019/4/22 0022 - 20:06
 */
public class Solution_数据流中的中位数 {
    public static void main(String[] args) {

    }

    //这只是个功能函数，不是完整的得到数据流的函数
    LinkedList<Integer> list = new LinkedList<>();
    public void Insert(Integer num) {
        if (list.size() == 0) {
            list.add(num);
        } else {
            boolean InsertFlag = false;
            int index = 0;
            while (index < list.size())  {
                if (num < list.get(index)) {
                    list.add(index, num);
                    InsertFlag = true;
                    break;
                }
                index++;
            }
            if (!InsertFlag) {
                list.addLast(num);
            }
        }
    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }
        int len = list.size();
        if (len % 2 != 0) {
            return (double)list.get(len / 2);
        } else {
            return (double)(list.get(len / 2) + list.get(len / 2 - 1)) / 2;
        }
    }
}
