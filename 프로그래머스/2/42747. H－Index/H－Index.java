import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 논문 n편 중, h번 이상 인용된 논문이 h편 이상인 h의 최댓값
        // for h : 0 ~ n 
        // for i : 0 ~ n
        // 배열 내부에서 H보다 큰 숫자 갯수 세기 (h번 이상 인용된 논문)
        // citations[i] >= h 
        // h편 이상인지 확인하기 위해 b에 담기
        // h <= b
        int n = citations.length;
        int max = 0;
        for(int h = 0; h <= n; h++) {
            int b = 0;
            for(int i = 0; i < n; i++) {
                if(citations[i] >= h) {
                    b++;
                }
            }
            if(b >= h) {
                max = h;
            }
        }
        return max;
    }
}