package TowardsOffer2.day_21_前缀树.code_064_神奇的字典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * completion time = 2022.11.1
 * 可以用字典树，数据量大的时候，有优势
 */
class MagicDictionary {

    private Map<Integer, List<String>> map;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            map.putIfAbsent(s.length(), new ArrayList<>());
            map.get(s.length()).add(s);
        }
    }

    public boolean search(String searchWord) {
        if (!map.containsKey(searchWord.length())) {
            return false;
        }
        List<String> strings = map.get(searchWord.length());
        for (String string : strings) {
            if(searchWord.equals(string)){
                continue;
            }
            int count = 0;
            for (int i = 0; i < searchWord.length(); i++) {
                if (searchWord.charAt(i) != string.charAt(i)) {
                    count++;
                    if(count > 1){
                        break;
                    }
                }
            }
            if(count == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}