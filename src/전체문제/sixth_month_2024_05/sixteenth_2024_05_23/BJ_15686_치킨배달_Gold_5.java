package 전체문제.sixth_month_2024_05.sixteenth_2024_05_23;

import java.util.*;
import java.io.*;
public class BJ_15686_치킨배달_Gold_5  {
    static int N;
    static List<int[]> chicken;
    static List<int[]> house;
    static int M;
    static int [] tmp;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>(); house = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1) house.add(new int[]{i,j});
                if(num==2) chicken.add(new int[]{i,j});
            }
        }
        tmp = new int[M];
        comb(0,0);
        System.out.println(answer);
    }
    static void calc(){
        int sum = 0;
        for(int []h :house){
            int min = Integer.MAX_VALUE;
            for(int i  : tmp){
                min = Math.min(min,Math.abs(h[0]-chicken.get(i)[0])+Math.abs(h[1]-chicken.get(i)[1]));
            }
            sum += min;
            if(sum>=answer) return;
        }
        answer = Math.min(answer,sum);
    }
    static void comb(int start,int depth){
        if(depth==M){
            calc();
            return;
        }
        for(int i=start;i<chicken.size();i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
