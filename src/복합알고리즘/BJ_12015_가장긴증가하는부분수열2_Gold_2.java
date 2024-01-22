package 복합알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_12015_가장긴증가하는부분수열2_Gold_2 {
    static int[]arr;
    static int[]lis;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        lis= new int[N];
        int lastIdx = 1;
        lis[0] = arr[0];
        for(int i=1;i<N;i++){
            int key = arr[i];
            if(lis[lastIdx-1]<key){
                lis[lastIdx] = key;
                lastIdx++;
                continue;
            }
            int idx = binary(0,lastIdx,key);
            lis[idx] = key;
        }
        System.out.println(lastIdx);
    }
    static int binary(int L,int R,int V){
        while(L<R){
            int mid = (L+R)/2;
            if(lis[mid]<V) L = mid+1;
            else R = mid;
        }
        return L;
    }
}
