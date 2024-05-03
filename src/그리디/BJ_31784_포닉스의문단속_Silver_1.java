package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_31784_포닉스의문단속_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[]arr = new int[N];
        String str = br.readLine();
        for(int i=0;i<N;i++) arr[i] = str.charAt(i)-'A';
        //최대한 앞에 애를 A로 만들어야됨
        for(int i=0;i<N;i++){
            if(arr[i]==0) continue;
            if(K-(26-arr[i])<0) continue;
            K -= (26-arr[i]);
            arr[i] = 0;
        }
        if(K!=0){
            arr[N-1] += K;
            arr[N-1] %= 26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)sb.append(alpha.charAt(arr[i]));
        System.out.println(sb.toString());
    }
}