package 구현;

import java.util.HashMap;
import java.util.Map;

public class PR_가장많이받은선물_Level_1 {


    static int solution(String[] friends, String[] gifts) {

        int N = friends.length;
        int idx = 0;
        Map<String,Integer> map = new HashMap<>();
        int[][]relations = new int[N][N];
        int[]total = new int[N]; //선물을 준 수에서 선물을 받은 수를 뺸 값
        for(int i=0;i<friends.length;i++) map.put(friends[i],idx++);
        for(int i=0;i<gifts.length;i++){
            String []tmp = gifts[i].split(" ");
            int f = map.get(tmp[0]);
            int s = map.get(tmp[1]);
            relations[f][s]++;
            total[f]++; total[s]--;
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            int tmp = 0;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(relations[i][j]>relations[j][i]) tmp++;
                else if(relations[i][j]==relations[j][i]){
                    if(total[i]>total[j]) tmp++;
                }
            }
            ans = Math.max(ans,tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int result = 2;

        2.
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        int result = 4;


        3.
        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        int result = 0;
        * */
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends,gifts));
    }
}
