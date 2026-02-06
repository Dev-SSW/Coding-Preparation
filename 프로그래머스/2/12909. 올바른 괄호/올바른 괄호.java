import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        if(s.charAt(0) == ')') {
            return answer;
        }
        Stack<String> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push("(");
            } else {
                if(st.isEmpty()) {
                    return answer;
                }
                st.pop();
            }
        }
        if(st.isEmpty()) {
            answer = true;
        }
        return answer;
    }
}