import java.util.*;
class Solution {
    // progresses : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
    // speeds : 각 작업의 개발 속도가 적힌 정수 배열
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]); 
        }
        
        int j = 0;             
        int count = 0;         
        int date = 1;    
        
        while(!q.isEmpty()) {  
            if((speeds[j] * date) + q.peek() >= 100) { // 확인 먼저
                q.poll();  
                j++;           
                count++;       
            } else {
                if (count > 0) {
                    answer.add(count);
                    count = 0;
                }
                date++;
            }
        }
        answer.add(count);
        return answer;
    }
}