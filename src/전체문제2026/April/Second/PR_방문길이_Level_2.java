package 전체문제2026.April.Second;

public class PR_방문길이_Level_2 {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));

    }
    static int solution(String dirs) {
        int answer = 0;

        boolean[][][]visited = new boolean[11][11][4];
        int [][]move = {{1,0},{0,1},{-1,0},{0,-1}};
        int i = 5;
        int j = 5;
        int len = dirs.length();
        for(int c=0;c<len;c++){
            int ni = i; int nj = j;
            char ch = dirs.charAt(c);
            int dir = 0;
            switch(ch){
                case 'U': dir=0; break;
                case 'R': dir=1; break;
                case 'D': dir=2; break;
                case 'L': dir=3; break;
            }
            ni += move[dir][0]; nj += move[dir][1];
            if(ni<0||nj<0||10<ni||10<nj){
                continue;
            }
            if(!visited[i][j][dir]){
                answer++;
                visited[i][j][dir] = true;
                visited[ni][nj][(dir+2)%4] = true; // 반대 방향도 체크
            }

            i = ni; j = nj;
        }

        return answer;
    }
}
