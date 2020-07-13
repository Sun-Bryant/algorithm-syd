package LeetCode;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *  
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class LeetCode_079 {

    // 回溯
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(board, word, 0, i, j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int len, int i ,int j){
        // 先判断当前位置是否越界以及是否相等，越界或不相等直接返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(len)) {
            return false;
        }
        // 如果最后一位也相等了， 返回true;
        if (len == word.length() - 1) {
            return true;
        }
        // 做选择
        char temp = board[i][j];
        board[i][j] = '.'; // 避免重复寻找
        // 递归
        boolean res1 = dfs(board, word, len + 1, i + 1, j); // 向下寻找
        boolean res2 = dfs(board, word, len + 1, i - 1, j); // 向上寻找
        boolean res3 = dfs(board, word, len + 1, i, j + 1); // 向右寻找
        boolean res4 = dfs(board, word, len + 1, i, j - 1); // 向左寻找
        if (res1 || res2 || res3 || res4) { // 如果有一条路径可达，返回true。
            return true;
        }
        // 撤销选择
        board[i][j] = temp; // 回溯，回复现场。
        return false;
    }
}
