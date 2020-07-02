package LeetCode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class LeetCode_034 {

    public int[] searchRange(int[] nums, int target) {
        int left = process(nums, target);
        int right = process(nums, target + 1);
        if (left == nums.length || nums[left] != target) { //这表明数组中不存在target
            return new int[]{-1, -1};
        }
        return new int[] {left, right - 1}; //否则数组中存在target，则b-1是最后一个target的元素索引
    }

    //该二分查找nums中第一个>=target的元素位置
    private int process(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {  //需要注意细节
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }
        return start;
    }
}
