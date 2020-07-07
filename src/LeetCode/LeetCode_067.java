package LeetCode;

import java.util.Stack;

public class LeetCode_067 {

    /**
     * 我写的代码
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int jin = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0) {
            int v1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int v2 = (j >= 0) ? b.charAt(j) - '0' : 0;
            int val = (v1 + v2 + jin) % 2;
            jin = (v1 + v2 + jin) / 2;
            stack.push(val);
            i--;
            j--;
        }
        if (jin == 1) {
            stack.push(jin);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 大佬写的代码
     */
//    public String addBinary(String a, String b) {
//        StringBuilder ans = new StringBuilder();
//        int ca = 0;
//        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? a.charAt(i) - '0' : 0;
//            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            ans.append(sum % 2);
//            ca = sum / 2;
//        }
//        ans.append(ca == 1 ? ca : "");
//        return ans.reverse().toString();
//    }


}
