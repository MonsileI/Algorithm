package 전체문제2026.January.Fifth;

import java.util.*;
import java.io.*;
public class BJ_2281_데스노트_Gold_2  {
    static int N,M;
    static int[][]dp;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[2000][2000];
        arr = new int[N];
        for(int i =0; i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<2000;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int idx, int cnt){
        if(idx==N) return 0;
        if(dp[idx][cnt] != -1) return dp[idx][cnt];

        // 강제로 넘겨주기 위한 변수이기 때문에, 재귀로 넘어온 +1을 -1 해준다. -> 다음 단어 작성을 위한 띄어쓰기를 제외한 남은 공간
        int spareCnt = M - (cnt - 1);

        // 강제로 넘겨주기 (남은 자리)한 칸 뛰어야 하기 때문에 idx+1
        int result = dfs(idx+1,arr[idx]+1) + (int)Math.pow(spareCnt,2); // dfs한 값과 남은칸의 제곱

        // 이어쓰기
        if(cnt + arr[idx] <= M){
            result = Math.min(result,dfs(idx+1,cnt+arr[idx]+1)); // 이어 쓰기 때문에 남은칸 제곱 x
        }

        return dp[idx][cnt] = result;
    }
}
