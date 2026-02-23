package 전체문제2026.February.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_2891_카약과강풍_Silver_4  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[]arr= new int[N];
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<S;i++){
            int num = Integer.parseInt(st.nextToken())-1;
            arr[num] = -1;
        }
        st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<R;i++){
            int num = Integer.parseInt(st.nextToken())-1;
            if(arr[num]==-1) arr[num] = 0;
            else arr[num] = 1;
        }
        for(int i=0;i<N;i++){
            if(arr[i]==-1){
                if(i!=0){
                    if(arr[i-1]==1){
                        arr[i-1] = arr[i] = 0;
                        continue;
                    }
                }
                if(i!=N-1){
                    if(arr[i+1]==1){
                        arr[i+1] = arr[i] = 0;
                    }
                }
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            if(arr[i]==-1) ans++;
        }
        System.out.println(ans);
    }
}
