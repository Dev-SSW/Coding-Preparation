import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 연결된 전선을 끊어서 양 쪽의 갯수 차이가 제일 작은 것을 Return
        // -> 끊어진 간선까지의 노드 수 -> cnt
        // -> 나머지 노드 수 -> n - cnt
        // 갯수 차이 n - cnt - cnt
        //  - n을 통해 n개의 노드 생성 (인접 리스트)
        //  - wires[i][0]과 wires[i][1] 연결
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int[] w : wires) {
            int a = w[0], b = w[1];
            list[a].add(b);
            list[b].add(a);
        }
        
        int best = Integer.MAX_VALUE;
        for (int[] c : wires) {
            // 끊을 간선
            int u = c[0], v = c[1];
            int cnt = bfs(u, u, v, list, n);
            // n - cnt - cnt
            int diff = Math.abs(n-(2*cnt));
            best = Math.min(best, diff);
        }
        
        return best;
    }
    
    public int bfs(int start, int u, int v, List<Integer>[] list, int n) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        visited[start] = true;
        dq.add(start);
        int count = 1;

        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int next : list[cur]) {
                // 끊은 간선은 무시해야 한다
                if ((cur == u && next == v) || 
                    (cur == v && next == u)) {
                    continue;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    dq.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}