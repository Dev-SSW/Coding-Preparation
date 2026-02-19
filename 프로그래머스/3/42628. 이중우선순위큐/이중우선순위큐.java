import java.util.*;

class Solution {
    public List<Integer> solution(String[] operations) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < operations.length; i++) {
            // 공백을 기준으로 분리
            String[] s = operations[i].split(" ");
            String a = s[0];
            int b = Integer.parseInt(s[1]);
            if(a.equals("I")) {
                List<Integer> list = new ArrayList<>(dq);
                list.add(b);
                Collections.sort(list);
                dq = new ArrayDeque<>(list);
            } else {
                // 작은게 앞, 큰게 뒤
                if(b == -1) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        if(dq.isEmpty()) {
            answer.add(0);
            answer.add(0);
        } else {
            if(dq.size() == 1) {
                answer.add(dq.peekLast());
                answer.add(dq.peekLast());
            } else {
                answer.add(dq.peekLast());
                answer.add(dq.peekFirst());
            }
        }
        return answer;
    }
}