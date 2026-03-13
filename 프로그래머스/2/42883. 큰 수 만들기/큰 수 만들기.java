import java.util.*;

class Solution {
    /** 
        조합을 활용해야하는 문제인줄 알았으나, 메모리 제한으로 인해 변경
        가장 큰 숫자를 찾아야 하기에, 맨 앞자리 숫자는 가장 큰 숫자로 시작
        ** 큰 숫자들을 앞으로 배치하자 **
        ** 이후 뒤에 있는 숫자들을 차례대로 삭제하자 **
    */
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() < c) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        return sb.toString();
    }
}