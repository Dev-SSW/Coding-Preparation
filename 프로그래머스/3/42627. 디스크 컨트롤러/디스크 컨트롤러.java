import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 우선순위 : 소요시간-요청시각-인덱스
        
        // 요청 시각 기준 정렬
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));
        // 소요 시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        
        int time = 0;
        int index = 0;
        int total = 0;
        
        while(index < jobs.length || !pq.isEmpty()) {
            // 현재 시각보다 요청 시각이 작거나 같을 때
            while(index < jobs.length && jobs[index][0] <= time) {
                // pq에 집어넣으면 내부적으로 소요 시간으로 정렬 (짧은순)
                pq.add(jobs[index]);
                index++;
            }
            // 현재 시각보다 요청 시각이 더 큰데, 아직 인덱스가 배열 길이를 벗어나지 않았을 떄
            if(pq.isEmpty()) {
                // 해당 인덱스의 요청 시각으로 time을 올림
                time = jobs[index][0];
                continue;
            }
            // 소요 시간이 더 작은 애 poll
            int[] job = pq.poll();
            // 소요 시간을 현재 시간에 더해주기
            time += job[1];
            // 반환 시간 계산 : 현재 시간 - 요청 시각
            total += time - job[0];
        }
        int answer = (total / jobs.length);
        return answer;
    }
}