package byted;

import java.util.ArrayList;

import java.util.List;

/**
 * 139 单词拆分
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
 * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 *
 */
public class Main71 {

//    public boolean wordBreak(String s, List<String> wordDict) {
//        return help(s, wordDict);
//    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] ss = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> l = new ArrayList<>();
        for (String str: ss){
            l.add(str);
        }
        System.out.println(wordBreak(s, l));
    }

    /**
     * 超出时间限制
     */
    public static boolean  wordBreak(String s, List<String> wordDict){
        if (s.length()==0)
            return true;
        for (String word: wordDict){
            if (s.startsWith(word)){
                s= s.substring(word.length());
                if (wordBreak(s, wordDict))
                    return true;
                s = word+s;
            }
        }
        return false;
    }

}