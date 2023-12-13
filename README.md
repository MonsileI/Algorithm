# Algorithm

### 코딩 테스트 대비와 재미를 위한 알고리즘 풀이 공간

## 😝 알고리즘을 정리하고 풀이하여 적용해서 갓생살자 😝

### 📚**목차**

- 알고리즘 분류
- 알고리즘 개념 및 예시
- 알고리즘 별 대표 문제

### Ground Rule

- 최선을 다해 문제를 푼다.
- 1시간 이상 해결되지 않을시, 검색을 통해 학습한다.
- 찡찡대지 않는다.

### 📏 Repository 규칙 📏

- **알고리즘 별로 분류한다.**
- **알고리즘이 여러가지 쓰이는 경우, ‘복합’ 패키지에 저장하고, 각 알고리즘 패키지에 한번 더 넣는다.**
    
    ```
     ex)        BFS + 비트마스킹의 경우, ‘복합’ 패키지에 저장, BFS와 
                비트마스킹 패키지 모두에  저장
    
    ```
    
- **Commit Message는 날짜, 푼 문제, 알고리즘 분류, 느낀점 순으로 기재한다.**
    
    ```
      ex)        2023-12-11 : 5문제
                 알고리즘 : 1. 완전탐색 - 3문제
                           2. 다익스트라 - 2문제
    
                 느낀점 : 쉽지 않다. 조금 더 기본기를 쌓을 필요가 있다!
    
    ```
    
- **문제풀이가 아닌 디렉토리 구조 변경, readMe 파일 변경, 설정 등 Commit의 경우 날짜, 제목, 내용순으로 한다.**
    
    ```
       ex)      2023-12-11 : Readme 파일 작성 및 파일 디렉토리 구조 설정
    
                알고리즘 정리 공간을 위한 첫번째 커밋 및 Readme 파일 작성,
                파일  디렉토리 구조를 설
                정하였다.
    
    ```
    
- **1일 1커밋! 단, Weekend엔 Backend도 쉽니다** 😊

---

### ✔️ 알고리즘 분류

1. 순열, 조합, 부분집합
2. 완전탐색 (Brute Force)
    - DFS
    - BFS
3. 그래프 이론
    - 다익스트라
    - 플로이드 와샬
    - 유니온파인드
    - MST
    - 위상정렬
    - 벨만포드
4. 문자열 관련 알고리즘
    - LCS
    - KMP
    - Trie
5. DP
    - LIS
    - Knapsack
    - Bottom Up
    - Top Down
6. 이진탐색 (Binary Search)
7. Greedy
    - 정렬 Greedy
8. 트리
    - LCA
9. 비트마스킹
10. 구현

---

### 정의 및 예시

<details>
<summary>1. 순열, 조합, 부분집합</summary>
    <h4>예제 구현 형식은 전부 DFS(깊이 우선 탐색)방식, 재귀 방식을 따를 것이다. 완전탐색의 일종이다.</h4>
    <details>
    <summary>순열(Permutation)</summary>
        <div>
        정의 : 순열은 주어진 원소들로 만들 수 있는 모든 가능한 순서나 배열을 나열하는 것을 의미한다.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(n!)
        </div>
        <div>
        ex [1,2,3] 이라는 배열이 있고, 2개의 길이를 가진 순열을 구한다면,</br>
        [1, 2]</br>
        [1, 3]</br>
        [2, 1]</br>
        [2, 3]</br>
        [3, 1]</br>
        [3, 2]</br>
        총 6가지의 경우의 수가 나올 것이다.
        

    import java.util.Arrays;
    public class Main {
    
        static int [] tmp;
        static boolean[]visited;
        static int[]arr;
        static int N; //배열의 길이
        static int M; //구하고자 하는 원소의 개수
        public static void main(String[] args) {
            arr = new int[]{1,2,3}; //TEST CASE
            N = arr.length;
            M = 2; //이 예시에서는 설명에서와 같이 2개의 원소를 뽑아낼 예정이다.
            tmp = new int[M]; // 넣어줄 배열
            visited = new boolean[N]; //방문 배열
            perm(0);
        }
        static void perm(int depth){
            if(depth==M){
                System.out.println(Arrays.toString(tmp));
                return;
            }
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    tmp[depth] = arr[i];
                    perm(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
       
        
재귀 코드가 직관적이지 않을 수 있다.
        
1. 천천히 살펴보면, 우선, perm의 코드를 돌며, visited[i]가 true인 값을 찾는다.


2.  temp[0] = arr[0]을 넣어주고, true 처리를 해준다. perm()함수를 depth+1한 상태로 재귀한다.

3. DFS 특성상, 가장 깊은 1,2가 tmp에 들어가는 순간, depth==M이 될 것이다. 그럼 tmp를 리턴한다.

4. 그럼 마지막 for문 입장에서는 visited[i]가 false인 3을 tmp[depth]에 넣어주고, perm을 한다. 그럼 depth가 2가 되고, 1,3이 tmp가 되는 것이다.

        
😀재귀코드는 머리로 따라가기가 쉽지 않다. 플랫하게 생각하며 그림을 직접 그려보며 코드를 따라가면 누구나 이해할 수 있다!
        

   </details>
    <details>
    <summary>조합(Combination)</summary>
        <div>
        정의 : 조합은 주어진 집합에서 원소들을 순서에 상관없이 선택하여 부분집합을 만드는 것
        </div>
        <div></div>
        <div>
        시간복잡도 : O(n!)
        </div>
        <div>
        ex [1,2,3] 이라는 배열이 있고, 2개의 길이를 가진 조합을 구한다면,
        [1, 2]</br>
        [1, 3]</br>
        [2, 3]</br>
        </div>
        총 3가지의 경우의 수가 나올 것이다.
        <div>
        이처럼 조합은 순서가 중요하지 않다. 순열에서 [1,2]와[2,1]가 다른 값이었다면, 조합에선 같은 값으로 인식한다.
        </div>
        

    import java.util.Arrays;
    public class Main {
    
        static int [] tmp;
        static int[]arr;
        static int N; //배열의 길이
        static int M; //구하고자 하는 원소의 개수
        public static void main(String[] args) {
            arr = new int[]{1,2,3}; //TEST CASE
            N = arr.length;
            M = 2; //이 예시에서는 설명에서와 같이 2개의 원소를 뽑아낼 예정이다.
            tmp = new int[M]; // 넣어줄 배열
            comb(0,0);
        }
        static void comb(int depth,int start){
            if(depth==M){
                System.out.println(Arrays.toString(tmp));
                return;
            }
            for(int i=start;i<N;i++){
                tmp[depth] = arr[i];
                perm(depth+1,i+1);
                visited[i] = false;
                
            }
        }
    }
       
        
재귀 코드가 직관적이지 않을 수 있다.
        
1. 천천히 살펴보면, 우선, comb() 메서드의 for문은 start값, 즉 i+1값으로 시작한다. 


2.  temp[0] = arr[0]을 넣어주고, comb()함수를 depth+1, start엔 i+1값 상태로 재귀한다.

3. DFS 특성상, 가장 깊은 1,2가 tmp에 들어가는 순간, depth==M이 될 것이다. 그럼 tmp를 리턴한다.

4. 그럼 마지막 for문 입장에서는 visited[i]가 false인 3을 tmp[depth]에 넣어주고, perm을 한다. 그럼 depth가 2가 되고, 1,3이 tmp가 되는 것이다.

        
😀재귀코드는 머리로 따라가기가 쉽지 않다. 플랫하게 생각하며 그림을 직접 그려보며 코드를 따라가면 누구나 이해할 수 있다!
        

  </details>
    <details>
    <summary>부분집합(Subset)</summary>
        <div>
        정의 : 부분집합은 어떤 집합의 원소 중 일부 또는 전체를 포함하는 새로운 집합. 즉, 주어진 집합의 어떤 원소를 선택하거나 선택하지 않는 모든 가능한 경우를 고려하여 생성된 부분집합은 해당 집합의 부분집합입니다.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(2n)
        </div>
        <div>
        ex [1, 1, 1, 1, 1] 이라는 배열이 있고, 더하거나 빼서 3을 만들 수 있는 경우의 수를 계산하면,
        -1+1+1+1+1 = 3</br>
        +1-1+1+1+1 = 3</br>
        +1+1-1+1+1 = 3</br>
        +1+1+1-1+1 = 3</br>
        +1+1+1+1-1 = 3</br>
        총 5가지의 경우의 수가 나올 것이다.
        

    import java.util.Arrays;
    public class Main {
    
        static int[]arr;
        static int target;
        static int N;
        static int answer;
        public static void main(String[] args) {
            arr = new int[]{1,1,1,1,1}; //TEST CASE
            N = arr.length;
            target = 3; //이 예시에서는 설명에서와 같이 3이라는 목표값을 설정한다.
            subset(0,0); 
            System.out.println(answer);
        }
        static void subset(int depth,int sum){
            if(depth==N){
                if(sum==target) answer++;
                return;
            }
            int newSum = sum + arr[depth]; //기존 sum값에 원소 +
            subset(depth+1,newSum); 
            newSum = sum -arr[depth]; //기존 sum값에 원소 -
            subset(depth+1,newSum);
            
        }
    }
       
        
순열, 조합보다는 코드가 단순하다.
        
1. arr[0]부터 N까지 돌며, 어떤 sum값엔 원소를 더해주고, 어떤 sum값엔 원소를 빼주면서 재귀 함수를 호출한다.


2.  depth가 N, 즉 전체 원소를 다 돌았고, 목표로 했던 target number와 수가 같다면, answer을 +1 해준다.
        
😀생각보다 많이 쓰이는 부분집합 코드이다.
        

</details>
</details>

<!--구분선-->
---

<details>
<summary>2. 완전탐색</summary>

<h3>Brute Force, 용어 그대로 모든 경우의 수를 탐색하여 해답을 찾아내는 알고리즘이다.</h3>

<details>
<summary>깊이우선탐색(DFS)</summary>
        <div>
        정의 : 그래프나 트리 등의 자료 구조에서 어떤 노드를 시작으로 깊이 방향으로 탐색하는 알고리즘. 이 알고리즘은 더 이상 탐색할 노드가 없을 때까지 최대한 깊숙히 들어가서 탐색한 후, 다시 돌아와 다음 분기로 넘어가며 탐색을 진행한다.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(n^2)
        </div>

                    1
                   / \                      
                2       3
              /    \      \
            4       5       6
                       

이런 트리가 있다면, DFS의 탐색은 1 -> 2 -> 4 -> 5 -> 3 -> 6 이다.

    import java.util.ArrayList;
    import java.util.List;

    class Graph {
        private int V; // 정점의 수
        private List<List<Integer>> adjList; // 인접 리스트

        // 그래프 초기화
        public Graph(int vertices) {
            this.V = vertices;
            this.adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                this.adjList.add(new ArrayList<>());
            }
        }

        // 간선 추가
        public void addEdge(int source, int destination) {
            adjList.get(source).add(destination);
        }

        // DFS 탐색
        public void DFS(int startVertex) {
            boolean[] visited = new boolean[V];
            DFSUtil(startVertex, visited);
        }

        private void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            // 현재 정점에 인접한 모든 미방문 정점을 재귀적으로 방문
            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    public class DFSGraphExample {
        public static void main(String[] args) {
            Graph graph = new Graph(6);

            // 그래프의 간선 추가
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 4);
            graph.addEdge(2, 5);

            System.out.println("DFS 탐색 순서:");
            graph.DFS(0);
        }
    }

       
        
😀가끔은 완전탐색이 좋을때가 있다:)

</details>

<details>
<summary>너비우선탐색(BFS)</summary>
<div markdown="1">
        <div>
        정의 : 그래프나 트리 등의 자료 구조에서 어떤 노드를 시작으로 너비 방향으로 탐색하는 알고리즘.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(n^2)
        </div>

                    1
                   / \                      
                2       3
              /    \      \
            4       5       6
                       

이런 트리가 있다면, DFS의 탐색은 1 -> 2 -> 3 -> 4 -> 5 -> 6 이다.

    import java.util.LinkedList;
    import java.util.Queue;

    class Graph {
        private int V; // 정점의 수
        private LinkedList<Integer>[] adjList; // 인접 리스트

        // 그래프 초기화
        public Graph(int vertices) {
            this.V = vertices;
            this.adjList = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        // 간선 추가
        public void addEdge(int source, int destination) {
            adjList[source].add(destination);
        }

        // BFS 탐색
        public void BFS(int startVertex) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (int neighbor : adjList[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public class BFSGraphExample {
        public static void main(String[] args) {
            Graph graph = new Graph(6);

            // 그래프의 간선 추가
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(2, 4);
            graph.addEdge(2, 5);

            System.out.println("BFS 탐색 순서:");
            graph.BFS(0);
        }
    }

       
        
😀많은 경우에서 BFS가 DFS보다 탐색이 빠를 경우가 많다. 실생활에 DFS와 BFS가 쓰일만한 예시를 생각해보자:)
</details>
</details>

<!--구분선-->
---

<details>
<summary>3. 그래프 이론</summary>

<h3>
그래프 이론(Graph Theory)은 객체 간의 관계를 표현하는 추상적인 수학적 모델로서, 그래프라 불리는 구조를 사용하여 이 관계를 나타낸다.</h3>

<details>
<summary>다익스트라</summary>
        <div>
        정의 : 다익스트라(Dijkstra) 알고리즘은 단일 출발점 최단 경로 알고리즘으로, 그래프에서 특정 정점에서 다른 모든 정점까지의 최단 경로를 찾는 데 사용된다. 
        </div>
        <div></div>
        <div>
        시간복잡도 : O(V^2)
        </div>
        <div>
        하지만, 여기서는 PriorityQueue로 구현한 예시만 등장할 것이며, 이 경우 O(ELogV)의 시간 복잡도로 문제 해결이 가능하다.
        </div>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/1753">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291444980">풀이</a> 




    import java.util.*;
    import java.io.*;
    public class Main {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S  = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to,weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[]visited = new boolean[N+1];
        int[]dist = new int[N+1];
        int INF = 987654321;
        Arrays.fill(dist,INF);
        dist[S] = 0;
        pq.offer(new Node(S,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to]+next.weight){
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to,dist[next.to]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N+1;i++){
            if(dist[i]==INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        }
    }

       
        
😀최단거리는 정말 그래프의 꽃이다:)

</details>

<details>
<summary>플로이드 와샬</summary>
        <div>
        정의 : 플로이드 와샬(Floyd-Warshall)은 그래프의 모든 정점 쌍 간의 최단 경로를 찾기 위한 알고리즘. 음수 가중치가 있는 그래프에서도 사용되며 시간 복잡도가 큰 단점이 있다.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(V^3)
        </div>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/1389">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291482081">알고리즘 설명 및 풀이</a> 




    import java.util.*;
    import java.io.*;
    public class Main {

    static class Node implements Comparable<Node>{
        int to; int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

   

    import java.io.*;
    import java.util.*;

    public class bj_1389_케빈베이컨의6단계법칙_Silver_1 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
            int[][]fw = new int[N+1][N+1];
            int INF = 987654321;
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    fw[i][j] = INF;
                }
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                fw[a][b] = 1;
                fw[b][a] = 1;
            }
            for(int l=1;l<N+1;l++){
                for(int i=1;i<N+1;i++){
                    for(int j=1;j<N+1;j++){
                        if(i==j) continue;
                        fw[i][j] = Math.min(fw[i][j],fw[i][l]+fw[l][j]);
                    }
                }
            }
            int min = INF;
            int ans = 0;
            OuterLoop:
            for(int i=1;i<N+1;i++){
                int sum = 0;
                for(int j=1;j<N+1;j++){
                    if(i==j) continue;
                    sum += fw[i][j];
                    if(min<=sum) continue OuterLoop;
                }
                min = sum;
                ans = i;
            }
            System.out.println(ans);
        }
    }


       
        
😀플로이드 와샬은 정말 직관적이고 단순한 코드가 크나큰 장점이다:)

</details>
<details>
<summary>유니온 파인드</summary>
        <div>
        정의 : 유니온 파인드는 상호 배타적 집합, Disjoin-set(서로소 집합) 이라고도 부른다. 여러 노드가 존재할 때 어떤 두 개의 노드를 같은 집합으로 묶어 주고, 어떤 두 노드가 같은 집합에 있는지 확인하는 알고리즘
        </div>
        <div></div>
        <br/>
        <div>
        시간복잡도 : 유니온 파인드의 시간 복잡도는 구하기가 꽤 까다롭다. 최적화 여부, 순서 등에 따라 매번 달라지기 때문이다. 코드를 살펴보면 전체 시간 복잡도와 Union 함수의 시간 복잡도는 Find 함수의 시간 복잡도에 따라 결정되는 것을 알 수 있다.
경로 압축 최적화를 하지 않은 경우, 트리가 한 쪽으로 치우칠 수 있기 때문에 Find 함수의 시간 복잡도는 최악의 경우 O(N)이다. 경로 압축 최적화를 한 경우, 트리가 짧고 넓은 형태가 될 가능성이 높아지므로 O(logN) 정도로 생각할 수 있겠다.
실제 시간 복잡도는 O(α(N))라고 한다. α(x)는 애커만 함수라고 하는데, x가 2의 65536제곱일 때 함수 값이 5가 된다. 따라서, 그냥 상수라고 봐도 무방하다.
        </div>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/1717">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291534547">알고리즘 설명 및 풀이</a> 




   
    import java.util.*;
    import java.io.*;
    public class Main {
    static int N;
    static int[]parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        make(); // parents 배열을 넣어줌(자기 부모가 누군지 저장하는 배열)
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int act = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(act==0) union(a,b);
            else{
                if(find(a)!=find(b)) sb.append("NO");
                else sb.append("YES");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void make(){
        parents = new int[N+1];
        for(int i=1;i<N+1;i++)parents[i] = i;
    }
    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA<rootB) parents[rootB] =rootA;
        else parents[rootA] = rootB;
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num]=find(parents[num]);
    }

}

😀유니온 파인드는 크루스칼 알고리즘에도 쓰이기 때문에 반드시 제대로 이해하고 넘어가야 한다:)
</details>
<details>
<summary>최소스패닝트리(MST)</summary>
        <div>
        정의 : MST는 그래프의 모든 정점을 잇지만 사이클이 없는 부분 그래프를 의미한다. 다익스트라와 가장 큰 차이점은 다익스트라는 한 정점에 대한 다른 모든 '정점'의 최단거리라면, MST는 모든 정점을 연결하는 '간선'의 최단거리이다.
        </div>
        <div></div>
        <br/>
        <div>
        시간복잡도 : union-find 알고리즘은 시간복잡도가 상수이므로 간선들을 가중치 기준으로 정렬하는 데 걸리는 시간에 의존한다. 일반적인 경우 빠른 정렬 알고리즘의 시간복잡도는 
O(nlog n)이므로 이 경우 O(Elog E)가 된다. 우선순위 큐를 사용한 프림 알고리즘의 시간복잡도인 O(Elog V+Vlog V)과 비교했을 때 간선의 수가 적은 Sparse Graph의 경우 크루스칼 알고리즘이 유리하고 간선의 수가 많은 Dense Graph의 경우 프림 알고리즘이 유리하다.
        </div>
        <br/>
        <div>
        여기서는 크루스칼 알고리즘만 설명할 것이다.
        </div>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/1197">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291567824">알고리즘 설명 및 풀이</a> 




   
    

    import java.io.*;
    import java.util.*;

    public class Main {

        static class Node implements Comparable<Node>{
            int from; int to; int weight;

            public Node(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Node o) {
                return weight - o.weight;
            }
        }
        static int[]parents;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            for(int i=1;i<N+1;i++) parents[i] = i;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i=0;i<M;i++){
                st= new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.offer(new Node(a,b,w));
                pq.offer(new Node(b,a,w));
            }
            int ans = 0;
            int cnt = 0;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(find(now.from)!=find(now.to)){
                    ans += now.weight;
                    union(now.from,now.to);
                    cnt++;
                }
                if(cnt==N-1) break;
            }
            System.out.println(ans);
        }
        static int find(int num){
            if(parents[num]==num) return num;
            return parents[num] = find(parents[num]);
        }
        static void union(int a,int b){
            int rootA = find(a); int rootB = find(b);
            if(rootA<rootB) parents[rootB] = rootA;
            else parents[rootA] = rootB;
        }
    }


😀크루스칼 알고리즘과 다익스트라의 차이 이해하기:)
</details>

<details>
<summary>위상정렬(topological sorting)</summary>
        <div>
        정의 : 위상 정렬(topological sorting)은 유향 그래프의 꼭짓점들(vertex)을 변의 방향을 거스르지 않도록 나열하는 것을 의미한다. 예시를 들자면, <br>과자, 햄버거, 수박, 라면<br> 
        이렇게 네가지 음식이 있을 때, 과자는 햄버거보다 먼저 먹어야 하고, 라면은 수박보다 먼저 먹어야 한다고 가정해 보자.<br>
        1. 과자 → 햄버거 → 수박 → 라면 <br>
        2. 과자 → 햄버거 → 라면 → 수박 <br>
        3. 햄버거 → 과자 → 수박 → 라면 <br>
        4. 햄버거 → 과자 → 라면 → 수박 <br>
        5. 수박 → 라면 → 과자 → 햄버거 <br>
        6.라면 → 수박 → 과자 → 햄버거 <br><br>
        이렇게 여섯가지 경우의 수가 나올것이다. 이걸 가능하게 해주는 알고리즘이 위성정렬 알고리즘이다!
        </div>
        <div></div>
        <br/>
        <div>
        시간복잡도 : O(V+E)
        </div>
        <br/>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/2252">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291607241">알고리즘 설명 및 풀이</a> 


    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]dist = new int[N+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
            Queue<Integer> q= new ArrayDeque<>();
            StringBuilder sb=  new StringBuilder();
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                dist[b]++;
            }
            for(int i=1;i<N+1;i++) if(dist[i]==0) q.offer(i);
            while(!q.isEmpty()){
                int now = q.poll();
                sb.append(now+" ");
                for(int next : list.get(now)){
                    dist[next]--;
                    if(dist[next]==0){
                        q.offer(next);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }


😀위상정렬 알고리즘은 실생활에서도 많이 쓸 수 있을 것이다:)
</details>

<details>
<summary>벨만포드(Bellman-Ford)</summary>
        <div>
        정의 : 벨만-포드 알고리즘은 한 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘. 이때, 다익스트라와 달리 간선의 가중치가 음수인 경우에도 최단 거리를 구할 수 있다. 만약, 음수 사이클이 존재할 경우 음수 사이클을 판별할 수도 있다. 해당 예시 및 문제는 음수 사이클 판별 문제이다.
        </div>
        <div>
        시간복잡도 : O(VE) 
        </div>
        <br/>

<br>

! 그래프 이론은 기본적으로 복잡한 이해를 바탕으로 해야되기 때문에, 문제와 링크를 첨부하겠다.<br>
<a href="https://www.acmicpc.net/problem/1865">문제</a><br> 
<a href="https://blog.naver.com/hansaem900d/223291635211">알고리즘 설명 및 풀이</a> 


    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[]dist = new int[N+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++)list.add(new ArrayList<>());
            Queue<Integer> q= new ArrayDeque<>();
            StringBuilder sb=  new StringBuilder();
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                dist[b]++;
            }
            for(int i=1;i<N+1;i++) if(dist[i]==0) q.offer(i);
            while(!q.isEmpty()){
                int now = q.poll();
                sb.append(now+" ");
                for(int next : list.get(now)){
                    dist[next]--;
                    if(dist[next]==0){
                        q.offer(next);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }


😀벨만-포드를 이용하면 음수 가중치가 있는 최단거리도 구할 수 있다니! :)
</details>
</details>

<!--구분선-->
---
<details>
<summary>4. 문자열</summary>
<h3>
d
</h3>

</details>