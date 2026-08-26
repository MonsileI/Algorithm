package 전체문제2026.July.August.Eighteenth;

import java.util.*;
import java.io.*;
public class GR_서로다른정수의개수_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[]arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<K;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            answer = Math.max(answer,map.size());
        }
        for(int i=K;i<N;i++){
            //추가
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
            //제거
            if(map.get(arr[i-K])==1){
                map.remove(arr[i-K]);
            }else{
                map.put(arr[i-K],map.get(arr[i-K])-1);
            }
            answer = Math.max(answer,map.size());
        }
        System.out.println(answer);
    }
}