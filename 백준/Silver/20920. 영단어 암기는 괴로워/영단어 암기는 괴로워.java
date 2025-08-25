import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 단어의 개수
        int M = Integer.parseInt(st.nextToken());       // 단어 길이의 기준
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            if (a.length() < M) {
                continue;
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<String> str = new ArrayList<>(map.keySet());

        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) { // 빈도 값이 같지 않으면
                    return Integer.compare(map.get(o2), map.get(o1)); // 내림차순 정렬
                }
                if (o1.length() != o2.length()) {                     // 길이가 같지 않으면
                    return o2.length() - o1.length();                 // 길이가 긴 문자열이 앞으로
                }
                return o1.compareTo(o2);                              // 사전순으로 오름차순
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str1 : str) {
            sb.append(str1 + "\n");
        }
        System.out.println(sb);
    }
}
