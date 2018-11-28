public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        sb.insert(0, 'a');
        sb.insert(2, 'c');
        sb.insert(1, 'd');
        System.out.println(sb.toString());
    }
}
