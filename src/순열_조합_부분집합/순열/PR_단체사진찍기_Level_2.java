package 순열_조합_부분집합.순열;

public class PR_단체사진찍기_Level_2 {

    static char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[]visited;
    static int answer,N;
    static int dataCnt;
    static String [] Data;
    static int solution(int n, String[] data) {
        N = 8;
        dataCnt = n;
        Data = data;
        visited=  new boolean[8];
        dfs(0,"");
        return answer;
    }
    static boolean calc(String str){

        for(int tc=0;tc<dataCnt;tc++){
            char f = Data[tc].charAt(0);
            char s = Data[tc].charAt(2);
            char op = Data[tc].charAt(3);
            int range = Data[tc].charAt(4)-'0';
            range++;
            int fidx = str.indexOf(f);
            int sidx = str.indexOf(s);
            int diff = Math.abs(fidx-sidx);
            if(op=='=') {
                if (diff != range) return false;
            }else if(op =='<') {
                if (diff >= range) return false;
            }else {
                    if(diff<=range) return false;
                }
        }
        return true;
    }
    static void dfs(int depth,String str){
        if(depth==N){
            if(calc(str)) answer++;
            return;
        }
        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,str+FRIENDS[i]);
                visited[i] = false;
            }
        }
    }




    public static void main(String[] args){
        //Test Case
        //1. int n = 2; String [] data = {"N~F=0", "R~T>2"}; -> 3648;
        //2. int n = 2; String [] data = {"M~C<2", "C~M>1"}; -> 0;
        int n = 2; String [] data = {"M~C<2", "C~M>1"};
        System.out.println(solution(n,data));

    }
}
