package 전체문제.Sixth_2023_12_19;
import java.util.*;
import java.io.*;
public class st_금고털이_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int G = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->-(o1[1]-o2[1]));
        int ans = 0;
        for(int i=0;i<N;i++){
            if(arr[i][0]<=G){
                ans += (arr[i][0]*arr[i][1]);
                G -= arr[i][0];
            }
            else{
                ans += (arr[i][1]*G);
                break;
            }
        }
        System.out.println(ans);
    }
}
