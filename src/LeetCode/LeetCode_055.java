package LeetCode;

public class LeetCode_055 {

    /**
     * 考虑官方给的例子
     *  输入: [3,2,1,0,4]
     *  输出: false
     *  解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     * 可以总结出，当你不管怎么跳，都要经过0时，也就是0是你的必经之路时，是跳不出去数组的。
     * 所以只要找到一条可以跳出0 的路径，那么就可以跳跃到最后一位。
     *
     * 那么如何判断是否能跳出0呢？设当前0的索引为index，用i遍历index-1至0，找到一个数大于index-i即可跳出0
     */
    public boolean canJump(int[] nums) {
        //注意 i<nums.length-1;
        //因为题意是跳到最后一位，也就是说即使最后一位是0，例如[2,1,0]，如果最后一个0加入判断的话，这个0肯定跳不出去。但是你不需要跳出去。
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == 0) {
                if(passzero(nums, i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    // 判断是否可以跳过当前的0;
    private boolean passzero(int[] nums, int index) {
        for (int i = index; i >=0; i--) {
            if (nums[i] > (index - i)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 贪心
     * 我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置x，
     * 如果它在最远可以到达的位置的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，
     * 因此我们可以用 x+nums[x] 更新 最远可以到达的位置。
     *
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，那就说明最后一个位置可达，
     * 我们就可以直接返回 True 作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     */
//    public boolean canJump(int[] nums) {
//        int maxRight = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i <= maxRight) { // 不能超过当前最大可达距离
//                maxRight = Math.max(maxRight, i + nums[i]);
//                if (maxRight >= (nums.length - 1)) return true;
//            }
//        }
//        return false;
//    }

}
