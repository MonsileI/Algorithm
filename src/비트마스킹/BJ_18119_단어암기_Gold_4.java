package 비트마스킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18119_단어암기_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        StringBuilder sb=  new StringBuilder();
        int alphabat = (1<<27) - 1;
        int[]words = new int[N];
        for(int i=0;i<N;i++){
            char[] str = br.readLine().toCharArray();
            for(char ch : str) words[i] |= 1<<(ch-'a');
        }
        for(int t=0;t<Q;t++){
            st= new StringTokenizer(br.readLine()," ");
            int o = Integer.parseInt(st.nextToken());
            int x = st.nextToken().charAt(0)-'a';

            if(o==1) alphabat &= ~(1<<x);
            else alphabat |= (1<<x);
            int cnt = 0;
            for(int word : words) if((alphabat & word) >= word) cnt++;
            sb.append(cnt+"\n");
        }
        System.out.println(sb.toString());
    }
}
