import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 모든 명함의 가로 길이는 크게, 세로 길이는 작게 만들기
        // 명함의 가로는 큰 부분, 세로는 작은 부분으로 교체
        // 모든 명함 중 제일 큰 가로 길이, 제일 큰 세로 길이로 지갑을 만들면 된다
        int n = sizes.length;
        int[] width = new int[n];
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            width[i] = sizes[i][0];
            length[i] = sizes[i][1];
        }
        Arrays.sort(width);
        Arrays.sort(length);
        int answer = 0;
        answer = width[n-1] * length[n-1];
        return answer;
    }
}