package LeetCode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LeetCode_127 {

    /**
     * 本题其实就是一个抽象的图结构。
     *
     * 一句话题解
     * 无向图中两个顶点之间的最短路径的长度，可以通过广度优先遍历得到；
     * 为什么 BFS 得到的路径最短？可以把起点和终点所在的路径拉直来看，两点之间线段最短；
     *
     * 首先检查wordList是否存在endWord， 若不存在wordList则无解。
     * 新建boolean类型的数组visited[]，数组长度为wordList的大小，用以标记wordList中的字符串是否被访问。
     * 新建一个Queue<Pair<String,Integer>>,队列以 字符串+转换次数为组合元素进行储存，然后将beginWord , 1的组合加入队列。
     * 接下来开始进行广度优先搜索，队列中的每一个元素都代表一条不同的路径。
     * 对于每次取出的元素 ，都对应路径的转换次数steps以及路径最后的节点last。 然后在wordList中遍历。
     * 如果该元素访问过，则直接跳过；
     * 如果该元素满足转换规则
     * 如果该元素等于endWord,则直接返回 steps+1
     * 不等于endWord则将其加入队列中，并将该元素标志为已访问
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //判断列表中是否存在 endWord
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // 标志是否已经访问过的数组
        boolean []visited = new boolean[wordList.size()];
        // BFS的队列
        Queue<Pair<String,Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            int steps = queue.peek().getValue();
            String last= queue.peek().getKey();
            queue.poll();
            for (int i = 0; i < wordList.size(); i++) {
                if(visited[i])continue;
                if(transformCheck(last,wordList.get(i))) {
                    if(endWord.equals(wordList.get(i)))return steps+1;
                    queue.add(new Pair<>(wordList.get(i),steps+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }

    // 两个字符串是否可以通过改变一个字母后相等
    boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }
}
