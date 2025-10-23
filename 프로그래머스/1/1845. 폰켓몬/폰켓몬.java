import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashSet<Integer> s = new HashSet<>();

        for (int num : nums) {
            s.add(num);
        }

        if (s.size() > n) {
            answer = n;
        } else {
            answer = s.size();
        }
        return answer;
    }
}