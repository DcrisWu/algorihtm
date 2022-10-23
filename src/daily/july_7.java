package daily;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class july_7 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();//{"cat", "bat", "rat"};
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("a");
        dictionary.add("rat");
        dictionary.add("chds");

        String sentence = "the cattle was rattled by the battery";
        july_7 july_7 = new july_7();
        System.out.println(july_7.replaceWords(dictionary, sentence));
    }

    public String replaceWords(List<String> adictionary, String sentence) {
        HashSet<String> dictionary = new HashSet<>();
        for (String s : adictionary) {
            dictionary.add(s);
        }
        //表示起始位置
        int start = 0;
        StringBuilder temp = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        System.out.println(temp);
        System.out.println(ans);
        while (start < sentence.length()) {
            //如果当前的字符不是空格
            if (sentence.charAt(start) != ' ') {
                temp.append(sentence.charAt(start));
                //如果匹配到一个根
                if (dictionary.contains(temp.toString())) {
                    //ans.append(temp);//将这个根放进去
                    //ans.append(' ');//加一个空格
//                    temp = null;
                    while (start < sentence.length() && sentence.charAt(start) != ' ' ) {
                        start++;
                    }
                } else {
                    //如果没有找到匹配的根
                    start++;//右移一位
                }
            } else {
                //如果是空格
                ans.append(temp);
                temp = new StringBuilder("");
                ans.append(' ');
                start++;
            }
        }
        ans.append(temp);
        return ans.toString();
    }
}