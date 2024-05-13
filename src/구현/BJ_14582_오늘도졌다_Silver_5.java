package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_14582_오늘도졌다_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] =sum;
        }
        st = new StringTokenizer(br.readLine()," ");
        int score = 0;
        boolean flag = false;
        for(int i=0;i<9;i++){
            if(arr[i]>score) {
                flag = true;
                break;
            }
            score += Integer.parseInt(st.nextToken());
        }
        System.out.println(flag ? "Yes" : "No");
    }
}
