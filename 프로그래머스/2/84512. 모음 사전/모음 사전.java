import java.util.*;

class Solution {
    /** 
        A ~ UUUUU
        A - AA - AAA - AAAA - AAAAA - AAAAE - AAAAI - AAAAO - AAAAU - AAAE 
        AAAEA - AAAEI - AAAEO - AAAEU - ...
        조합을 구해야하니 dfs 활용
    */
    public char[] ch = {'A', 'E', 'I', 'O', 'U'};
    public int count = 0;
    public int answer = 0;
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    public void dfs(String str, String word) {
        if (answer != 0) return;
        
        // "" 도 포함할 수 있으니 조건문 (조건이 없으면 1 밀려남)
        if (!str.isEmpty()) {
            count++;
            if (str.equals(word)) {
                answer = count;
                return;
            }
        }
        
        if (str.length() == 5) {
            return;
        }
        
        for (char c : ch) {
            dfs(str + c, word);
            if (answer != 0) return;
        }
    }
}
