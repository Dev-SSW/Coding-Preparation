import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> h = new HashMap<String, Integer>();

        for (String p : participant) {
            h.put(p, h.getOrDefault(p, 0) + 1);
        }
        for (String p : completion) {
            h.put(p, h.get(p) - 1);
        }
        for (Map.Entry<String, Integer> e : h.entrySet()) {
            if (e.getValue() != null && e.getValue() > 0) {
                answer = e.getKey();
            }
        }
        return answer;
    }
}