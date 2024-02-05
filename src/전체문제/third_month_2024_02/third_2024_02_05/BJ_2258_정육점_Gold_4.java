package 전체문제.third_month_2024_02.third_2024_02_05;
import java.util.*;
import java.io.*;
public class BJ_2258_정육점_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);
        int ans = 0;
        int sum = 0;

        for(int i=0;i<N;i++){
            sum += arr[i][0];
            if(sum>=G){
                ans = arr[i][1];
                break;
            }
        }
        System.out.println(ans);

    }
}
