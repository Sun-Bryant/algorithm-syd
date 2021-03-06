package Sword;

/**
 * 44、翻转单词顺序列
 *
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class FortyFour {

    /**
     *
     * 运行时间：21ms
     * 占用内存：9392k
     */
    public static String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().equals("")) {  //因为并不清楚str里到底有几个空字符

            return str;
        }
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >0; i--) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));

    }
}
