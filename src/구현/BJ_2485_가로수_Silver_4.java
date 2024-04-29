package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_2485_가로수_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1;
        int[]arr = new int[N];
        int before = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num - before;
            before = num;
        }
        //최대공약수
        int max = 0;
        for(int i=0;i<N;i++) max = change(max,arr[i]);
        long ans = 0;
        for(int i=0;i<N;i++){
            ans += (arr[i]/max)-1;
        }
        System.out.println(ans);
    }
    static int change(int a,int b){
        int big = Math.max(a,b);
        a = Math.min(a,b);
        b = big;
        while(b!=0){
            int r = a%b; //4 6  a = 2
            a = b;  //b = 2
            b = r; //tmp = 2
        }
        return a;
    }
}
