import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    /** 우선 장르의 총 재생 횟수로 내림차순 정렬, 이후 그 장르에 해당하는 각 고유 번호의 각 재생 횟수로 내림차순 정렬 */
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genresTotalPlay = new HashMap<>();             // 장르와 총 재생 횟수 저장
        HashMap<String, HashMap<Integer, Integer>> songsPlay = new HashMap<>(); // 장르, 고유번호, 각 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            if (!genresTotalPlay.containsKey(genres[i])) {      // 처음 추가하는 장르이면 각 키를 만들어줘야 함
                HashMap<Integer, Integer> h = new HashMap<>();  // play에 넣기 위해 사용하는 Hash
                genresTotalPlay.put(genres[i], plays[i]);       // 장르, 총 재생 횟수
                h.put(i, plays[i]);                             // 고유번호, 재생 횟수
                songsPlay.put(genres[i], h);                    // 장르, (고유번호, 재생 횟수)
            } else {                                            // 이미 있는 장르이면, 값을 더해줘야 함
                songsPlay.get(genres[i]).put(i, plays[i]);      // 장르가 이미 존재하면 새로운 노래 정보 추가
                // 총 재생 횟수 업데이트
                genresTotalPlay.put(genres[i], genresTotalPlay.get(genres[i]) + plays[i]);
            }
        }
        ArrayList<String> keys = new ArrayList<>(genresTotalPlay.keySet());
        // 총 재생 횟수가 많은 장르가 앞에 (내림차순)
        Collections.sort(keys, (a, b) -> genresTotalPlay.get(b) - genresTotalPlay.get(a));

        for (String key : keys) {
            HashMap<Integer, Integer> h = songsPlay.get(key);      // 장르에 해당하는 고유번호, 재생 횟수를 꺼냄
            ArrayList<Integer> list = new ArrayList<>(h.keySet()); // 고유번호를 a에 저장
            Collections.sort(list, (a, b) -> h.get(b) - h.get(a)); // 각 재생 횟수로 정렬 (이것도 내림차순)

            answer.add(list.get(0));
            // 각 장르 별로 두 개 씩 저장 할 수 있으니까 조건문 추가 (각 장르에 담긴 곡이 두 개보다 많아야 하니)
            if (list.size() > 1) {
                answer.add(list.get(1));
            }
        }
        // List -> int 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}