package 画图让抽象形象化;

import java.util.ArrayList;

/**
 * @author WangXu
 * @date 2019/4/17 0017 - 10:54
 */
public class Solution_顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Solution_顺时针打印矩阵 s = new Solution_顺时针打印矩阵();
        ArrayList<Integer> result = s.printMatrix(matrix);
        for (Integer num : result
        ) {
            System.out.print(num);
        }
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int m = matrix.length;//矩阵的行数
        int n = matrix[0].length;//矩阵的列数
        ArrayList<Integer> result = new ArrayList<>();
        int TotalCount = m * n;//矩阵的大小
        boolean Line = true;//每次读取的是一行或者是一列
        int lastfixindex = 0;//上一次的固定的行或者列的下标
        int fixindex = 0;//每次读取一行或者一列开始的那个数字的下标
        boolean Increase = true;//每次都一行或者一列的下标是递增或者递减的
        int num = n;//每次读取一行或者一列的长度
        int count = 0;//记录每次的长度应该是行数或者列数减去多少
        while (result.size() < TotalCount) {
            ArrayList<Integer> subarr = GetSubArr(matrix, lastfixindex, fixindex, Increase, Line, num);
            result.addAll(subarr);
            if (Increase) {
                lastfixindex = fixindex + 1;
                fixindex = lastfixindex + num - 2;
            } else {
                lastfixindex = fixindex - 1;
                fixindex = lastfixindex + num - 1;
            }
            Line = !Line;
            if (!Line) {
                count++;
            }
            if (Line) {
                Increase = !Increase;
                num = n - count;
            } else {
                num = m - count;
            }
        }
        return result;
    }

    public ArrayList<Integer> GetSubArr(int[][] matrix, int lastfixindex, int fixindex, boolean Increase, boolean Line, int num) {
        ArrayList<Integer> subarr = new ArrayList<>();
        if (Increase) {
            for (int i = lastfixindex; i < lastfixindex + num; i++) {
                subarr.add(GetNum(matrix, fixindex, i, Line));
            }
        } else {
            for (int i = lastfixindex; i > lastfixindex - num; i--) {
                subarr.add(GetNum(matrix, fixindex, i, Line));
            }
        }
        return subarr;
    }

    public Integer GetNum(int[][] matrix, int fixindex, int index, boolean Line) {
        if (Line) {
            return matrix[fixindex][index];
        } else {
            return matrix[index][fixindex];
        }
    }
}
