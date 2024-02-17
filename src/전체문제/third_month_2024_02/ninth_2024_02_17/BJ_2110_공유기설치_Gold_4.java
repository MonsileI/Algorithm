package 전체문제.third_month_2024_02.ninth_2024_02_17;
import java.util.*;
import java.io.*;
public class BJ_2110_공유기설치_Gold_4 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int L = 0; int R = arr[N-1] - arr[0];
        while (L < R) {
            int mid = (L+R)/2;
            if(check(mid)>=M) L = mid+1;  //더이상 놓을 수 없다 -> 거기를 늘려야 함.
            else R = mid; //더 여러 개 놓을 수 있다. -> 거리를 좁힐 수 있다.
        }
        //1 2 3 5 6 7
        System.out.println(L);
    }
    static int check(int mid){
        int cnt = 1;
        int before = arr[0];
        for(int i=1;i<N;i++){
            if((arr[i]-before)>mid){
                 cnt++;
                 before = arr[i];
            }
        }
        return cnt;
    }
}
