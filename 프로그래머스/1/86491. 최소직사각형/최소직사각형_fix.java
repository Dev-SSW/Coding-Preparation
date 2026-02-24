import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] s : sizes) {
            int w = Math.max(s[0], s[1]); // 큰 쪽을 가로로
            int h = Math.min(s[0], s[1]); // 작은 쪽을 세로로

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}
