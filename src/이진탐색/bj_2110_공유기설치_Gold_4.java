package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2110_공유기설치_Gold_4 {
    static int arr[],N,C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int L = 0; int R = arr[N-1] - arr[0] + 1; //최대거리
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid)<C) R = mid;
            else L = mid+1;
        }
        System.out.println(L);
    }

    static int check(int mid){
        int tmp = 1;
        int before = arr[0];
        for(int i=1;i<N;i++){
            if(mid<(arr[i]-before)){
                tmp++;
                before = arr[i];
            }
        }
        return tmp;
    }
}
