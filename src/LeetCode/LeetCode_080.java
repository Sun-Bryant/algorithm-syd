package LeetCode;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode_080 {

    // 双指针
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int pre = nums[0];
        int len = 1; // 删除循环后当前数组的长度，也是下一个不重复数字的插入位置。
        int count = 1; // 计数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                if (count < 2) {
                    pre = nums[i];
                    nums[len++] = nums[i];
                    count++;
                } else if (count > 2) {
                    pre = nums[i];
                    count++;
                    continue;
                }
            } else {
                pre = nums[i];
                nums[len++] = nums[i];
                count = 1;
            }
        }
        return len;
    }
}
