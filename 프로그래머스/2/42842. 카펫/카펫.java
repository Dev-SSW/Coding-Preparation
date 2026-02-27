import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로가 세로보다 더 길거나, 같아야함 (정렬 필요)
        int[] answer = new int[2];
        int sum = brown + yellow;
        // sum = w * l
        // (w-2) * (l-2) = y
        // l = l
        // w = sum / l
        for (int l=3 ; l<=sum/3 ; l++) {
            if (sum%l!=0) continue;

            if ((((sum/l)-2) * (l-2)) == yellow) {
                answer[1] = sum/l;
                answer[0] = l;
            }
        }
        return answer;
    }
}