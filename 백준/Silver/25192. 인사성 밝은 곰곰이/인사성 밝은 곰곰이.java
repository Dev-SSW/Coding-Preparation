import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            if(str.equals("ENTER")) { // set 비워주기
                set.clear();
            }
            else {
                if(set.contains(str)) continue; // 중복일땐 넘어가기
                set.add(str);
                count++;
            }
        }
        System.out.println(count);
    }
}