package 전체문제.second_month_2024_01.fourteenth_2024_01_22;
import java.util.*;
import java.io.*;
public class BJ_1365_꼬인전깃줄_Gold_2 {

    static int[]lines;
    static int[]lis;
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        lines = new int[N];
        for(int i=0;i<N;i++) lines[i] = Integer.parseInt(st.nextToken());
        lis = new int[N+1];
        int len = 0;
        int idx = 0;
        for(int i=0;i<N;i++){
            if(lines[i]>lis[len]){
                len++;
                lis[len] = lines[i];
                continue;
            }
            idx = binary(0,len,lines[i]);
            lis[idx] = lines[i];
        }
        System.out.println(N-len);
    }
    static int binary(int L,int R,int V){
        while(L<R){
            int mid = (L+R)/2;
            if(lis[mid]>V) R = mid;
            else L = mid+1;
        }
        return R;
    }
}
