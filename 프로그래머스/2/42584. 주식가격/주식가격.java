import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
        
        // 가격이 떨어진 경우에 while을 돌며 answer에 값 계산해서 넣기
        // answer의 값 계산 => answer[스택 인덱스] =  현재 인덱스 - 스택 인덱스
        // 가격이 증가하거나 동일한 경우에는 stack에 push만
        for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				answer[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i); 
		}
        // stack에는 끝까지 가격이 떨어지지 않은 인덱스만 담긴다
        // prices의 길이 - 해당 인덱스 - 1; (마지막이라면 5 - 인덱스 4 - 1)
        while (!stack.isEmpty()) {
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
		return answer;
    }
}