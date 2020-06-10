package LeetCode;

/**
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class LeetCode_011 {

    /**
     * 双指针法
     * 算法流程： 设置双指针 i,j 分别位于容器壁两端，
     * 根据规则移动指针，并且更新面积最大值 ans，直到 i == j 时返回 ans。
     * 指针移动规则与证明： 每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收窄 1 格。
     *
     * 我的代码
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i != j) {
            int s = Math.min(height[i],height[j]) * (j - i);
            ans = Math.max(s, ans);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    /**
     * 大佬的代码
     */
//    public int maxArea(int[] height) {
//        int i = 0, j = height.length - 1, res = 0;
//        while(i < j){
//            res = height[i] < height[j] ?
//                    Math.max(res, (j - i) * height[i++]):
//                    Math.max(res, (j - i) * height[j--]);
//        }
//        return res;
//    }


    public static void main(String[] args) {

    }
}
