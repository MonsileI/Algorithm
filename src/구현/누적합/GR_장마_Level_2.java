package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GR_장마_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]house = new int[N];
        int[]sum = new int[N];
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)house[i] = Integer.parseInt(st.nextToken());
        int[][]range = new int[3][2];
        int idx = 0;
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            if(end!=N-1) sum[end+1]--;
            sum[start]++;
            range[idx][0] = start; range[idx++][1] = end;
            if(i%3==0){
                idx = 0;
                boolean []visited= new boolean[N];
                for(int j=0;j<3;j++){
                    for(int l=range[j][0];l<=range[j][1];l++){
                        if(visited[l]) continue;
                        visited[l] = true;
                        house[l]--;
                    }
                }
            }
        }
        int total = 0;
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++){
            total += sum[i];
            sb.append(total+house[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
