package 전체문제2026.April.Seventh;

public class PR_단체사진찍기_Level_2 {


    static String[]Data;
    static int N;
    static char[]member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int len;
    static char[]tmp;
    static int answer;
    static boolean[]visited;
    public static void main(String[] args) {
        int n = 2;
        String[]data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
    static int solution(int n, String[] data) {
        answer = 0;
        len = 8;
        tmp = new char[len];
        N = n;
        Data = data;
        visited = new boolean[len];
        perm(0);
        return answer;
    }
    static boolean calc(){
        for(String str : Data){
            char f = str.charAt(0);
            char s = str.charAt(2);
            char op = str.charAt(3);
            int range = Integer.parseInt(str.charAt(4)+"");
            int fp = -1; int sp = -1;
            for(int i=0;i<8;i++){
                if(fp!=-1 && sp!=-1) break;
                if(f==tmp[i]) fp = i;
                if(s==tmp[i]) sp = i;
            }
            int diff = Math.abs(fp-sp)-1;
            switch (op){
                case '>': if(diff<=range) return false;
                    break;
                case '<': if(diff>=range) return false;
                    break;
                case '=': if(diff!=range) return false;
                    break;
            }
        }
        return true;
    }
    static void perm(int depth){
        if(depth==len){
            if(calc())answer++;
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = member[i];
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
}
