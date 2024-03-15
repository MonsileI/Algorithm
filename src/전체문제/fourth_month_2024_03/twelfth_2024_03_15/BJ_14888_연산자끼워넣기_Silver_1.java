package 전체문제.fourth_month_2024_03.twelfth_2024_03_15;
import java.util.*;
import java.io.*;
public class BJ_14888_연산자끼워넣기_Silver_1 {
    static int N;
    static int [] arr;
    static int [] op;
    static int [] tmp;
    static int  M;
    static int min = 1987654321;
    static int max = -1987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N-1;
        arr= new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        op = new int[4];
        for(int i=0;i<4;i++)op[i] = Integer.parseInt(st.nextToken());
        tmp = new int[M];
        dfs(0);
        System.out.println(max);
        System.out.println(min);

    }
    static void dfs(int depth){
        if(depth==M){
            int idx = 0;
            int sum = arr[0];
            for(int i=1;i<N;i++){
                int op = tmp[idx++];
                switch (op){
                    case 0 : sum += arr[i];
                        break;
                    case 1 : sum -= arr[i];
                        break;
                    case 2 : sum *= arr[i];
                        break;
                    case 3 : sum /= arr[i];
                        break;
                }
            }
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            return;
        }
        for(int i=0;i<4;i++){
            if(op[i]!=0){
                op[i]--;
                tmp[depth] = i;
                dfs(depth+1);
                op[i]++;
            }
        }
    }
}
