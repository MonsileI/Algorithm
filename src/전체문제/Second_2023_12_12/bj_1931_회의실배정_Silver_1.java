package 전체문제.Second_2023_12_12;
import java.util.*;
import java.io.*;
public class bj_1931_회의실배정_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s; arr[i][1] = e;
        }
        Arrays.sort(arr,(o1,o2)->o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int ans = 1;
        int end = arr[0][1];
        for(int i=1;i<N;i++){
            if(end<=arr[i][0]){
                ans++;
                end = arr[i][1];
            }
        }
        System.out.println(ans);
    }
}
