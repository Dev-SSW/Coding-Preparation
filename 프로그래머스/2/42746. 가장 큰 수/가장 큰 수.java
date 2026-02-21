import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) { 
            s[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        
        // 모두 0인 케이스 방지
        if (s[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String x : s) sb.append(x);

        return sb.toString();
    }
}