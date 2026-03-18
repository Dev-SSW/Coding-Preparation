import java.util.*;

class Solution {
    /**
        DP 문제이므로 점화식을 먼저 찾아야 함
        + - / * 사칙연산만을 사용해야 함
        최솟값이 8보다 크면 -1을 리턴함
        일단 i = 1~8까지 반복하여 N, NN, NNN, NNNN, ... 형태를 먼저 저장한다
        
    */
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Set<Integer>[] DP = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            DP[i] = new HashSet<>();
        }
        
        // N, NN, NNN, ...
        // DP[1] = {5}, DP[2] = {55}, DP[3] = {555}, ...
        int repeated = 0;
        for (int i = 1; i <= 8; i++) {
            repeated = repeated * 10 + N;
            DP[i].add(repeated);
        }
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : DP[j]) {
                    // i = 3면, dp[1] + dp[2], dp[2] + dp[1]
                    // i = 4면, dp[1] + dp[3], dp[2] + dp[2], dp[3] + dp[1]
                    // => j 와 i-j
                    for (int b : DP[i-j]) {
                        DP[i].add(a+b);
                        DP[i].add(a-b);
                        DP[i].add(a*b);
                        // 오류 방지
                        if (b != 0) {
                            DP[i].add(a/b);
                        }
                    }
                }
            }
            // i가 1~8까지 돌아가니까, i가 가장 작을 때 나온 것이 답
            if (DP[i].contains(number)) return i;
        }        
        return -1;
    }
}