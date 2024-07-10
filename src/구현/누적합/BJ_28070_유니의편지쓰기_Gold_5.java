package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_28070_유니의편지쓰기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int min = 987654321;
        StringTokenizer st = null;
        int[][]arr = new int[N][4];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            String[]tmp = st.nextToken().split("-");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
            tmp = st.nextToken().split("-");
            arr[i][2] = Integer.parseInt(tmp[0]);
            arr[i][3] = Integer.parseInt(tmp[1]);
            max = Math.max(max,arr[i][2]);
            min = Math.min(min,arr[i][0]);
        }
        int[][]sum = new int[max+1][14];
        for(int i=0;i<N;i++){
            sum[arr[i][0]][arr[i][1]] += 1;
            sum[arr[i][2]][arr[i][3]+1] -= 1;
        }
        String ans = "";
        int pyun = 0;
        for(int i=min;i<max+1;i++){
            sum[i][0] = sum[i-1][13];
            for(int j=1;j<14;j++){
                sum[i][j] += sum[i][j-1];
                if(pyun<sum[i][j]){
                    pyun = sum[i][j];
                    ans = i+"-";
                    if(j<10) ans += "0";
                    ans += j;
                }
            }
        }
        System.out.println(ans);
    }
}
