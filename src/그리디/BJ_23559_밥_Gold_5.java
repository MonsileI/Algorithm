package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_23559_밥_Gold_5 {

    static class Node implements Comparable<Node>{
        int fir; int sec; int comp;

        public Node(int fir, int sec,int comp) {
            this.fir = fir;
            this.sec = sec;
            this.comp = comp;
        }
        @Override
        public int compareTo(Node o) {
            return comp == o.comp ? -(sec - o.sec) : -(comp - o.comp);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())/1000;
        //상대적 만족도가 큰 5000원짜리 음식을 먼저 먹는다.
        Node[]arr =new Node[N];
        for(int i=0;i<N;i++){
            st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Node(a,b,(a-b));
        }
        Arrays.sort(arr);
        int ans = 0;
        boolean flag = true;
        //x가 남은 N이랑 같아지면,
        for(int i=0;i<N;i++){
            if((x-5)>=(N-i-1)) {
                if(arr[i].fir>arr[i].sec){
                    ans += arr[i].fir;
                    x -= 5;
                }else{
                    ans +=arr[i].sec;
                    x--;
                }
            }
            else{
                ans += arr[i].sec;
                x--;
            }
        }
        System.out.println(ans);
    }
}
