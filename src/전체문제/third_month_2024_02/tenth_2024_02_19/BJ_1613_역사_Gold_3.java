package 전체문제.third_month_2024_02.tenth_2024_02_19;
import java.util.*;
import java.io.*;
public class BJ_1613_역사_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][]map = new boolean[N+1][N+1];
        boolean[][]reverseMap = new boolean[N+1][N+1];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
            reverseMap[b][a] = true;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    if(map[i][l]&&map[l][j]) map[i][j] = true;
                    if(reverseMap[i][l]&&reverseMap[l][j]) reverseMap[i][j] = true;
                }
            }
        }
        StringBuilder sb=  new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(map[a][b]) sb.append(-1+"\n");
            else if(reverseMap[a][b]) sb.append(1+"\n");
            else sb.append(0+"\n");
        }
        System.out.println(sb.toString());
    }
}
