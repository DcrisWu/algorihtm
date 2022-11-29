package daily.year_2022.August;

public class august_10 {
    public static void main(String[] args) {
        System.out.println(solveEquation("x=x+2"));
    }

    public static String solveEquation(String equation) {
        String s1 = equation.substring(0, equation.lastIndexOf("="));
        String s2 = equation.substring(equation.lastIndexOf("=") + 1);
        int index = 0;
        int left = 0;
        int l = 0;
        while (index < s1.length()) {
            StringBuilder sb = new StringBuilder("");
            if (s1.charAt(index) == '-' || s1.charAt(index) == '+') {
                sb.append(s1.charAt(index));
                index++;
            }
            boolean judge = false;
            while (index < s1.length() && s1.charAt(index) != '-' && s1.charAt(index) != '+') {
                if (s1.charAt(index) == 'x') {
//                    sb.isEmpty()
                    if (sb.equals("") || sb.toString().equals("+")) {
                        left += 1;
                    } else if (sb.toString().equals("-")) {
                        left += -1;
                    } else {
                        left += Integer.parseInt(sb.toString());
                    }
                    index++;
                    judge = true;
                    break;
                }
                sb.append(s1.charAt(index));
                index++;
            }
            if (!judge) {
//                l.add(sb.toString());
                l += Integer.parseInt(sb.toString());
            }
        }
        int r_index = 0;
        int right = 0;
//        List<String> r = new ArrayList<>();
        int r = 0;
        while (r_index < s2.length()) {
            StringBuilder sb = new StringBuilder("");
            if (s2.charAt(r_index) == '-' || s2.charAt(r_index) == '+') {
                sb.append(s2.charAt(r_index));
                r_index++;
            }
            boolean judge = false;
            while (r_index < s2.length() && s2.charAt(r_index) != '-' && s2.charAt(r_index) != '+') {
                if (s2.charAt(r_index) == 'x') {
//                    sb.isEmpty()
                    if (sb.equals("") || sb.toString().equals("+")) {
                        right += 1;
                    } else if (sb.toString().equals("-")) {
                        right += -1;
                    } else {
                        right += Integer.parseInt(sb.toString());
                    }
                    r_index++;
                    judge = true;
                    break;
                }
                sb.append(s2.charAt(r_index));
                r_index++;
            }
            if (!judge) {
//                r.add(sb.toString());
                r += Integer.parseInt(sb.toString());
            }
        }
        left = left - right;
        r = r - l;
        if (left == 0) {
            if (left != r) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        } else {
            return "x=" + String.valueOf(r / left);
        }

    }
}
