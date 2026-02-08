import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;
        
        Queue<Integer> bridge = new LinkedList<>();
        // 비어있는 다리 공간 모두 0
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        
        int index = 0;
        //전체 무게
        int currentW = 0;
        //대기 트럭이 빌 때까지
        while(index < truck_weights.length) {
            //다리 끝자락에 도착한 트럭 있으면 무게 빼주기 (없으면 0)
            currentW -= bridge.poll();
            //경과 시간 마다 +1
            answer++;
            //현재 다리에 있는 무게 + 새로 들어온 트럭의 무게 <= 가능한 무게
            if((currentW + truck_weights[index]  <= weight)) {
                //트럭 추가하기 (무게)
                bridge.add(truck_weights[index]);
                //현재 무게에 새로 다리로 간 트럭 무게 더하기 및 index 값 올리기
                currentW += truck_weights[index++];
            } else {
                //무게 제한 걸리면 0
                bridge.add(0);
            }
        }
        //마지막으로 건너기 시작한 트럭에 필요한 소요시간 포함하여 리턴하기
        return answer + bridge_length;
    }
}