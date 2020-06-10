package LeetCode;

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
