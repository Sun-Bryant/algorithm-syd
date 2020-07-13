package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class LeetCode_078 {

    // 回溯
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 0, nums);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int begin, int[] nums) {
        ans.add(new ArrayList(path)); // 因为是选择子集，过程中的节点都是子集，所以直接加入结果集。
        for (int i = begin; i < nums.length; i++) {
            // 做选择
            path.add(nums[i]);
            // 递归
            dfs(ans, path, i + 1, nums); // 注意是i+1
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
