import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataConvert {

    private static List<String> convert(List<String> dates) {
        List<String> res = new ArrayList<>();

        HashMap<String, String> DDmap = new HashMap<>();
        DDmap.put("1st", "01");
        DDmap.put("2nd", "02");
        DDmap.put("3rd", "03");
        DDmap.put("4th", "04");
        DDmap.put("5th", "05");
        DDmap.put("6th", "06");
        DDmap.put("7th", "07");
        DDmap.put("8th", "08");
        DDmap.put("9th", "09");
        DDmap.put("10th", "10");
        DDmap.put("11th", "11");
        DDmap.put("12th", "12");
        DDmap.put("13th", "13");
        DDmap.put("14th", "14");
        DDmap.put("15th", "15");
        DDmap.put("16th", "16");
        DDmap.put("17th", "17");
        DDmap.put("18th", "18");
        DDmap.put("19th", "19");
        DDmap.put("20th", "20");
        DDmap.put("21th", "21");
        DDmap.put("22th", "22");
        DDmap.put("23th", "23");
        DDmap.put("24th", "24");
        DDmap.put("25th", "25");
        DDmap.put("26th", "26");
        DDmap.put("27th", "27");
        DDmap.put("28th", "28");
        DDmap.put("29th", "29");
        DDmap.put("30th", "30");
        DDmap.put("31th", "31");

        HashMap<String, String> MMmap = new HashMap<>();
        MMmap.put("Jan", "01");
        MMmap.put("Feb", "02");
        MMmap.put("Mar", "03");
        MMmap.put("Apr", "04");
        MMmap.put("May", "05");
        MMmap.put("Jun", "06");
        MMmap.put("Jul", "07");
        MMmap.put("Aug", "08");
        MMmap.put("Sep", "09");
        MMmap.put("Oct", "10");
        MMmap.put("Nov", "11");
        MMmap.put("Dec", "12");

        for (String date : dates) {
            String[] split = date.split("\\s+");
            res.add(split[2] + "-" + MMmap.get(split[1]) + "-" + DDmap.get(split[0]));
        }
        return res;

    }
    public static void main(String[] args) {
        List<String> dates = Arrays.asList("1st Mar 1984", "2nd Feb 2013", "4th Apr 1900");
        List<String> res = convert(dates);
        for (String date : res) {
            System.out.println(date);
        }
    }
}
