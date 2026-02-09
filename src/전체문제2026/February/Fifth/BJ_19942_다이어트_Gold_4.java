package 전체문제2026.February.Fifth;
import java.util.*;
import java.io.*;
public class BJ_19942_다이어트_Gold_4 {
    static int N;
    static int[][]arr;
    static int answer;
    static int []standard;
    static boolean[]tmp;
    static boolean[]answerFlag;
    static int answerCnt;
    /*
    조건 1. 각각 N에 맞는 영향분이 있어야 함
    조건 2. 최소비용
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][4+1];
        standard = new int[4];
        answerFlag = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++) standard[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new boolean[N];
        answer = Integer.MAX_VALUE;

        dfs(0,0);
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append(answer + "\n");
            for (int i = 0; i < N; i++) {
                if (answerFlag[i]) sb.append((i + 1) + " ");
            }
            System.out.println(sb.toString());
        }
    }
    static void dfs(int start, int sum) {
        //가지치기
        if (answer < sum) return;

        //조건 검사
        int[] tmpArr = new int[4];
        for (int i = 0; i < 4; i++) tmpArr[i] = standard[i];
        for (int i = 0; i < N; i++) {
            if (tmp[i]) {
                for (int j = 0; j < 4; j++) {
                    tmpArr[j] -= arr[i][j];
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (0 < tmpArr[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if(sum<answer) {
                answer = sum;
                for (int i = 0; i < N; i++) {
                    answerFlag[i] = tmp[i];
                }
            }
            return;
        }

        //부분집합
        for(int i=start;i<N;i++) {
            tmp[i] = true;
            dfs( i+1,sum + arr[i][4]);
            tmp[i] = false;
        }
    }
}
