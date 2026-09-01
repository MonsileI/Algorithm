package 전체문제2026.August.TwentyFirst;

import java.util.*;
import java.io.*;
public class GR_비타민주스_D3 {
    static int N;
    static int answer;
    static int INF = Integer.MAX_VALUE;
    static int[][]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = INF;
        arr = new int[N][2];
        StringTokenizer st=  null;
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            int weight = Integer.parseInt(st.nextToken());
            String value = st.nextToken();
            int v = 0;
            for(int j=0;j<value.length();j++){
                int alpha = value.charAt(j) - 'A';
                v = v | 1 << alpha;
            }
            arr[i][0] = weight;
            arr[i][1] = v;
        }
        dfs(0,0,0);
        System.out.println(answer == INF ? -1 : answer);
    }
    static void dfs(int sum,int depth,int bit){
        if(answer<=sum) return;
        if(bit==7){
            answer = Math.min(answer,sum);
            return;
        }
        if(depth==N){
            return;
        }

        //선택
        dfs(sum+arr[depth][0],depth+1,bit | arr[depth][1]);
        //안 선택
        dfs(sum,depth+1,bit);

    }
}
