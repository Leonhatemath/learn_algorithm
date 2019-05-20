package 回溯法;

/**
 * @author WangXu
 * @date 2019/5/13 0013 - 21:46
 */
public class Solution_矩阵中的路径 {
    public static void main(String[] args) {

    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        for (char c : str
        ) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] == c) {
                    matrix[i] = '0';
                }
            }
        }
        return false;
    }
    public boolean subHasPath(char[] matrix,int rows,int cols,char[] str,)


}
