import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
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
                if (dq.isEmpty()) {
                    // 비어있으면 무시
                    continue; 
                }
                // 작은게 앞, 큰게 뒤
                if(b == -1) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }
        }
        if (dq.isEmpty()) { 
            return new int[]{0, 0};
        }
        int max = dq.peekLast();
        int min = dq.peekFirst();
        return new int[]{max, min};
    }
}
