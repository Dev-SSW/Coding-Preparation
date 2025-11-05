import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        int[][] city = new int[N+1][N+1];
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {  // 부모를 자기 자신으로 초기화
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());    // 맨 마지막 문장
        int[] route = new int[M];   // 여행 루트 담는 곳

        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] > 0) {
                    union(i, j);
                }
            }
        }

        int start = parent[route[0]];
        boolean check = false;

        for (int i = 1; i < M; i++) {
            int cur = find(route[i]);
            if (cur != start) { // 부모가 같으면 경로가 갈 수 있고, 다르면 갈 수 없다
                check = true;
                break;
            }
        }

        if (check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            return parent[n] = find(parent[n]);
        }
    }
}
