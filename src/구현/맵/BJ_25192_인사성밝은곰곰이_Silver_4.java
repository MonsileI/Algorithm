package 구현.맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class BJ_25192_인사성밝은곰곰이_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            if(tmp.equals("ENTER")){
                map = new HashMap<>();
                continue;
            }
            if(!map.containsKey(tmp)){
                map.put(tmp,0);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
