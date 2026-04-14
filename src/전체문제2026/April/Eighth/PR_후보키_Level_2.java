package 전체문제2026.April.Eighth;

import java.util.*;

public class PR_후보키_Level_2 {
    static int N;
    static int M;
    static String[][]Table;
    static int []tmp;
    static int answer;
    static List<Integer> candidateKeys = new ArrayList<>();
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"}, {"200","apeach","math","2"}, {"300","tube","computer","3"}, {"400","con","computer","4"}, {"500","muzi","music","3"}, {"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
    static int solution(String[][] relation) {
        answer = 0;
        Table = relation;
        N = relation.length;//총 레코드 개수
        M = relation[0].length; //총 속성 개수
        tmp = new int[M];
        Arrays.fill(tmp,-1);
        for(int i=0;i<M;i++){
            comb(0,0,(i+1));
        }
        return answer;
    }
    static void calc(int goal){
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            String str = "";
            for(int j = 0; j < goal; j++){
                str += Table[i][tmp[j]] + "|";
            }
            if(set.contains(str)) return;
            set.add(str);
        }

        // mask 생성
        int mask = 0;
        for(int i=0;i<goal;i++){
            mask |= (1<<tmp[i]);
        }
        for(int key : candidateKeys){
            if((key & mask) == key) return;
        }
        candidateKeys.add(mask);
        answer++;
    }
    static void comb(int start, int depth,int goal){

        if(depth == goal){
            calc(goal);
            return;
        }

        for(int i=start;i<M;i++){
            tmp[depth] = i;
            comb(i+1,depth+1,goal);
            tmp[depth] = -1;
        }

    }
}
