import java.util.*;

class Solution {
    /**
            글자 수에 따라 A, AA, AAA로 이루어진 String이 주어짐
            1. 다음 알파벳으로 가는게 빠른지, 이전 알파벳으로 가는게 빠른지
                - 모든 i에 대해 검사하여 결과에 더함
            2. 어떤 방향으로 커서를 이동하는게 빠른지
                - 오른쪽으로 몇 칸 갔다가 왼쪽?
                - 왼쪽으로 몇 칸 갔다가 오른쪽?
                - 아니면 순방향만 계속?
                - 모든 i에 대해 검사하여 최소(cost)인 것 하나를 결과에 더함
    */
    public int findMin(char c) {
        // dst - 'A' : 이후로 갔을 때
        // ('Z' - 'A') - (dst - 'A') : 이전으로 갔을 때 (왼쪽 방향키 눌러야 하니 +1)
        return Math.min(c - 'A', ('Z' - 'A' + 1) - (c - 'A'));
    }
    public int solution(String name) {
        int answer = 0;
        int cost = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int count = 0;
            if (c != 'A') { 
                // 문자 변경 비용 계산
                count = findMin(c); 
            }
            // for i를 통해 각 문자 별 변경 비용을 answer에 더해줍니다
            answer += count;  
            // 다음 인덱스부터 A가 얼마나 길게 있는지 확인
            int nextIndex = i + 1;        
            while (nextIndex < name.length() && 
                   name.charAt(nextIndex) == 'A') {
                nextIndex++;                 
            }
            // 커서 이동 비용 계산 (어디를 먼저 처리하는게 좋을지 계산)
            // cost : 커서를 정방향 순서대로만 갔을 때 비용
            // (i * 2) + name.length() - nextIndex : 
            // - 시작점부터 현재 자리까지 갔다가, 다시 시작점으로 되돌아옴
            // - 역방향으로 A를 건너뜀
            // (name.length() - nextIndex) * 2 + i :
            // - 시작점부터 역방향으로 A를 건너뛰고, 다시 끝으로 되돌아옴
            // - 시작점으로부터 현재 자리까지 감
            cost = 
                Math.min(Math.min(cost, (i * 2) + name.length() - nextIndex),
                (name.length() - nextIndex) * 2 + i);
        }
        answer += cost;
        return answer;
    }
}

