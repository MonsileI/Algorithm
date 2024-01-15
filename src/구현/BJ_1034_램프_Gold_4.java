package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1034_램프_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> checkMap = new HashMap<>();
        String[]map = new String[N];
        for(int i=0;i<N;i++) map[i] = br.readLine();
        int K = Integer.parseInt(br.readLine());

        OuterLoop:
        for(int i=0;i<N;i++){
            if(checkMap.containsKey(map[i])){
                checkMap.put(map[i],checkMap.get(map[i])+1);
                continue;
            }
            int tmp = K;
            for(int j=0;j<M;j++){
                char ch = map[i].charAt(j);
                if(ch=='0') tmp--;
                if(tmp<0) continue OuterLoop;
            }
            if(tmp%2==1) continue;
            checkMap.put(map[i],1);

        }
        int ans = 0;
        for(String str : checkMap.keySet()) ans  = Math.max(ans,checkMap.get(str));
        System.out.println(ans);
    }
}
