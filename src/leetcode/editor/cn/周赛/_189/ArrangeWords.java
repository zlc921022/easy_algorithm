package leetcode.editor.cn.周赛._189;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :

 句子的首字母大写
 text 中的每个单词都用单个空格分隔。
 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。

 请同样按上述格式返回新的句子。

 示例 1：
     输入：text = "Leetcode is cool"
     输出："Is cool leetcode"
     解释：句子中共有 3 个单词，长度为 8 的 "Leetcode" ，长度为 2 的 "is" 以及长度为 4 的 "cool" 。
     输出需要按单词的长度升序排列，新句子中的第一个单词首字母需要大写。

 示例 2：
     输入：text = "Keep calm and code on"
     输出："On and keep calm code"
     解释：输出的排序情况如下：
     "On" 2 个字母。
     "and" 3 个字母。
     "keep" 4 个字母，因为存在长度相同的其他单词，所以它们之间需要保留在原句子中的相对顺序。
     "calm" 4 个字母。
     "code" 4 个字母。
 */
public class ArrangeWords {

    public String arrangeWords(String text) {
        String[] strings = text.split(" ");
        Collections.sort(Arrays.asList(strings), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String s = Arrays.toString(strings);
        // 全部转化为小写
        s = s.toLowerCase();
        // 去除[,]
        s = s.substring(1, s.length() - 1).replace(",","");
        StringBuilder sb  = new StringBuilder();
        // 第一个单词的第一个字母大写
        sb.append(strings[0].substring(0, 1).toUpperCase())
                .append(strings[0].substring(1,strings[0].length()))
                .append(s.substring(strings[0].length(),s.length()));
        return sb.toString();
    }

    public void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        String sb = arrangeWords("Leetcode is cool");
        System.out.println(sb);
    }

}