package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class LeetCode_046 {

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList list = new ArrayList<>();
        process(nums, list);
        return ans;
    }

    private static void process(int[] nums, List<Integer> path) {
        if (nums.length == path.size()) { //base case
            ans.add( new ArrayList<>(path));
        }
        // 尝试每一个数字作为第一个
        for (int i = 0; i < nums.length; i++) {
            // 排除不正确的选择
            if(path.contains(nums[i])){
                continue;
            }
            // 做选择
            path.add(nums[i]);
            // 递归
            process(nums, path);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        System.out.println(ans);
    }
}
