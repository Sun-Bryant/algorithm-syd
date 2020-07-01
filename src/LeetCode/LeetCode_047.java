package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_047 {

    /**
     * 解题思路
     * 本题的基本框架依旧和 46.全排列是一样的，但是加了附加条件，需要做一下剪枝，
     * 首先说一下46. 全排列是怎么做的：
     * 这道题我们需要使用回溯的方法来进行求解。那我们回溯法的解体框架是什么呢，解决一个回溯问题，实际上就是一个决策树的遍历过程。一般来说，我们需要解决三个问题：
     *  路径：也就是已经做出的选择。
     *  选择列表：也就是你当前可以做的选择。
     *  结束条件：也就是到达决策树底层，无法再做选择的条件。
     *
     * 由于本题需要返回所有不重复的全排列，有限制条件，所以需要进行剪枝。这里第一步先要给数组进行排序。
     *  首先，先要给nums进行排序，这样做的目的是方便剪枝
     *  其次，我们已经选择过的不需要再放进去了
     *  接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
     *
     */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        process(nums, path, new boolean[nums.length]);
        return ans;
    }

    private void process(int[] nums, List<Integer> path, boolean[] visited) {
        // base case
        if (nums.length == path.size()) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不正确的选择
            // 如果已经访问过了，则跳过
            if (visited[i]) continue;
            // 如果当前数字和前一个数字一样，并且它的前一个数字已经访问过了，就不要了(使用break效果更好)
            if (i > 0 && nums[i] == nums[i - 1] && visited[i-1]) break;
            // 做选择
            path.add(nums[i]);
            visited[i] = true;
            // 递归
            process(nums, path, visited);
            // 撤销选择
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
