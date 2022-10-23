package BasicJava;

public class StringLearn {
    public static void main(String[] args) {
        String a = "abcd";
        String s = a.concat("efgh");
        System.out.println(s);

        System.out.println(s.lastIndexOf('a'));

        String b = " aaa ";
        System.out.println(b.length());
        System.out.println(b.trim().length());
        //replace方法是将所有的‘a’都更换成'm'
        System.out.println(b.replace('a', 'm'));


    }
}
