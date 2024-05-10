package 전체문제.sixth_month_2024_05.eighth_2024_05_10;

import java.util.*;
import java.io.*;
public class BJ_3671_산업스파이의편지_Gold_5 {
    static boolean[]visited;
    static int N;
    static Set<Integer> set;
    static String num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int t=0;t<TC;t++){
            num = br.readLine();
            N = num.length();
            visited= new boolean[N];
            set = new HashSet<>();
            perm(0,"");
            int ans = 0;
            for(int num : set){
                if(num==0 ||num==1) continue;
                if(num==2) {
                    ans++;
                    continue;
                }
                boolean flag = true;
                for(int i=2;i<=Math.sqrt(num);i++){
                    if(num%i==0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) ans++;

            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static void perm(int depth,String value){

        if(depth!=0)set.add(Integer.parseInt(value));
        if(depth==N) return;
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                perm(depth+1,value+num.charAt(i));
                visited[i] = false;
            }
        }
    }
}
