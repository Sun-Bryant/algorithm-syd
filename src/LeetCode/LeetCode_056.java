package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class LeetCode_056 {

    /**
     * 解题思路
     * 1.首先根据二维数组中每个一维数组的[0]进行升序排序，即根据start进行排序；
     * 2.合并条件是前一个的结束 大于等于 后一个的开始
     * 3.然后建立linkedList作为中间处理对象，当集合为空或者不满足条件，加入集合的末尾；
     * 4.集合不为空且满足合并条件时，取集合中最后一个元素让它的end为原值和合并区间end中的最大值，解决1,5;2,4这样的区间问题。
     * 5.集合处理完成，对其循环遍历取首元素，放入res结果数组中
     *
     */
    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, new MyComparator());
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //集合为空，或不满足合并条件，向后新增
            if (list.size() == 0 || list.get(list.size() - 1)[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else { //满足条件，集合最后元素的end=最大值
                int maxx=  Math.max(list.get(list.size() - 1)[1],intervals[i][1]);
                list.get(list.size() - 1)[1] = maxx;
            }
        }
        int[][] ans = new int[list.size()][2]; //生成结果数组
        for (int i = 0 ; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
