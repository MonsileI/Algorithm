package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_28449_누가이길까_Gold_5 {
    static int[]HI;
    static int[]ARC;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HI = new int[N];
        ARC = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)HI[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++)ARC[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(ARC);
        long win  = 0; long draw = 0; long lose = 0;
        for(int i=0;i<N;i++){
            int num = HI[i];
            int u = upper(num);
            int l = lower(num);
            win += l;
            draw += (u-l);
            lose += (M-u);
        }
        System.out.println(win+" "+lose+" "+draw);

    }
    static int lower(int num){
        int L = 0 ; int R = M;
        while(L<R){
            int mid = (L+R)/2;
            if(ARC[mid]<num) L = mid+1;
            else R = mid;
        }
        return L;
    }
    static int upper(int num){
        int L = 0 ; int R = M;
        while(L<R){
            int mid = (L+R)/2;
            if(ARC[mid]<=num) L = mid+1;
            else R = mid;
        }
        return L;
    }
}
