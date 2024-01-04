package 전체문제.second_month_2024_01.second_2024_01_03;

public class PR_단체사진찍기_Level_2 {


    static char[]members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean [] visited;
    static int N;
    static String[]Data;
    static int answer;
    static int solution(int n, String[] data) {
        N = n; Data = data;
        visited=  new boolean[8];
        dfs(0,"");
        return answer;
    }

    static boolean calc(String now){

        for(int i=0;i<N;i++){
            char f = Data[i].charAt(0);
            char s = Data[i].charAt(2);
            char op = Data[i].charAt(3);
            int range = Data[i].charAt(4)-'0';
            range++;
            int fRange = now.lastIndexOf(f);
            int sRange = now.lastIndexOf(s);
            int diff = Math.abs(fRange-sRange);
            if(op =='=') {
                if (diff != range) return false;
            }else if(op =='>') {
                if (diff <= range) return false;
            }else {
                if(diff >= range) return false;
            }


        }
        return true;
    }
    static void dfs(int depth,String now){

        if(depth==8){
            if(calc(now)) answer++;
            return;
        }


        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,now+members[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        /*
        TEST CASE
        int n = 2; String[]data = {"N~F=0", "R~T>2"}; answer  = 3648;
        int n = 2; String[]data = {"M~C<2", "C~M>1"}; answer = 0;
        * */
        int n = 2; String[]data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
}
