package 전체문제2026.October.Third;

import java.util.*;
import java.io.*;
public class SWEA_1221_GNS_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        Map<String,Integer> map;
        String [] alpha = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
        while(0<TC){
            st = new StringTokenizer(br.readLine()," ");
            sb.append(st.nextToken()+" ");
            int N = Integer.parseInt(st.nextToken());
            st =new StringTokenizer(br.readLine()," ");
            map = new HashMap<>();
            for(int i=0;i<N;i++) {
                String str = st.nextToken();
                map.put(str,map.getOrDefault(str,0)+1);
            }
            for(int i=0;i<10;i++){
                for(String key : map.keySet()){
                    if(alpha[i].equals(key)){
                        int cnt = map.get(key);
                        for(int j=0;j<cnt;j++){
                            sb.append(key+" ");
                        }
                        break;
                    }
                }
            }
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
