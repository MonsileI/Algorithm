package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_20365_블로그2_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int B = 0; int R = 0; //범위 개수 세기
        boolean flag = false; //파란색
        if(str.charAt(0)=='B') B++;
        else {
            flag = true;
            R++;
        }
        for(int i=1;i<N;i++){
            char ch = str.charAt(i);
            if(ch=='B'){
                if(!flag) continue;
                B++;
                flag = false;
            }else{
                if(flag) continue;
                R++;
                flag= true;
            }
        }
        System.out.println(Math.min(R,B)+1);

    }
}
