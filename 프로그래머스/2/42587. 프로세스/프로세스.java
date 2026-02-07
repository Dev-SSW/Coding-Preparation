import java.util.*;
class Solution {
    //현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities
    //몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //Index, priorities 저장 큐
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});
        }
        //내림차순 우선순위 큐
        PriorityQueue<Integer> desQ = 
            new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            desQ.add(priorities[i]); // 3 2 2 1 or 9 1 1 1 1 1
        }
        while(!q.isEmpty()) { // 0,2 | 1,1 | 2,3 | 4,2
            int[] a = q.poll();
            if(a[1] == desQ.peek()) {
                answer++;
                if(a[0] == location) {
                    return answer;
                }
                desQ.poll();
            } else {
                q.add(a);
            }
        }
        return answer;
    }
}