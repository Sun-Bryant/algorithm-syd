package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class LeetCode_015 {

    /**
     * 思路 -- 双指针
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为nums[L]和nums[R]，
     * 计算三个数的和sum判断是否满足为0，满足则添加进结果集
     *
     * 如果 nums[i]大于 0，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
     * 时间复杂度：O(n^2)，n为数组长度
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);// 排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;// 去重
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    while(start < end && nums[start] == nums[start + 1]) {// 去重
                        start++;
                    }
                    while(start < end && nums[end] == nums[end - 1]) {// 去重
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                }
            }
        }
        return ans;
    }
}
