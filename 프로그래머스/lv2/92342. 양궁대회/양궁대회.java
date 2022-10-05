import java.util.*;

class Solution {
    static int resultAbs = 0;
    static int[] results; // 최대 점수일 경우의 점수판
    public int[] solution(int n, int[] info) {
        dfs(n, n, new int[11], info); // dfs를 통해서 탐색 밑에서부터 탐색을 해야 동일 값일 때 과녁 점수의 낮을 화살이 많음
        if (results == null){ // 최대 점수가 없는 경우에는 -1를 리턴
            results = new int[1];
            results[0] = -1;
        }
        return results;
    }
    
    static void dfs(int cnt, int idx, int[] chooses, final int[] info){
        if (idx == -1){ // 끝까지 확인 후 남은 화살은 맨 밑에 과녁의 점수로 합계
            chooses[10] += cnt;
            dfs(0, 10, chooses, info);
            chooses[10] = 0;
            return;
        }
        
        if(cnt == 0){ // 만약 모든 화살을 맞췄다면 그때 계산 시작
            int sum = 0;
            int other = 0;
            for (int i = 10; i >= 0; i--){
                if (chooses[i] == 0 && info[i] == 0) // 둘 다 0점 인 경우
                    continue;
                if (chooses[i] > info[i]){ // 라이언이 이긴 경우
                    sum += (10 - i);
                }else{ // 어피치가 이긴 경우
                    other += (10 - i);
                }
            }
            if (sum > other && Math.abs(sum - other) > resultAbs ){
                // 라이언이 이기고, 기존값보다 큰 경우
                    resultAbs = Math.abs(sum - other);
                    results = chooses.clone();
            }
            return;
        }
        
        if (info[idx] + 1 <= cnt){ // 이길 수 있는 경우
            chooses[idx] = info[idx] + 1;
            dfs(cnt - (info[idx] + 1), idx - 1, chooses, info);
            chooses[idx] = 0;
        }
        // 지는 경우
        dfs(cnt, idx - 1, chooses, info);
    }
}