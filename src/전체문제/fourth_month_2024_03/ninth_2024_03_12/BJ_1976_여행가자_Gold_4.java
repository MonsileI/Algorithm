package 전체문제.fourth_month_2024_03.ninth_2024_03_12;
import java.util.*;
import java.io.*;
public class BJ_1976_여행가자_Gold_4 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][]map = new int[N][N];
        StringTokenizer st= null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(i==j) map[i][j]=1;
            }
        }
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1) continue;
                    if(map[i][l]==1 &&map[l][j]==1) map[i][j] = 1;
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int before = Integer.parseInt(st.nextToken())-1;
        String ans = "YES";
        for(int i=1;i<M;i++){
            int num = Integer.parseInt(st.nextToken())-1;
            if(map[before][num]==0) {
                ans = "NO";
                break;
            }
            before = num;
        }
        System.out.println(ans);
    }
}
