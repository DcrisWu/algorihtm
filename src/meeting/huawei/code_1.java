package meeting.huawei;

import java.util.*;

public class code_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Set<Integer> ports = new HashSet<>();
        for(int i = 0;i < m;i++){
            ports.add(sc.nextInt());
        }
        List<Long> ans = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            long node = sc.nextLong();
            int c = sc.nextInt();
            boolean isAdd = false;
            for(int j = 0;j<c;j++){
                int p = sc.nextInt();
                if(!isAdd && ports.contains(p)){
                    isAdd = true;
                }
            }
            if(isAdd){
                ans.add(node);
            }
        }
        ans.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1-o2);
            }
        });
        System.out.println(ans.size());
        for(int i = 0;i<ans.size()-1;i++){
            System.out.print(ans.get(i));
            System.out.print(" ");
        }
        if(ans.size() > 0){
            System.out.print(ans.get(ans.size()-1));
        }
    }
}
