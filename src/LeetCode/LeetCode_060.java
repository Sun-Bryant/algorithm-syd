package LeetCode;


public class LeetCode_060 {
    /**
     * 只剪枝
     *
     * 思路分析：
     * 比较容易想到的是，使用同第 46 题： “全排列” ，即使用回溯搜索的思想，依次得到全排列，输出所求的第 k 个全排列即可。但事实上，我们不必求出所有的全排列。基于以下几点考虑：
     * 1、我们知道所求排列一定在叶子结点处得到。事实上，进入每一个分支的时候，我们都可以通过递归的层数，直接计算这一分支可以得到的叶子结点的个数；
     * 这是因为：进入一个分支的时候，我们可以根据已经选定的数的个数，进而确定还未选定的数的个数，然后计算阶乘，就知道这一个分支的叶子结点有多少个。
     * 2、如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫“剪枝”；
     * 3、如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解；
     * 4、计算阶乘的时候，你可以使用循环计算，特别注意：0!=1，它表示了没有数可选的时候，即表示到达叶子结点了，排列数只剩下 1 个;
     * 又因为题目中说“给定 n 的范围是 [1, 9]”，故可以实现把从 0 到 9 的阶乘计算好，放在一个数组里，可以根据索引直接获得阶乘值。
     */
    StringBuilder sb =  new StringBuilder();
    String res = "";
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        dfs(0, n , k, visited);
        res = sb.toString();
        return res;
    }
    // 只剪枝，剪枝剪得非常彻底，直达目标。
    public void dfs(int depth, int n, int k, boolean[] visited){
        if (depth == n) {
            return;
        }
        int num = getFactorial(n - 1 - depth); //除去当前这一层，下面的子层有多少种可能。比如当前是第一层，还有俩层，那么每个子层就有2！种可能。
        for (int i = 1; i <=n; i++) {
            if (visited[i - 1]) continue;
            if (num < k) {
                k -= num;
                continue;
            }
            sb.append(i);
            visited[i - 1] = true;
            dfs(depth + 1, n, k, visited);
        }
    }
    private int getFactorial(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n;
            n--;
        }
        return ans;
    }

    /**
     * 剪枝 + 回溯
     */
//    int count = 0;
//    String ans = "";
//    public String getPermutation(int n, int k) {
//        StringBuilder path = new StringBuilder();
//        return process(n, k, new boolean[n], path);
//    }
//    // 只取得前k个解，并且只把第K个path解放进结果
//    public String process(int n, int k, boolean[] visited, StringBuilder path){
//        if (n == path.length()){
//            count++;
//            if (count == k) {
//                ans = path.toString();
//            }
//        }
//        // 从左往右遍历
//        for (int i = 1; i <= n; i++) {
//            if (count >= k) break; // 剪枝（遍历停止）
//            if (!visited[i - 1]){
//                // 做选择
//                visited[i - 1] = true;
//                path.append(i);
//                // 递归
//                process(n, k, visited, path);
//                // 撤销选择
//                visited[i - 1] = false;
//                path.deleteCharAt(path.length() - 1);
//            }
//        }
//        return ans;
//    }
}
