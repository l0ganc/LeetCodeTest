package Amazon_OA2;

import java.util.HashSet;

public class LC819MostCommonWord {

//    public static String mostCommonWord(String paragraph, String[] banned) {
//        HashSet<String> set = new HashSet<>();
//        for (String s : banned) {
//            set.add(s);
//        }
//
////        for (int i = 0; i < paragraph.length(); i++) {
////
////        }
//    }
    public static void main(String[] args) {
        String s = "a, a, a, a, b,b,b,c, c";
        s = s.replaceAll("\\pP"," ");
        String[] str = s.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i].toLowerCase());
        }



    }
}
