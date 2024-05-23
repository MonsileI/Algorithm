package 전체문제.sixth_month_2024_05.sixteenth_2024_05_23;

import java.util.*;
import java.io.*;
public class BJ_19238_스타트택시_Gold_2 {
    static class Customer {
        int si; int sj; int ei; int ej;

        public Customer(int si, int sj, int ei, int ej) {
            this.si = si;
            this.sj = sj;
            this.ei = ei;
            this.ej = ej;
        }
    }
    static int [][]map;
    static int N,C,F;
    static Customer[] customers;
    static int si,sj;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean flag = true;
    static int answer;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        si = Integer.parseInt(st.nextToken())-1;
        sj = Integer.parseInt(st.nextToken())-1;
        customers = new Customer[C];
        for(int i=0;i<C;i++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int ei = Integer.parseInt(st.nextToken())-1;
            int ej = Integer.parseInt(st.nextToken())-1;
            customers[i] = new Customer(fi,fj,ei,ej);
        }
        //승객을 고르자
        calc();
        System.out.println(flag ? answer : -1) ;

    }
    static int bfs(int si,int sj,int ei,int ej,int fure,boolean se){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        boolean[][]visited=  new boolean[N][N];
        visited[si][sj] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            if(se&&min<cnt) return 987654321;
            if(fure<cnt) return 987654321;

            if(i==ei && j==ej) return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]==0){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return 987654321;
    }
    static void calc(){
        int fure = F;
        //이제 손님을 태워보자
        int ti = si; int tj = sj; //택시 위치
        int clear = 0;
        boolean[]check = new boolean[C];
        //승객 고르기
        while(0<C){
            min = 987654321;
            int idx = -1;
            int minI = 987654321;
            int minJ = 987654321;
            for(int t=0;t<C;t++){
                if(check[t]) continue;
                Customer customer = customers[t];
                int sum = bfs(ti,tj,customer.si, customer.sj,fure,true);
                if(sum<min){
                    min = sum;
                    minI = customer.si;
                    minJ = customer.sj;
                    idx = t;
                }else if(sum==min){
                    if(minI>customer.si) {
                        minI = customer.si;
                        minJ = customer.sj;
                        idx = t;
                    }else if(minI==customer.si){
                        if(minJ>customer.sj){
                            minI = customer.si;
                            minJ = customer.sj;
                            idx = t;
                        }
                    }
                }
            }
            if(fure<min) {
                flag= false;
                return;
            }
            check[idx] = true;
            //승객을 골랐다면, 델다 줘야해
            fure -= min;
            ti = customers[idx].si; tj =customers[idx].sj;
            int sum = bfs(ti,tj,customers[idx].ei,customers[idx].ej,fure,false);
            if(fure<sum) {
                flag = false;
                return;
            }
            fure += sum;
            ti = customers[idx].ei; tj = customers[idx].ej;
            clear++;
            if(clear==C){
                answer = fure;
                return;
            }
        }
    }
}