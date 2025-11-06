import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] knowTrue;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 사람 수
        int M = Integer.parseInt(st.nextToken());   // 파티 수

        // 부모를 자기 자신으로 초기화
        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 진실을 아는 사람 저장
        st = new StringTokenizer(br.readLine());
        int tN = Integer.parseInt(st.nextToken());
        knowTrue = new int[tN];
        for (int i = 0; i < tN; i++) {
            knowTrue[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 데이터 저장
        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int pN = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pN; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 각 파티에 참여한 사람들을 1개의 집합으로 만듦
        for (int i = 0; i < M; i++) {
            int fN = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                // 각 파티의 맨 앞의 사람을 기준으로 부모를 같도록 지정
                union(fN, party[i].get(j));
            }
        }

        int result = 0;

        // 각 파티의 부모 노드와 진실을 아는 사람들의 부모 노드가 같다면 진실만 말해야 함
        for (int i = 0; i < M; i++) {
            boolean Lie = true;
            int fP = party[i].get(0);
            for (int j = 0; j < knowTrue.length; j++) {
                if (find(fP) == find(knowTrue[j])) {
                    Lie = false;
                    break;
                }
            }
            if (Lie) {
                result++;
            }
        }
        System.out.println(result);
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
