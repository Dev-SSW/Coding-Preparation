import java.util.*;

class Edge {
    int from, to, cost;
    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
class Solution {    
    public int[] parent;
    public void init(int n) {
        // 자기 자신을 부모로 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        // 자기 자신이 부모면 자기 자신을 리턴, 아니면 부모[x]를 재귀
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b) {
        // 사이클 발생하는지 확인
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        parent[pb] = pa;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            edges.add(new Edge(from, to, cost));
        }
        // 최소비용 순으로 정렬
        Collections.sort(edges, (a, b) -> a.cost - b.cost);
        init(n);
        int total = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                total += edge.cost;
                count++;
                // 불필요한 탐색을 막기 위해 간선만큼만 반복
                if (count == n - 1) break;
            }
        }
        return total;
    }
}