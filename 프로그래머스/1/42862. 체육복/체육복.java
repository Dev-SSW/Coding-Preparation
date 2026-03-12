import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        /**
            lost - 잃은 사람
            reserve - 여벌 있는 사람 (앞 뒤로 빌려줄 수 있음)
        */
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    count++;
                    lost[i] = -2;
                    reserve[j] = -2;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -2) continue;
            for (int j = 0; j < reserve.length; j++) {
                if ((reserve[j] - 1) == lost[i] || 
                    (reserve[j] + 1) == lost[i]) {
                    count++;
                    reserve[j] = -2;
                    break;
                }
            }
        }
        int answer = n - lost.length + count;
        return answer;
    }
}