import java.util.*;

class Solution {
    // 일단 순열 구해서 모든 수의 조합 중복 없도록 set에 넣기
    // 그 리스트에서 소수 찾기
    public Set<Integer> set;
    public boolean[] visited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);
        
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String numbers, String s, int depth) {
        // depth는 0부터 numbers.length까지 탐색
        if (depth > numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                String slice = s + numbers.charAt(i);
                set.add(Integer.parseInt(slice));
                dfs(numbers, slice, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
		// 에라토스테네스 체
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}