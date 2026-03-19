import java.util.*;

class Solution {
    /** 
        dp[0] = 7
        dp[1] = 10, 15
        dp[2] = 18, 11, 16, 15
        dp[3] = ...

        dp[1] - dp[0][0] + t[1][0] , dp[0][0] + t[1][1]
        
        dp[2] - dp[1][0] + t[2][0] , + t[2][1], 
                dp[1][1] + t[2][1] , + t[2][2]
                    
        dp[3] - dp[2][0] + t[3][0] , + t[3][1]
                dp[2][1] + t[3][1] , + t[3][2]
                dp[2][2] + t[3][1] , + t[3][2]
                dp[2][3] + t[3][2] , + t[3][3]
        왼쪽, 중간, 오른쪽
        i -> 0 ~ n
        j -> 0 ~ triangle[i].length -> i + 1   
    */
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                // 맨 왼쪽
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                // 맨 오른쪽
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } 
                // 중간
                else {
                    dp[i][j] = 
                        Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }
        
        return answer;
    }
}