import java.util.*;

class Solution {
    public boolean[] visited = new boolean[8];
    private int max = 0;
    public int solution(int k, int[][] dungeons) {
        // 진입마다 k >= dungeons[0] 인지 확인한다
        // 위의 조건이 충족되면, k = k - dungeons[1]을 하고
        // 다음 루프에서 k의 값을 되돌린다
        // 모든 조합을 찾아야 한다
        dfs(dungeons, k, 0);
        return max;
    }
    public void dfs(int[][] dungeons, int k, int count) {
        max = Math.max(max, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if(visited[i]) {
                continue;
            }
            if(k < dungeons[i][0]) {
                continue; 
            }
            visited[i] = true;
            dfs(dungeons, k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}
