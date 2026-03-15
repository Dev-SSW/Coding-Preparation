import java.util.*;

class Solution {
    /**
        최적으로 태우려면? -> 가장 가벼운, 가장 무거운 사람을 한 배에 태워야 한다
        Ex) {30, 40, 50, 55, 60, 70}
        30 + 70, 40 + 60, 50, 55 -> 4
        30 + 40, 50, 55, 60, 70 -> 5 
        -> 정렬된 배열에서의 두 수의 합 구하는 알고리즘 -> 투포인터
        제일 작은 것과 제일 큰 것을 더해서 <= limit 라면? -> left++, answer++, right--
        제일 작은 것과 제일 큰 것을 더했는데 > limit 라면? -> answer++, right--
    */
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}