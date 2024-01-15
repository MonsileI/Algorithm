package 전체문제.second_month_2024_01.tenth_2024_01_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PR_주사위고르기_Level_3_RE {

    static int N;
    static boolean[]visited;
    static List<int[]> combA;
    static int[]tmp;
    static int[][]D;
    static List<Integer> listA;
    static List<Integer> listB;
    static int[] solution(int[][] dice) {


        //A의 조합을 전부 뽑아낸다.
        N = dice.length;
        D = dice;
        //정답 저장 배열
        int[]answer = new int[N/2];
        //정답 비교 변수
        int max = 0;

        visited = new boolean[N];
        combA = new ArrayList<>();
        tmp = new int[N/2];
        comb1(0,0);

        for(int[]arrA : combA){
            boolean[]check = new boolean[N];
            int[]arrB = new int[N/2];
            for(int i : arrA) check[i] = true;
            int idx = 0;
            for(int i=0;i<N;i++)if(!check[i]) arrB[idx++] = i; //골라지지 않는건 B꺼
            listA = new ArrayList<>();
            listB = new ArrayList<>();
            comb2(0,listB,0,arrB);
            Collections.sort(listB);
            int size = listB.size();
            int sum = 0;
            for(Integer a : listA){
                int L = 0; int R = size;
                while(L<R){
                    int mid = (L+R)/2;
                    if(listB.get(mid)<a) L = mid+1;
                    else R = mid;
                }
                sum += L;
            }
            if(max<sum){
                max = sum;
                for(int i=0;i<N/2;i++)answer[i] = arrA[i]+1;
            }
        }

        return answer;
    }
    static void comb2(int depth,List<Integer>team,int sum,int[]combDice){

        if(depth==N/2){
            team.add(sum);
            return;
        }

        for(int i=0;i<6;i++){
            comb2(depth+1,team,sum+D[combDice[depth]][i],combDice);
        }
    }
    static void comb1(int depth,int start){

        if(depth==N/2){
            combA.add(tmp.clone());
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                comb1(depth+1,i+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        int []result = {1,4}

        2.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{2, 2, 4, 4, 6, 6}};
        int []result = {2}

        3.
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int []result = {1,3}
        * */
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
