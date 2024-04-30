package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_2109_순회강연_Gold_3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]==o2[0] ? -(o1[1]-o2[1]) : -(o1[0]-o2[0]));
        boolean[]visited = new boolean[10001];
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=arr[i][1]; 0<j;j--){
                if(!visited[j]){
                    visited[j] = true;
                    ans += arr[i][0];
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
