package 비트마스킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11723_집합_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= null;
        StringBuilder sb= new StringBuilder();
        int flag = 0;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            String act = st.nextToken();
            if(act.equals("all")) flag = 2097150;
            else if(act.equals("empty")) flag = 0;
            else{
                int num = Integer.parseInt(st.nextToken());
                if(act.equals("add")) flag = flag | (1<<num);
                else if(act.equals("remove")) flag = flag & ~(1<<num);
                else if(act.equals("toggle"))  flag = (flag ^ (1<<num));
                else{
                    if((flag&(1<<num))==0) sb.append(0);
                    else sb.append(1);
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
