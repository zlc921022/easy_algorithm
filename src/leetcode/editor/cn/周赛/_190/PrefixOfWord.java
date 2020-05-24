package leetcode.editor.cn.周赛._190;

import org.junit.Test;

/**
 * @author zlc
 * @created 2020/05/24
 */
public class PrefixOfWord {


    @Test
    public void test() {
        String sentence = "hello from the other side";
        int index = isPrefixOfWord(sentence, "they");
        System.out.println(index);
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" +");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
