package LeetCode;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class LeetCode_088 {

    // 这道题从前到后找最小，从后往前找最大
    // 双指针 从后往前找最大
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[end--] = nums1[p1];
                p1--;
            } else {
                nums1[end--] = nums2[p2];
                p2--;
            }
        }
        if (p1 < 0) {
            while(p2 >= 0) {
                nums1[end--] = nums2[p2];
                p2--;
            }
        }
        if (p2 < 0) {
            while(p1 >= 0) {
                nums1[end--] = nums1[p1];
                p1--;
            }
        }
    }

    // 双指针  从前往后找最小
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] temp = new int[m];
//        for (int i = 0; i < m; i++) temp[i] = nums1[i];
//        int count = 0;
//        int p1 = 0;
//        int p2 = 0;
//        while (p1 < m && p2 < n) {
//            if (temp[p1] <= nums2[p2]) {
//                nums1[count++] = temp[p1];
//                p1++;
//            } else {
//                nums1[count++] = nums2[p2];
//                p2++;
//            }
//        }
//        if (p1 == m) {
//            while (p2 < n) {
//                nums1[count++] = nums2[p2];
//                p2++;
//            }
//        }
//        if (p2 == n) {
//            while (p1 < m) {
//                nums1[count++] = temp[p1];
//                p1++;
//            }
//        }
//    }
}
