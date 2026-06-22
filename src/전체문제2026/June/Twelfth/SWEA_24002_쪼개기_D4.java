package 전체문제2026.June.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_24002_쪼개기_D4  {
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr =new int[N];
            int max = 0;
            for(int i=0;i<N;i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                max = Math.max(max,num);
            }
            int answer = Integer.MAX_VALUE;
            Map<Integer,Integer> numberMap = new HashMap<>();
            Map<Integer,Integer> cntNumberMap = new HashMap<>();
            for(int i=0;i<N;i++){
                map = new HashMap<>();
                dfs(arr[i],0);
                for(Integer num : map.keySet()) {
                    numberMap.put(num,numberMap.getOrDefault(num,0)+map.get(num));
                    cntNumberMap.put(num,cntNumberMap.getOrDefault(num,0)+1);
                    if (i == (N - 1) && cntNumberMap.get(num)==N) {
                        answer = Math.min(answer, numberMap.get(num));
                    }
                }
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
    static void dfs(int num,int cnt){
        if(num==0) return;
        if(map.containsKey(num) && map.get(num) <= cnt)
            return;
        map.put(num,cnt);
        dfs(num/2,cnt+1);
        if(num%2==1) dfs((num/2)+1,cnt+1);
    }
}
