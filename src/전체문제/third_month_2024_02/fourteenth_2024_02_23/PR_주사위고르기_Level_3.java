package 전체문제.third_month_2024_02.fourteenth_2024_02_23;
import java.util.*;
public class PR_주사위고르기_Level_3 {

    static int[]tmp;
    static int[][]D;
    static int N;
    static List<Integer> fir;
    static List<Integer> sec;
    static int max;
    static int [] answer;
    static int[] solution(int[][] dice) {
        D = dice;
        N = dice.length;
        answer= new int[N/2];
        tmp = new int[N/2];
        comb(0,0);
        return answer;
    }
    static void calc(){
        int[]other = new int[N/2];
        boolean[]visited = new boolean[N];
        for(int i=0;i<N/2;i++)visited[tmp[i]] = true;
        int idx = 0;
        for(int i=0;i<N;i++) if(!visited[i]) other[idx++] = i;
        fir = new ArrayList<>();
        sec = new ArrayList<>();
        dfs(fir,tmp,0,0);
        dfs(sec,other,0,0);
        Collections.sort(sec);
        int sum = 0;
        for(int num : fir){
            int L = 0; int R = sec.size();
            while(L<R){
                int mid = (L+R)/2;
                if(sec.get(mid)<num) L = mid+1;
                else R = mid;
            }
            sum +=R;
        }
        if(max<sum){
            max = sum;
            for(int i=0;i<N/2;i++)answer[i] = (tmp[i]+1);
        }
    }
    static void dfs(List<Integer>list,int[]dice,int depth,int sum){

        if(depth==N/2){
            list.add(sum);
            return;
        }

        for(int i=0;i<6;i++){
            dfs(list,dice,depth+1,sum+D[dice[depth]][i]);
        }
    }
    static void comb(int depth,int start){

        if(depth==N/2){
            calc();
            return;
        }

        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }


    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};

        int []result = {1,4};

        2.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{2, 2, 4, 4, 6, 6}};

        int []result = {2};

        3.
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};

        int []result = {1,3};

        * */
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
