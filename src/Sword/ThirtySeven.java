package Sword;

/**
 * 37、数字在排序数组中出现的次数
 *
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class ThirtySeven {

    /**
     * 因为array中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。
     *
     * 运行时间：20ms
     * 占用内存：9468k
     */
    public static int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }

    private static int biSearch(int[] array, double k) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            }
        }
        return low;
    }


    /**
     * 思路：（1）二分查找的方法查找k值，如果存在则记录，如果不存在，则返回0
     *      （2）两个指针p1、p2指向二分查找后返回的k值所在位置，分别向两边查找相同的值。
     *
     * 运行时间：18ms
     * 占用内存：8964k
     */
//    public static int GetNumberOfK(int [] array , int k) {
//        int len = array.length;
//        int location = getKLocationByBinary(array, 0, len-1, k);
//        if (location == -1) {
//            return 0;
//        }
//        int p1, p2;
//        p1 = location;
//        p2 = location;
//        while (p1 != 0) {
//            if (array[p1] == k) {
//                p1--;
//            } else {
//                p1++;
//                break;
//            }
//        }
//        if (array[0] == k) {
//            p1 = 0;
//        }
//        while (p2 != (len-1)) {
//            if (array[p2] == k) {
//                p2++;
//            } else {
//                p2--;
//                break;
//            }
//        }
//        if (array[len - 1] == k) {
//            p2 = len - 1;
//        }
//        return p2 - p1 + 1;
//
//    }
//
//    public static int getKLocationByBinary(int[] array, int low, int high, int k) {
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (array[mid] > k) {
//                high = mid - 1;
//            } else if (array[mid] < k) {
//                low = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,3,3};
        System.out.println(GetNumberOfK(arr, 3));
    }

}
