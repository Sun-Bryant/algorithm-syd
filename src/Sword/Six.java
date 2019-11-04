package Sword;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 6、旋转数组的最小数字
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 递增排列：1,2,3,4,5
 * 递减排列 ：5,4,3,2,1
 * 非递减排列 ：1,2,3,3,4,5
 * 非递增排列：6,5,5,4,4,3,2,1
 */
public class Six {

    /**
     * 递增排列：1,2,3,4,5
     * 递减排列 ：5,4,3,2,1
     * 非递减排列 ：1,2,3,3,4,5
     * 非递增排列：6,5,5,4,4,3,2,1
     */

    /**
     * 运行时间：309ms
     * 占用内存：28540k
     * 时间复杂度：O(N)
     *
     * 暴力法
     * 由于非递减排序的数组的特性，旋转之后的数组实际上可以大致划分成两个有序的子数组：前面子数组的大小都大于后面子数组中的元素
     * if (array[i] > array[i + 1])的时候成立，说明找到了两个子数组的分界线。即出现了解。
     */
//    public static int minNumberInRotateArray(int [] array) {
//        if (array.length == 0) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0];
//        }
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                return array[i + 1];
//            } else {  // 优化一点点
//                if (i == array.length - 2) {
//                    return array[0];
//                }
//            }
//        }
//        return 0;
//    }

    /**
     * 运行时间：369ms
     * 占用内存：30236k
     * 时间复杂度：O(nlogn)
     *
     * 利用 Arrays 工具类里的排序函数，默认的排序规则是从小到大，排序后的数组第一个值就是最小值
     */
//    public static int minNumberInRotateArray(int [] array) {
//        if (array.length == 0) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0];
//        }
//        Arrays.sort(array);
//        return array[0];
//    }

    /**
     * 运行时间：340ms
     * 占用内存：30888k
     * 时间复杂度：O(n)
     *
     * 将数组元素挨着丢进优先队列，优先队列默认为最小堆，弹出的第一个数就是整个数组的最小值
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) { // 优先队列默认是最小堆，所以弹出的第一个元素就是最小的
            queue.add(array[i]);
        }
        return queue.poll();
    }

    /**
     * 二分查找法
     * 非递减序列并不能找到最小值，因为对于{3, 3, 3, 3, 3, 1, 3} 和 {3, 1,3, 3, 3, 3, 3}，二分法并不能判断范围向哪边收缩
     * https://blog.nowcoder.net/n/dcb0f2e6ffd44e1895b7a5297e362778?f=comment
     */


    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
