package meeting.GuangfaBank.code_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class main {
    private HashSet<String>[] prefix;

    public String getTypeOfMobilePhoneNumber(String mobilePhoneNumber) {
        String[] names = {"ChinaMobile", "ChinaUnicom", "ChinaTelecom", "ChinaBroadNet"};
        int[][] begin = {
                {139, 138, 137, 136, 135, 134, 147, 159, 158, 157, 151, 152, 150, 182, 188, 187},
                {130, 131, 132, 145, 155, 156, 186, 185},
                {133, 1349, 153, 189, 180},
                {190, 197, 196, 192}
        };
        prefix = new HashSet[4];
        Arrays.setAll(prefix, e -> new HashSet<>());
        for (int i = 0; i < 4; i++) {
            for (int num : begin[i]) {
                prefix[i].add(String.valueOf(num));
            }
        }
        for (int i = 0; i < mobilePhoneNumber.length(); i++) {
            if (!Character.isDigit(mobilePhoneNumber.charAt(i))){
                return "Invalid";
            }
        }
        int check = check(mobilePhoneNumber);
        if (check == -1) {
            return "Invalid";
        } else if (check == 0){
            return names[0];
        }else {
            return "";
        }
    }

    public int check(String s) {
        if (s.length() == 12) {
            if (s.charAt(0) == '0') {
                s = s.substring(1);
            } else {
                return -1;
            }
        } else if (s.length() == 14) {
            String substring = s.substring(0, 3);
            if (substring.equals("086")) {
                s = s.substring(3);
            } else {
                return -1;
            }
        }
        if (s.length() == 11) {
            String pr = s.substring(0, 4);
            if (prefix[2].contains(pr)) {
                return 2;
            }
            pr = s.substring(0, 3);
            for (int i = 0; i < prefix.length; i++) {
                if (prefix[i].contains(pr)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
