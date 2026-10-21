package 전체문제2026.October.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_1244_최대상금_D3 {
    static int answer;
    static int len;
    static Map<Integer,Set<String>> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            answer = 0;
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine()," ");
            String num = st.nextToken();
            len = num.length();
            int turn = Integer.parseInt(st.nextToken());
            for(int i=0;i<=turn;i++) map.put(i,new HashSet<>());
            dfs(num,turn);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(String num,int turn){
        if(map.get(turn).contains(num)) return;
        map.get(turn).add(num);
        if(turn==0){
            answer = Math.max(answer,Integer.parseInt(num));
            return;
        }
        for(int i=0;i<len;i++){
            char[] tmp = num.toCharArray();
            char f = num.charAt(i);
            for(int j=i+1;j<len;j++){
                char s = num.charAt(j);
                tmp[j] = f;
                tmp[i] = s;
                dfs(String.valueOf(tmp),turn-1);
                tmp[i] = f;
                tmp[j] = s;
            }
        }


    }
}
