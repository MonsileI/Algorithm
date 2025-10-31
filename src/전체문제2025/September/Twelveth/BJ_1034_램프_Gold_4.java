package 전체문제2025.September.Twelveth;

import java.util.*;
import java.io.*;
public class BJ_1034_램프_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[]map = new String[N];
        int[]cnt = new int[N];
        Map<String,Integer> checkMap = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            int zero = 0;
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                if(ch=='0'){
                    zero++;
                }
            }
            cnt[i] = zero;
            map[i] = str;
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            if(checkMap.containsKey(map[i])){
                checkMap.put(map[i],checkMap.getOrDefault(map[i],0)+1);
                continue;
            }
            if(K < cnt[i] || (K-cnt[i])%2==1) continue;
            checkMap.put(map[i],1);
        }

        int answer = 0;
        for(String str : checkMap.keySet()) answer = Math.max(answer,checkMap.get(str));
        System.out.println(answer);

    }
}
