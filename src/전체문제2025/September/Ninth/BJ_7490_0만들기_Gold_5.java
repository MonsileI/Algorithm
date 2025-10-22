package 전체문제2025.September.Ninth;

import java.util.*;
import java.io.*;
public class BJ_7490_0만들기_Gold_5 {

    static int N;
    static List<String> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        while(0<TC){
            answer =  new ArrayList<>();
            N =Integer.parseInt(br.readLine());
            dfs(1,"1");
            TC--;
            for(String str : answer){
                sb.append(str+"\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    static void calc(String originStr){
        String str = originStr.replaceAll(" ","");
        StringTokenizer st = new StringTokenizer(str, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while(st.hasMoreElements()){
            String s = st.nextToken();
            if(s.equals("+")){
                sum += Integer.parseInt(st.nextToken());
            }else{
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if(sum==0) answer.add(originStr);
    }
    static void dfs(int depth,String str){
        if(depth==N){
            calc(str);
            return;
        }


        dfs(depth+1,str+" "+(depth+1));
        dfs(depth+1,str+"+"+(depth+1));
        dfs(depth+1,str+"-"+(depth+1));

    }
}
