package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16202_MST게임_Gold_3 {

    static class Node {
        int from; int to; int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


    }
    static int[]parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Node>list = new ArrayList<>();
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b,i));
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int cnt = 0;
        OuterLoop:
        while (cnt<C) {
            if(flag){
                sb.append(0+" ");
                cnt++;
                continue;
            }
            parents = new int[N+1];
            for(int i=1;i<N+1;i++)parents[i] = i;
            int VCnt = 0;
            int sum = 0;
            int size = list.size();
            for(int i=cnt;i<size;i++){
                Node now = list.get(i);
                if(find(now.from)!=find(now.to)){
                    union(now.from,now.to);
                    sum += now.weight;
                    VCnt++;
                }
                if(VCnt==N-1) break;
            }
            if(VCnt==N-1){
                sb.append(sum+" ");
                cnt++;
            }else flag = true;
        }
        System.out.println(sb.toString());


    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
}
