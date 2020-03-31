package Sword;

/**
 * 23、二叉搜索树的后序遍历序列
 *
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class TwentyThree {

    /**
     * 思路：
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     *
     * 运行时间：16ms
     * 占用内存：9616k
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        // sequence数组只有0的时候
        if (sequence.length == 0) {
            return false;
        }
        // sequence数组只有1的时候
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] sequence, int start, int end) {
        // 如果已经递归到单个元素，那么
        if (start >= end) {
            return true;
        }
        int index = start;
        while (sequence[index] < sequence[end]) {
            index++;
        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return judge(sequence, start, index - 1) && judge(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{3, 5, 4, 7, 9, 8, 6};
        System.out.println(VerifySquenceOfBST(sequence));
    }

}
