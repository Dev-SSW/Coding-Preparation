import java.util.*;

class Solution {
    /**
        모든 차량의 들어온 지점, 나간 지점을 배열로 준다
        최소 비용으로 모든 차량을 한 번씩은 찍어야 한다
        -> 나간 지점에 카메라 설치하면 가장 최적을 구할 수 있다
        
    */
    public int solution(int[][] routes) {
        // 나간 지점으로 정렬을 해준다.
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int camera = routes[0][1];
        int answer = 1;
        // [-20, -15] [-18, -13] [-14, -5] [-5, -3]
        for (int[] r : routes) {
            int start = r[0];
            int end = r[1];
            if (start > camera) {
                answer++;
                camera = end;
            }
        }
        return answer;
    }
}