package LeetCode;

public class LeetCode_033 {
    /**
     * 解题思路：
     * 题目要求 O(logN) 的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键。
     *
     *  由于题目说数字了无重复，举个例子：
     * 1 2 3 4 5 6 7 可以大致分为两类，
     * 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
     * 这种情况下，前半部分有序。因此如果 nums[start] <= target <nums[mid]，则在前半部分找，否则去后半部分找。
     * 第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
     * 这种情况下，后半部分有序。因此如果 nums[mid] < target <= nums[end]，则在后半部分找，否则去前半部分找。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        // 说白了，就是无限分割永远都在有序的序列里面找。
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            // 注意此处用小于等于,比如只剩两个数[2、1].我们使用小于等于是为了准确的判断前半部分2和后半部分1。
            if (nums[start] <= nums[mid]) { // 左半部分有序
                if(target >= nums[start] && target < nums[mid]) { // target在左半部分
                    end = mid -1;
                } else { // target不在左半部分
                    start = mid + 1;
                }
            } else{ // 右半部分有序
                if (target > nums[mid] && target <=nums[end]) { // target在右半部分
                    start = mid + 1;
                } else { // target不在左半部分
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
