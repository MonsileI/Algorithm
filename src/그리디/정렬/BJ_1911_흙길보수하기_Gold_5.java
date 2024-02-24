package 그리디.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1911_흙길보수하기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = 0 ; int R = M+1;
        int[][]arr= new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
            int tmp  = 0;
            int len = arr[0][1]-arr[0][0]+1;
            int before = 0;
            while(true){
                if(len<=0)  break;
                len -= M;
                before += M;
                tmp++;
            }
            for(int i=1;i<N;i++){
                if(before<arr[i][0]) {
                    before = arr[i][0];
                    len = arr[i][1] - arr[i][0]+1;
                    while(true){
                        if(len<=0) break;
                        len -= M;
                        before += M;
                        tmp++;
                    }
                    before--;
                }else if(before<arr[i][1]){
                    len = arr[i][1] - before;
                    while(true){
                        if(len<=0) break;
                        len -= M;
                        before += M;
                        tmp++;
                    }
                }
            }
            System.out.println(tmp);
    }
}
