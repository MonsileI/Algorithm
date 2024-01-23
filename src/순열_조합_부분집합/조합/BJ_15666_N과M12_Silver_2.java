package 순열_조합_부분집합.조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15666_N과M12_Silver_2 {
    static int N,M;
    static int[]arr;
    static StringBuilder sb;
    static Set<String>set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sb = new StringBuilder();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        perm(0,"",0);
        System.out.println(sb.toString());
    }
    static void perm(int depth, String now,int start){

        if(depth==M){
            now = now.substring(1,now.length());
            if(!set.contains(now)){
                set.add(now);
                sb.append(now+"\n");
            }
            return;
        }

        for(int i=start;i<N;i++){
            String newOne = now + " " + arr[i];
            perm(depth+1,newOne,i);
        }
    }
}
