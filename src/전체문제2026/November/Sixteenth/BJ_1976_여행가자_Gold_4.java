package 전체문제2026.November.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_1976_여행가자_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        boolean[][]canMove = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(i==j || num==1){
                    canMove[i][j] = true;
                    canMove[j][i] = true;
                }
            }
        }
        for(int l=0;l<N;l++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(canMove[i][j]) continue;
                    if(canMove[i][l] && canMove[l][j]){
                        canMove[i][j] = true;
                        canMove[j][i] = true;
                    }
                }
            }
        }
        boolean flag = true;
        st =new StringTokenizer(br.readLine()," ");
        int before = Integer.parseInt(st.nextToken())-1;
        for(int i=1;i<P;i++){
            int next = Integer.parseInt(st.nextToken())-1;
            if(!canMove[before][next]){
                flag = false;
                break;
            }
            before = next;
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
