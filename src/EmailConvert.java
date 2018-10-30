import java.util.HashMap;

public class EmailConvert {
    private static int getRes(String[] L) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L.length; i++) {
            String email = L[i];
            int index = email.indexOf('@');
            System.out.println("原始的email is : " + email + "  " + "@ 在下标 : " + index);
            StringBuilder sb = new StringBuilder();
            char firstChar = email.charAt(0);
            if (firstChar != '+') {
                sb.append(firstChar);
            }
            int j = 1;
            for ( ; j < index; j++) {
                if (email.charAt(j) == '.') {

                    continue;
                } else if (email.charAt(j) == '+') {
                    sb.append(email.substring(index));
                    break;
                } else {
                    sb.append(email.charAt(j));
                }
            }
            if (j == index) {
                sb.append(email.substring(index));
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        int res = 0;
        for (String email : map.keySet()) {
            System.out.println("处理好后的 email is " + email + " " + map.get(email)) ;
            if (map.get(email) > 1) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String[] L =
                new String[]{"a.b@example.com", "x@example.com", "x@exa.mple.com",
                        "ab+1@example.com", "y@example.com", "y@example.com", "y@example.com"};

        String[] L2 =
                new String[]{"a.b@example.com", "x@example.com", "x@exa.mple.com",
                        "ab+1@example.com", "y@example.com", "y@example.com", "y@example.com",
                        "dupli......cate@example.com","d.u.p.l.i.c.a.t.e@example.com", "jingssss.....@usc.edu", "safsdf....+...sfd@126.com",
                        "....+-sfds1234@126.com", "-_saf02313...sf+asf..as@gamil.com"};
        int res = getRes(L2);
        System.out.println(res);
    }
}
