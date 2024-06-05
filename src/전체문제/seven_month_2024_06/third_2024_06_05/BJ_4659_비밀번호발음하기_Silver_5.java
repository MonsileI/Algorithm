package 전체문제.seven_month_2024_06.third_2024_06_05;

import java.util.*;
import java.io.*;
public class  BJ_4659_비밀번호발음하기_Silver_5  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String right = "acceptable.";
        String wrong = "not acceptable.";

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            boolean flag = true;
            int N = str.length();
            if(str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u")) {
                char f = str.charAt(0);
                boolean mz = true; //자음
                if(f=='a'||f=='e'||f=='i'||f=='o'||f=='u') mz = false;
                int cnt = 1;
                for(int i=1;i<N;i++){
                    char ch = str.charAt(i);
                    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                        if(mz) {
                            mz = false;
                            cnt = 1;
                        }else{
                            cnt++;
                        }
                    }else{
                        if(!mz){
                            mz = true;
                            cnt = 1;
                        }else cnt++;
                    }
                    if(cnt==3){
                        flag = false;
                        break;
                    }
                    if(ch==str.charAt(i-1)){
                        if(ch!='e' && ch!='o'){
                            flag = false;
                            break;
                        }
                    }

                }
            }else flag = false;
            sb.append("<"+str+"> is ");
            sb.append(flag ? right : wrong);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
