import java.util.*;

class Solution {
    // 우선순위 큐를 통해 가장 스코빌 지수가 낮은 두 개를 꺼내 계산
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // 우선순위 큐에 일단 집어넣기
        for(int i : scoville) {
            pq.offer(i);
        }
        int cnt = 0;
        // 큐가 비어있지않고, 맨 앞의 스코빌 지수가 K보다 작을 때
        while(!pq.isEmpty() && (pq.peek() < K)) {
            // 큐에서 2개를 꺼내지 못하면 실패 (-1)
            if(pq.size() < 2) {
                return -1;
            }
            int f = pq.poll();
            int s = pq.poll();
            int r = f + (s * 2);
            pq.offer(r);
            cnt++;
        }
        
        return cnt;
    }
}