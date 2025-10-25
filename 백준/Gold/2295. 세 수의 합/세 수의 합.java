import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        /** 시간 제한이 1초, 3중 for문으로 풀 수는 있지만 시간 제한에 걸릴 것 */
        /** 그러면 x + y + z = k 를 어떻게 만들어야 할까? -> x + y = k - z 하면 되겠네 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] U = new int[n];
        for (int i = 0; i < n; i++) {
            // 입력값 받기
            U[i] = Integer.parseInt(br.readLine());
        }

        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s.add(U[i] + U[j]); // x + y
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.contains(U[i] - U[j])) {
                    max = Math.max(max, U[i]);
                }
            }
        }
        System.out.println(max);
    }
}