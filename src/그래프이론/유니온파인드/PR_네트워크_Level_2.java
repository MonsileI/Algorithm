package 그래프이론.유니온파인드;

public class PR_네트워크_Level_2 {

    static int N,parents[];
    static int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j]==1){
                    union((i+1),(j+1));
                }
            }
        }
        boolean[]check = new boolean[N+1];
        for(int i=1;i<N+1;i++){
            int parent = find(i);
            if(!check[parent]){
                check[parent] = true;
                answer++;
            }
        }
        return answer;
    }

    static void union(int a,int b){
        int rootA = find(a); int rootB = find(b);
        if(rootA<rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }


    public static void main(String[] args) {

        /*
          TEST CASE

          int n = 3;
          int[][]computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
          result = 2;

          int n = 3;
          int[][]computers = {{1, 1, 0},{1, 1, 1},{0, 1, 1}};
          result = 1;
        * */
        int n = 3;
        int[][]computers = {{1, 1, 0},{1, 1, 1},{0, 1, 1}};
        System.out.println(solution(n,computers));
    }
}
