import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> h = new HashMap<>();
        for (String[] cloth : clothes) {
            // 의상 별로 갯수 저장 (이름은 중요하지 않으므로)
            h.put(cloth[1], h.getOrDefault(cloth[1], 0) + 1);
        }
        for (String k : h.keySet()) {
            // 안 입기 + 입을 수 있는 수
            // 종류 별로 하나 씩 모두 입어야하는 문제였다면 +1이 없었을 것
            answer *= (h.get(k) + 1);
        }
        // 둘다 아무 것도 안 입는 경우를 생각해서 -1
        answer -= 1;
        return answer;
    }
}