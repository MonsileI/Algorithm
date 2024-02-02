package 그리디.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7983_내일할거야_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)-> - (o1[1] - o2[1]));
        int last = arr[0][1];
        for(int i=0;i<N;i++){
            if(arr[i][1] <= last) last = arr[i][1] - arr[i][0];
            else last -= arr[i][0];
        }
        System.out.println(last);
    }

}
