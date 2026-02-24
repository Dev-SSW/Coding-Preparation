import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        // 1번 : 1, 2, 3, 4, 5 -> 5개 반복
        // 2번 : 2, 1, 2, 3, 2, 4, 2, 5 -> 8개 반복
        // 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 -> 10개 반복
        // answer의 크기 만큼 반복하여 1번, 2번, 3번 배열과 반복하고 점수 기록
        // 각각의 점수를 비교하여 가장 높은 점수를 받은 사람을 return
        // 같을 경우, 같은 경우에 대해 오름차순으로 return
        int[] score = new int[3];
        
        int[] f = new int[] {1, 2, 3, 4, 5};
        int[] s = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] t = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == f[i%5]) {
                score[0]++;
            }
            if(answers[i] == s[i%8]) {
                score[1]++;
            }
            if(answers[i] == t[i%10]) {
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> answer = new ArrayList<>();
        for (int p = 0; p < 3; p++) {
            if (score[p] == max) answer.add(p + 1);
        }
        return answer;
    }
}