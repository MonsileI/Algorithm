package 전체문제2026.November.Third;

import java.util.*;

public class PR_이모티콘할인행사_Level_2 {
    public static void main(String[] args) {
        int[][]users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[]emoticons = {1300, 1500, 1600, 4900};
        System.out.println(Arrays.toString(solution(users,emoticons)));
    }
    static int[] dcArr;
    static int[][]USERS;
    static int[]EMO;
    static int eLen,uLen,maxUser,maxCost;
    static int[]answer;
    static int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        EMO = emoticons;
        USERS = users;
        eLen = emoticons.length;
        uLen = users.length;
        dcArr = new int[eLen];
        perm(0);
        return answer;
    }
    static void calc(){
        int totalCost = 0;
        int totalUser = 0;
        for(int i=0;i<uLen;i++){
            int cost = 0;
            int userP = USERS[i][0];
            int userM = USERS[i][1];
            for(int j=0;j<eLen;j++){
                if(userP <= dcArr[j]){
                    cost += (int)(EMO[j] * ((100.0 - dcArr[j]) * 0.01));
                }
                if(userM<=cost){
                    totalUser++;
                    cost = 0;
                    break;
                }
            }
            totalCost += cost;
        }
        if(maxUser < totalUser){
            maxUser = totalUser;
            maxCost = totalCost;
            answer[0] = totalUser;
            answer[1] = totalCost;
        }else if(maxUser==totalUser){
            if(maxCost < totalCost){
                maxCost = totalCost;
                answer[0] = totalUser;
                answer[1] = totalCost;
            }
        }
    }
    static void perm(int depth){
        if(depth==eLen){
            calc();
            return;
        }
        for(int p=10;p<=40; p += 10){
            dcArr[depth] = p;
            perm(depth+1);
        }
    }
}
