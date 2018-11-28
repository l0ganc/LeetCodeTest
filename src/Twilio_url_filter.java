import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Twilio_url_filter {

    public static void main(String[] args) throws IOException {
        String filename = "hosts_access_log_00.txt";

        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        while ((str = bufferedReader.readLine()) != null) {
            String[] splited = str.split("\\s+");
            list.add(splited[0]);
        }
        inputStream.close();
        bufferedReader.close();

        for (int i = 0; i < list.size(); i++) {
            String hostname = list.get(i);
            map.put(hostname, map.getOrDefault(hostname, 0) + 1);
        }
        // Starting wirte to file;
        File fout = new File("records_" + filename);
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


        for (String hostname : map.keySet()) {
            bw.write(hostname + " " + map.get(hostname));
            bw.newLine();
        }
        bw.close();
    }
}
