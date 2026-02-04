import java.util.*;
public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        answer.add(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if (s.peek() == arr[i]) {
                continue;
            }
            s.push(arr[i]);
            answer.add(arr[i]);
        }
        return answer;
    }
}