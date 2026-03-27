package 전체문제2026.March.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_4659_비밀번호발음하기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String acceptable = " is acceptable.";
        String notAcceptable = " is not acceptable.";

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            sb.append("<" + str + ">" );

            char before = str.charAt(0);
            int len = str.length();
            int zaum = 0;
            int moum = 0;
            boolean moumFlag = false;
            if(before=='a' || before=='e' || before=='i' || before=='o' || before=='u') {
                moum++;
                moumFlag = true;
            }else {
                zaum++;
            }
            if(len==1){
                    if(moum==1) {
                        sb.append(acceptable + "\n");
                    }else {
                        sb.append(notAcceptable+"\n");
                    }
                continue;
            }
            boolean flag = false;
            for(int i=1;i<len;i++){
                char ch = str.charAt(i);
                if(ch==before){
                    if(ch!='e' && ch!='o'){
                        sb.append(notAcceptable + "\n");
                        flag = true;
                        break;
                    }
                }
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    moum++;
                    moumFlag = true;
                    zaum = 0;
                }else{
                    zaum++;
                    moum = 0;
                }
                if(3<=zaum || 3<=moum){
                    sb.append(notAcceptable+"\n");
                    flag = true;
                    break;
                }
                before = ch;
            }
            if(!moumFlag && !flag){
                sb.append(notAcceptable+"\n");
                continue;
            }
            if(!flag){
                sb.append(acceptable+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
