package 전체문제2026.August.Fourteenth;

import java.util.*;
import java.io.*;
public class GR_이진수정렬_D2 {
    static class Node implements Comparable<Node>{
        int num; int oneCnt;

        public Node(int num,int oneCnt) {
            this.num = num;
            this.oneCnt = oneCnt;
        }

        @Override
        public int compareTo(Node o) {

            return oneCnt == o.oneCnt ? -(num-o.num) : -(oneCnt - o.oneCnt);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[]arr =new Node[N];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            int tmpNum = num;
            int cnt = 0;
            while(0<tmpNum){
                if(tmpNum%2==1) cnt++;
                tmpNum /= 2;
            }
            arr[i] = new Node(num,cnt);
        }
        Arrays.sort(arr);
        System.out.println(arr[K-1].num);

    }
}