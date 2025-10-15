import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};
        String input = "";
        String answer = "123456780";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                int n = Integer.parseInt(st.nextToken());
                input += n;
            }
        }
        map.put(input, 0);

        // bfs
        Queue<String> q = new LinkedList<>();
        q.add(input);
        while(!q.isEmpty()) {
            String cur = q.poll();
            int cnt = map.get(cur);
            // 0의 위치 찾기
            int loc = cur.indexOf("0");
            int x = loc / 3;
            int y = loc % 3;

            // 정답일 때 출력
            if(cur.equals(answer)) {
                System.out.println(cnt);
                break;
            }

            for(int i = 0; i < 4; i++) {
                // 상하 좌우
                int xx = dx[i] + x;
                int yy = dy[i] + y;
                // 보드 밖
                if(xx < 0 || xx > 2 || yy < 0 || yy > 2)
                    continue;

                // 일차원 배열로 만들기
                int replaceIdx = xx*3+yy;

                // 0과 스위칭 할 값
                char tmp = cur.charAt(replaceIdx);
                String next = cur.replace(tmp, 'c');
                next = next.replace('0', tmp);
                next = next.replace('c', '0');

                if(!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, cnt+1);
                }
            }
        }
        if(!map.containsKey(answer)) System.out.println(-1);
    }
}