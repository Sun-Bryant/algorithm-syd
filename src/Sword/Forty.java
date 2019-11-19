package Sword;

/**
 * 40、数组中只出现一次的数字
 *
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Forty {

    /**
     * 思路：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     *      当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     *      所以按照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。我们首先还是先异或，异或结果（sum）肯定是A、B异或的结果，
     *      找到最右边位是1的位数，并以此分组。A和B必然分开，因为异或的结果 如果该位为1，则A和B该位必然不同。
     *      假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
     *      然后把第三位是1的组依次异或，异或结果就是这两个只出现一次的数字中的一个（假设为A）。
     *      最后将A与sum异或，就可以得到第二个只出现一次的数字。
     *
     * 运行时间：34ms
     * 占用内存：9536k
     */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    // 公式1：0^N = N  公式2：N^N = 0
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int sum = 0, summ = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        // 找到第一个位是1的位数，并以此分组。A和B必然分开，因为异或的结果 如果该位为1，则A和B该位必然不同。
        int index = sum & (~sum + 1); // 提取出最右边的1
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & index) != 0) {
                summ ^= array[i];
            }
        }
        num1[0] = summ;
        num2[0] = sum ^ num1[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 5, 6, 3, 2};// 1,4
        int num1[] = new int[1];
        int num2[] = new int[1];
        FindNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
