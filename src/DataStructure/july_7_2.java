package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class july_7_2 {
    public static List<Integer> partitionLabels(String s) {
        int len = s.length();
        //dic表示字典，下标表示字母，值表示最后一次出现该字母的位置
        int[] dic = new int[26];
        Arrays.fill(dic, -1);
        for (int i = 0; i < len; i++) {
            dic[s.charAt(i) - 'a'] = i;
        }
        int begin = 0;
        //index表示当前下标
        int index = begin;
        int end;
        ArrayList<Integer> ans = new ArrayList<>();
        while (begin < len && index < len) {
            //cha表示当前指向的字符
//            char cha = s.charAt(index);
            System.out.println(s.charAt(begin));
            end = dic[s.charAt(index)-'a'];
            System.out.println(end);
            index += 1;
            boolean rec = false;
            while (index < end) {
                int tem_end = dic[s.charAt(index) - 'a'];
                if (tem_end > end) {
                    end = tem_end;
                    rec = true;
                    break;
                }
                index++;
            }
            if (!rec) {
                System.out.println(end);
                //n表示当前字符串的长度
                //end表示cha最后一次出现的位置
                int n = end - begin + 1;
                ans.add(n);
                begin = end+1;
                index = begin;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (Integer ababcbacadefegdehijhklij : partitionLabels("ababcbacadefegdehijhklij")) {
            System.out.println(ababcbacadefegdehijhklij);
        }
    }
}
