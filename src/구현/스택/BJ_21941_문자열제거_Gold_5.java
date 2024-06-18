package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_21941_문자열제거_Gold_5 {

    static class Node{
        String str;
        int score;

        public Node(String str, int score) {
            this.str = str;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String tmp = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            if(tmp.length()>=score) continue;
            list.add(new Node(tmp,score));
        }
        int len = str.length();
        int[]dp = new int[len+1];
        for(int i=0;i<len;i++){
            dp[i+1] = Math.max(dp[i+1],dp[i]+1);
            for(int j=0;j<list.size();j++){
                Node now = list.get(j);
                if(str.startsWith(now.str,i)){
                    dp[i+now.str.length()] = Math.max(dp[i+now.str.length()],dp[i] + now.score);
                }
            }
        }
        System.out.println(dp[len]);

    }
}
