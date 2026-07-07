package 전체문제2026.July.Second;

import java.util.*;

public class PR_리틀프렌즈사천성_Level_3 {
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        String[]board = {"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"};
        System.out.println(solution(m,n,board));
    }
    static char[][]map;
    static  String solution(int m, int n, String[] board) {
        String answer = "";
        int N = m;
        int M = n;
        TreeMap<Character, int[][]> treeMap = new TreeMap<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++){
                map[i] = board[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j]!='.' && map[i][j]!='*'){
                    char ch = map[i][j];
                    if(!treeMap.containsKey(ch)){
                        treeMap.put(ch, new int[2][2]);
                        treeMap.get(ch)[0][0] = i;
                        treeMap.get(ch)[0][1] = j;
                    }else{
                        treeMap.get(ch)[1][0] = i;
                        treeMap.get(ch)[1][1] = j;
                    }
                }
            }
        }
        while(true){
            boolean flag = false;
            Queue<Character> q = new ArrayDeque<>();
            for(char ch : treeMap.keySet()){
                int[]f = treeMap.get(ch)[0];
                int[]s = treeMap.get(ch)[1];

                int fi = f[0]; int fj = f[1];
                int si = s[0]; int sj = s[1];

                // (fi,fj) -> (fi,sj) -> (si,sj)
                boolean first =
                        checkRight(fi,fj,fi,sj,ch) &&
                                checkDown(fi,sj,si,sj,ch);

                // (fi,fj) -> (si,fj) -> (si,sj)
                boolean second =
                        checkDown(fi,fj,si,fj,ch) &&
                                checkRight(si,fj,si,sj,ch);

                if(first || second){
                    q.offer(ch);
                    map[f[0]][f[1]]='.';
                    map[s[0]][s[1]]='.';
                    flag=true;
                    break;
                }
            }
            if(!flag) break;
            while(!q.isEmpty()){
                char cur = q.poll();
                treeMap.remove(cur);
                answer += cur;
            }
        }
        return treeMap.size() != 0 ? "IMPOSSIBLE" : answer;

    }
    static boolean checkDown(int fi,int fj,int si,int sj,char ch){
        int d = fi < si ? 1 : -1;

        while(fi != si){
            fi += d;
            if(!isCanMove(fi,fj,ch)) return false;
        }

        return true;
    }
    static boolean checkRight(int fi,int fj,int si,int sj,char ch){
        int d = fj < sj ? 1 : -1;

        while(fj != sj){
            fj += d;
            if(!isCanMove(fi,fj,ch)) return false;
        }

        return true;
    }
    static boolean isCanMove(int i,int j,char ch){
        if(map[i][j]=='.') return true;
        if(map[i][j]==ch) return true;
        return false;
    }
}
