package Sword;

/**
 * 66、机器人的运动范围
 *
 * 题目描述
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class SixtySix {

    /**
     *
     * 核心思路：
     * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，返回4个方向的探索值之和 + 1。
     *
     * 2.探索时，判断当前节点是否可达的标准为：
     *  1）当前节点在矩阵内；
     *  2）当前节点未被访问过；
     *  3）当前节点满足limit限制。
     *
     * 3.
     * 运行时间：19ms
     * 占用内存：9260k
     *
     */
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        return judge(0, 0, rows, cols, flag, threshold);
    }

    //judge(索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，标志字符串，阈值)
    private static int judge(int i,int j,int rows,int cols,boolean[][] flag,int threshold){

        //递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == true) {
            return 0;
        }
        //要走的当前位置置为true，表示已经走过了
        flag[i][j] = true;

        //回溯，递归寻找，
        return judge(i - 1, j, rows, cols, flag, threshold)
                + judge(i + 1, j, rows, cols, flag, threshold)
                + judge(i, j - 1, rows, cols, flag, threshold)
                + judge(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private static int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(18, 50, 50));
    }
}

