package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class LeetCode_049 {

    //将单词转化成char[]，排序后作为HashMap的key值，value值就是一个List<String>用于存放字母相同的单词
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); //根据String把元素放入对应的ListString
        List<String> list = new ArrayList<>();  // 存放字母一样的单词
        for (int i = 0; i < strs.length; i++) {
            String temp = sortWord(strs[i]);
            if(map.containsKey(temp)) {  // 存在
                list = map.get(temp);
                list.add(strs[i]);
            } else {  // 不存在
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    //用于给单词 按字典顺序排序
    private String sortWord(String word) {
        char[] ch = word.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
