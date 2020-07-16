package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class LeetCode_090 {

    // 回溯 + 去重   注意需要先排序
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, nums, 0, path);
        return ans;
    }

    public void dfs (List<List<Integer>> ans, int[] nums, int begin, List<Integer> path){
        ans.add(new ArrayList(path));
        for (int i = begin; i < nums.length; i++) {
            // 去重
            if (i > begin && nums[i] == nums[i - 1]) continue;
            // 做选择
            path.add(nums[i]);
            // 递归
            dfs(ans, nums, i + 1, path);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
