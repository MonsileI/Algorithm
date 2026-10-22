package 전체문제2026.October.Thirteenth;


public class PR_단체사진찍기_Level_2 {
    public static void main(String[] args) {
        int n = 2;
        String[]data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
    static char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int N;
    static boolean[]visited;
    static char[] tmp;
    static int answer;
    static String[]Data;
    static int solution(int n, String[] data) {
        N = member.length;
        Data =data;
        visited=  new boolean[N];
        tmp = new char[N];
        dfs(0);
        return answer;
    }
    static boolean calc(){
        String mem = String.valueOf(tmp);
        for(String str : Data){
            char f = str.charAt(0);
            char s =  str.charAt(2);
            char op = str.charAt(3);
            int value = str.charAt(4) - '0';
            int fIdx = mem.indexOf(f);
            int sIdx = mem.indexOf(s);
            int diff = Math.abs(fIdx-sIdx) - 1;
            switch (op){
                case '=' :
                    if(diff!=value) return false;
                    break;
                case '<' :
                    if(diff>=value) return false;
                    break;
                case '>' :
                    if(diff<=value) return false;
                    break;
            }
        }
        return true;
    }
    static void dfs(int depth){
        if(depth==N){
            if(calc()) answer++;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = member[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }
}
