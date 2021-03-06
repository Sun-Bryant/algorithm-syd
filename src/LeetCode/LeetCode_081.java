package LeetCode;

/**
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * 进阶:
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class LeetCode_081 {

    /**
     * 解题思路：
     * 本题是需要使用二分查找，怎么分是关键，举个例子：
     * 第一类
     * 10111 和 11101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
     * 第二类
     * 2 3 4 5 6 7 1 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第三类
     * 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
     * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
     */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return false;
        int start = 0;
        int end = nums.length - 1;
        // 说白了，就是无限分割永远都在有序的序列里面找。
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[start]) { // 说明出现重复数字
                start++;
                continue;
            }
            if (nums[start] <= nums[mid]) { // 左半部分有序
                if (target >= nums[start] && target < nums[mid]) { // target在左半部分
                    end = mid - 1;
                } else { //否则，去右半部分找
                    start = mid + 1;
                }
            } else { // 右半部分有序
                if (target > nums[mid] && target <= nums[end]) { //target在右半部分
                    start = mid + 1;
                } else {  //否则，去左半部分找
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
