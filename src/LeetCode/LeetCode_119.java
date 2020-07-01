package LeetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class LeetCode_119 {

    /**
     * 总的来说就是利用杨辉三角形后一行与前一行的关系。
     * 更新过程为：从倒数第二个元素开始往前更新 它等于原来这个位置的数 + 前一个位置的数
     * 行[i] = 行[i] + 行[i-1]
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0) {
            return ans;
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--){
                ans.set(j, ans.get( j - 1) + ans.get(j));
            }
            ans.add(1);
        }
        return ans;
    }
}
