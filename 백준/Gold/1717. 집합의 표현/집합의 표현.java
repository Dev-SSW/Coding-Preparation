import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   // M 개의 연산
        parent = new int[N+1];  // n+1 개의 집합
        for (int i = 0; i <= N; i++) {
            parent[i] = i;      // 부모를 모두 자기 자신으로 초기화
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); //0인지 1인지
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (w==0) {
                union(a, b);
            }
            else {
                if (sameParent(a,b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    static int findParent(int n) {
        if (n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = findParent(parent[n]);
        }
    }
    static boolean sameParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        return a==b;
    }
}
