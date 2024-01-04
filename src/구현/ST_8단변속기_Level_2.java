package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ST_8단변속기_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int check = 0; //증가
        int before = Integer.parseInt(st.nextToken());
        if(before==8) check = 1; //감소
        for(int i=0;i<7;i++){
            int num = Integer.parseInt(st.nextToken());
            if(check==0) {
                if(before!=num-1){
                    check = 2; //섞임
                    break;
                }
                before = num;
            }else{
                if(before!=num+1){
                    check = 2;
                    break;
                }
                before = num;
            }
        }
        String []ans = {"ascending", "descending", "mixed"};
        System.out.println(ans[check]);
    }
}
