package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_10158_개미_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        x += T; y += T;
        //짝수로 나눠지면 up 홀수면 down
        if((x/W)%2==0) x %= W;
        else x = W-(x%W);

        if((y/H)%2==0) y %= H;
        else y = H-(y%H);

        System.out.println(x+" "+y);

    }
}
