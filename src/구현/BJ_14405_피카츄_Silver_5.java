package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_14405_피카츄_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        boolean flag = true;
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            if(ch=='p'){
                if(i==N-1){
                    flag = false;
                    break;
                }
                if(str.charAt(i+1)!='i'){
                    flag = false;
                    break;
                }
                i ++;
                continue;
            }else if(ch=='k'){
                if(i==N-1){
                    flag = false;
                    break;
                }
                if(str.charAt(i+1)!='a'){
                    flag = false;
                    break;
                }
                i ++;
                continue;
            }else if(ch=='c'){
                if(N-3<i){
                    flag= false;
                    break;
                }
                if(str.charAt(i+1)!='h' || str.charAt(i+2)!='u'){
                    flag = false;
                    break;
                }
                i += 2;
                continue;
            }else{
                flag= false;
                break;
            }

        }
            System.out.println(flag ? "YES" : "NO");
    }
}
