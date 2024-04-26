package 구현.맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_26267_은행털자_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=  Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Map<Integer,Long> map = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x= Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.put((t-x),map.getOrDefault((t-x),0L)+c);
        }
        long ans = 0;
        for(int key : map.keySet()){
            ans = Math.max(ans,map.get(key));
        }
        System.out.println(ans);
    }
}
