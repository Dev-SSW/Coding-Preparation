import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> s = new HashSet<>();
        for (String p : phone_book) {
            s.add(p);
        }
        for (String p : phone_book) {
            for (int i = 1; i < p.length(); i++) {
                if (s.contains(p.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}