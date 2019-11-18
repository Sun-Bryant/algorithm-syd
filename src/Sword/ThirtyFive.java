package Sword;


/**
 * 35、数组中的逆序对
 *
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 *    题目保证输入的数组中没有的相同的数字
 *    数据范围：
 *       对于%50的数据,size<=10^4
 *       对于%75的数据,size<=10^5
 *       对于%100的数据,size<=2*10^5
 * 示例1
 *  输入:1,2,3,4,5,6,7,0
 *  输出:7
 */
public class ThirtyFive {

    /**
     * 思路：在归并排序的过程中，找到逆序对。
     *      注意：在求解的过程中，数值可能过大，所以在求解过程中就需要取余。
     *
     * 运行时间：647ms
     * 占用内存：54240k
     */
    public static int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSort(array, 0, array.length - 1) % 1000000007;
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return (mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r)) % 1000000007;
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] > arr[p2] ? (m - p1 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (res >= 1000000007) {
                res = res % 1000000007;
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }
}
