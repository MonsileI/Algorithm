package 전체문제.second_month_2024_01.twentieth_2024_01_30;
import java.util.*;
import java.io.*;
public class BJ_1244_스위치켜고끄기_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<N+1;i++)arr[i] = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());
        for(int t=0;t<Q;t++){
            st = new StringTokenizer(br.readLine()," ");
            int act = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if(act==1){
                for(int j=idx;j<N+1;j += idx) {
                    if(arr[j]==1) arr[j]=0;
                    else arr[j] = 1;
                }
            }else{
                if(arr[idx]==1) arr[idx] = 0;
                else arr[idx] = 1;
                int L = idx-1; int R = idx+1;
                while(true){
                    if(L<1 || N<R) break;
                    if(arr[L]!=arr[R]) break;
                    if(arr[L]==1){
                        arr[L] = 0; arr[R] = 0;
                    }else{
                        arr[L] = 1; arr[R] = 1;
                    }
                    L--; R++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            sb.append(arr[i]+" ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
