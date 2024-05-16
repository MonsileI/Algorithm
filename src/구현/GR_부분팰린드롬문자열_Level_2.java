package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GR_부분팰린드롬문자열_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int ans = 1;
        int N = str.length();
        for(int i=0;i<N;i++){
            for(int j=N-1;i<j;j--){
                int L = i;
                int R = j;
                boolean flag = true;
                while(L<R){
                    if(str.charAt(L)!=str.charAt(R)){
                        flag = false;
                        break;
                    }
                    L++; R--;
                }
                if(flag) ans = Math.max(ans,(j-i)+1);
            }
        }
        System.out.println(ans);
    }
}
