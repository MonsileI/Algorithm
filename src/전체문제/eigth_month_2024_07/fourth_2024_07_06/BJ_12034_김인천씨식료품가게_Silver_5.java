package 전체문제.eigth_month_2024_07.fourth_2024_07_06;

import java.util.*;
import java.io.*;
public class BJ_12034_김인천씨식료품가게_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;
        StringBuilder sb=  new StringBuilder();
        for(int t=1;t<TC+1;t++){
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N*2];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N*2;i++)arr[i] = Integer.parseInt(st.nextToken());
            boolean[]visited = new boolean[N*2];
            sb.append("Case #"+t+": ");
            for(int i=0;i<N*2;i++){
                if(visited[i]) continue;
                for(int j=i+1;j<N*2;j++){
                    if(visited[j]) continue;
                    if(arr[i]==(arr[j]/4)*3){
                        visited[i] = visited[j] = true;
                        sb.append(arr[i]+" ");
                        break;
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
