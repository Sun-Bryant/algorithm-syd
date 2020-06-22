package LeetCode;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class LeetCode_031 {

    /**
     * 算法过程
     * 标准的“下一个排列”算法可以描述为：
     *
     * 1、从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 2、在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 3、将 A[i] 与 A[k] 交换
     * 4、可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 5、如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     *
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int i = len - 2, j = len -1 , k = len - 1;
        while(i>=0 && nums[i] >= nums[j]){ // 从后往前 寻找第一个nums[i] < nums[j]
            i--;
            j--;
        }

        if(i >= 0){ // 不是最后一个排列
            // 寻找第一个nums[k] > nums[i]
            while(nums[i]>=nums[k]){
                k--;
            }

            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }

        // 逆序 j - end;
        int end = len - 1;
        while(j < end){
            int temp = nums[j];
            nums[j++] = nums[end];
            nums[end--] = temp;
        }
    }
}
