package 전체문제2026.March.Ninth;

import java.util.*;
import java.io.*;
public class BJ_1680_쓰레기수거_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][]arr = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int idx = 0;
            int ans = 0;
            int tmpW  = W;
            int pos = 0;
            while(true){
                if(idx==N) break;
                if(arr[idx][1] < tmpW){
                    ans += arr[idx][0] - pos;
                    pos = arr[idx][0];
                    tmpW -= arr[idx][1];
                    idx++;
                }else if(arr[idx][1]==tmpW){
                    ans += ((arr[idx][0]-pos) + arr[idx][0]);
                    pos = 0;
                    tmpW = W;
                    idx++;
                }
                else{
                    // 다시 데꼬와야됨
                    ans += ((arr[idx][0]-pos) + arr[idx][0]);
                    pos = 0;
                    tmpW = W;
                }
            }
            ans += pos;
            sb.append(ans+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
