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
   - Top Down
   - Bottom Up
   - LIS
   - Knapsack
6. 이진탐색 (Binary Search)
7. Greedy
   - 정렬 Greedy
8. 트리
   - LCA
9. 비트마스킹


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

2. temp[0] = arr[0]을 넣어주고, true 처리를 해준다. perm()함수를 depth+1한 상태로 재귀한다.

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

2. temp[0] = arr[0]을 넣어주고, comb()함수를 depth+1, start엔 i+1값 상태로 재귀한다.

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

2. depth가 N, 즉 전체 원소를 다 돌았고, 목표로 했던 target number와 수가 같다면, answer을 +1 해준다.

😀생각보다 많이 쓰이는 부분집합 코드이다.

</details>
</details>

## <!--구분선-->

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

## <!--구분선-->

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
        1. 과자 → 햄버거 → 라면 → 수박 <br>
        2. 과자 → 라면 → 수박 → 햄버거 <br>
        3. 라면 → 수박 → 과자 → 햄버거 <br>
        4. 과자 → 라면 → 햄버거 → 수박 <br>
        5. 라면 → 과자 → 햄버거 → 수박 <br>
        6. 라면 → 과자 → 수박 → 햄버거 <br><br>
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

## <!--구분선-->

<details>
<summary>4. 문자열</summary>
<h3>
문자열 알고리즘은 다양하다. 여기에선 LCS , KMP , Trie 알고리즘을 설명할 것이다.
</h3>

<details>
<summary>LCS(Longest Common Subsequence)</summary>
        <div>
        정의 : LCS 알고리즘은 DP(Dynamic Programming)를 기반으로 하며, 두 개의 문자열에서 공통으로 포함된 가장 긴 부분열을 찾는 알고리즘
        </div>
        <div>
        시간복잡도 : O(NM) , (두 문자열 길이 N,M이라고 가정할 때) 
        </div>
        <br/>
        <div>
        A B C D E F 와 A B C A D 라는 문자열 A B가 있다고 가정해보자.        
        </div>

           A B C D E F
         A 1 1 1 1 1 1
         B 1 2 2 2 2 2
         C 1 2 3 3 3 3
         A 1 2 3 3 3 3
         D 1 2 3 4 4 4

가로 세로로 문자열을 배치한 다음, 각각 가로 세로가 일치한다면, 그전까지 일치하던 값의 +1이 된다.<br/>
가로축의 A B C D E F 와 세로축의 A를 비교했을때, 전부 1이 될 것이다.<br>
가로축의 A B C D E F 와 세로축 A B를 비교하면, 처음엔 1이고 그다음에 A B 가 일치함으로 2전부 2로 채워진다.<br>
가로축의 A B C D E F 와 세로축 A B C 를 비교하면, 3으로 채워진다.<br>
가로축의 A B C D E F 와 세로축 A B C A 'D'까지 가면, D로 인해 A B C D 라는 가장 긴 4라는 '최장 공통 부분열'을 구할 수 있다.

<br/>

! 자세한 설명은 기본문제와 풀이 링크를 참고 해주세요.(제발)<br>
<a href="https://www.acmicpc.net/problem/9251">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/223292673112">알고리즘 설명 및 풀이</a>

    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public class Main {
        public static void main(String[] args) throws Exception{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            String first = br.readLine();
            String second = br.readLine();
            int fSize= first.length();
            int sSize = second.length();
            int[][]lcs = new int[fSize+1][sSize+1];
            for(int i=1;i<fSize+1;i++){
                char f = first.charAt(i-1);
                for(int j=1;j<sSize+1;j++){
                    char s = second.charAt(j-1);
                    if(f==s) lcs[i][j] = lcs[i-1][j-1]+1;
                    else lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
            System.out.println(lcs[fSize][sSize]);
        }
    }

😀문자열 알고리즘은 시간복잡도를 효율적으로 개선하기 위한 알고리즘들이 많다! :)

</details>

<details>
<summary>KMP(Longest Common Subsequence)</summary>
        <div>
        정의 :
        KMP(Knuth-Morris-Pratt) 알고리즘은 문자열 검색을 위한 효율적인 알고리즘으로,1977년에 Donald Knuth, Vaughan Pratt, James H. Morris에 의해 개발되었다. 문자열의 패턴을 찾는 알고리즘으로 접두사, 접미사를 활용한다.
        </div>
        <div>
        시간복잡도 : O(N+M) , (두 문자열 길이 N,M이라고 가정할 때) 
        </div>
        <br/>
        <div>
        A B A B A B C 와 A B A B A C 라는 문자열 A B가 있다고 가정해보자. A에 B패턴이 있는지, 몇개나 있는지 확인할 때 KMP를 이용한다.<br>
        여기서 A B A B A C 라는 패턴 관련 table 설계가  필요하다.         
        </div>

        A B A B A C 를 테이블로 설계하자면,

                          접두사이자 접미사인 최대 문자열
        A                             없음
        A B                           없음
        A B A                          A
        A B A B                        AB
        A B A B C                     없음

        즉, 테이블은 [0,0,1,2,0]이 된다.

이 테이블을 이용해서 설계하면 시간복잡도를 줄일 수 있다.

    문자열 : A B A B A B C
    패턴 : A B A B C [0,0,1,2,0]

    1. 문자열을 기준 loop를 돌며, 문자열 index와 패턴 index를 비교하고, 같으면 패턴 index를 ++해준다.

    2. A B A B 까지는 맞지만, 문자열 index 4인 'A'가 패턴 index 4인 'C'가 아니기 때문에 일치하지 않는다. (여기까지 패턴 index는 조건 1에 의해 4가 된다.)

    3. 두 index 값이 다르기 때문에 패턴의 index값을 table[index-1]값으로 갱신, 즉 index가 4였기 때문에 테이블의 3 값인 2 값으로 갱신된다.

    4. 이때, 테이블에 들어있는 값이 일치하거나 패턴 index가 0보다 클때까지 (3번)을 반복하여 가능한 패턴을 찾아준다. 패턴의 2값은 'A'이다. 패턴'A'와 문자열의 4번째 값 'A'가 같기 때문에 한번의 반복문으로 찾을 수 있다.

    5. 패턴 2값은 'A'였고, 문자열 4번째 'A'는 일치하기 때문에 패턴 index를 +1 해준다. (index는 현재 3)

    6. 다음 문자열 index값인 5는 'B'이다. 현재 패턴 index인 3은 'B'이다. 일치하기 떄문에 패턴 index +1 해준다.

    7. 다음 문자열 index값인 6은 'C'이다. 패턴 index 값인 4는 'C'이다. 일치한다. 그리고 현재 패텬 index는 4, 즉 패턴 끝까지 도달했기 때문에 문자열은 패턴을 포함한다고 볼 수 있다.

최대한 상세하게 작성하려고 했지만, 링크에 좀 더 자세히 그림과 함께 설명해놓았다.

<br/>

! 자세한 설명은 기본문제와 풀이 링크를 참고 해주세요.(제발)<br>
<a href="https://www.acmicpc.net/problem/1786">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/223292789507">알고리즘 설명 및 풀이</a>

    import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            String pattern = br.readLine();
            int sLen = str.length();
            int pLen = pattern.length();
            int[]table = new int[pLen];
            int j = 0; //j = 접두사, i = 접미사
            for(int i=1;i<pLen;i++){
                while(0<j && pattern.charAt(j)!=pattern.charAt(i)) j = table[j-1];
                if(pattern.charAt(j)==pattern.charAt(i)) table[i] = ++j;
            }
            int cnt = 0;
            j = 0;
            StringBuilder sb = new StringBuilder();
            //A B A B A B A B A C || A B A B A C [0,0,1,2,3,0]
            for(int i=0;i<sLen;i++){
                while(0 < j && pattern.charAt(j)!=str.charAt(i)) j = table[j-1];
                if(pattern.charAt(j)==str.charAt(i)){
                    if(j==pLen-1){
                        cnt++;
                        sb.append((i-j+1)+" ");
                        j = table[j];
                    }else j++;
                }
            }
            sb.insert(0,cnt+"\n");
            System.out.println(sb.toString());
        }
    }

😀KMP 알고리즘은 천천히 코드를 보며 흐름을 따라가고, 그림을 그려볼 필요가 있다 :)

</details>

<details>
<summary>Trie</summary>
        <div>
        정의 :
       Trie(트라이)는 검색 트리의 일종으로, 동적인 집합이나 연관 배열을 표현하는 데 사용되는 트리 자료 구조이다. 주로 문자열 검색에 많이 활용되며, 각 노드는 문자나 키의 일부를 나타낸다. Trie는 각 노드에서의 문자열의 공통 접두어를 효과적으로 저장하므로, 검색 및 삽입 연산이 빠르다.
        </div>
        <div>
        시간복잡도 :&ensp;삽입(Insertion): O(M)<br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;검색(Search): O(M)<br>
         &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;삭제(Deletion): O(M)입니다.
        </div>
        <br/>
        <div>
        알파벳이라고 가정한다면, List를 활용하는 방법도 있지만, 여기선 Map을 활용할 것이다.<br>
        정말 간단하게 말해서, 각 알파벳 별 'abc...'의 맵을 만들고, 만약 문자열이 ab abc ad ade af 이렇게 있다면,<br>
        </div>
        
                a
              / | \
             b  d  f
            /   |  
           c    e

이런식으로 각각 알파벳에 map이 구성되고, 그 map에 하위 map이 구성되는 구조로 설계하는 것이다.<br>
최대한 상세하게 작성하려고 했지만, 링크에 좀 더 자세히 그림과 함께 설명해놓았다.

<br/>

! 자세한 설명은 기본문제와 풀이 링크를 참고 해주세요.(제발)<br>
<a href="https://www.acmicpc.net/problem/5052">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/223216769925">알고리즘 설명 및 풀이</a>

    import java.io.*;
    import java.util.*;

    public class Main {

    static class TrieNode{

        public TrieNode() {}

        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insertNode(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childNode.get(ch);
            }
        }
        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode thisNode = trieNode.childNode.get(ch);
                if(thisNode.childNode.isEmpty()) return false;
                trieNode = thisNode;
            }

            return true;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
        TrieNode trieNode = new TrieNode();
        List<String >list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                String str = br.readLine();
                list.add(str);
                trieNode.insertNode(str);
            }
            boolean flag = true;
            for(String str : list){
                if(trieNode.isContains(str)) {
                    flag= false;
                    break;
                }
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
      }
    }

😀 Trie 알고리즘은 검색에 대한 인사이트를 얻을 수 있는 아주 좋은 알고리즘이다 :)

</details>
</details>

## <!--구분선-->

<details>
<summary>5. DP(Dynamic Programming)</summary>
<h3>
동적 계획법(Dynamic Programming, DP)은 어떤 문제를 해결하는 알고리즘 설계 기법 중 하나이다. 이 기법은 큰 문제를 작은 부분 문제로 나누어 해결하고, 중복되는 부분 문제들의 해를 저장하며 효율적으로 문제를 해결하는 방법론을 가지고 있다.
</h3>

<details>
<summary>Top Down</summary>
        <div>
        정의 : Top-Down 접근은 큰 문제를 해결하기 위해 재귀적으로 작은 부분 문제를 호출하면서 문제를 해결하는 방법이다. 이때 중복되는 부분 문제를 피하기 위해 Memoization이 사용된다.
        </div>
        <br>
        주요 특징 : 1. 큰 문제를 해결하기 위해 작은 부분 문제 호출: 큰 문제를 해결하기 위해 필요한 부분 문제를 재귀적으로 호출한다.<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;2. Memoization 사용: 중복되는 부분 문제의 결과를 저장하여 필요할 때 다시 사용합니다.<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;3.재귀적 접근: 문제를 작은 단위로 나누어 해결하기 위해 재귀적인 호출을 사용합니다.<br>
<br>
예시 문제로 fibonacci 수열을 Top down으로 구현해 보겠다.
<br/>

    public class TopDownDP {

        public static int fibonacci(int n, int[] dp) {

            if (n <= 1) return n;     //n이 마지막 구간인 1에 도달하면 1 return;

            //메모이제이션 되지 않았다면, n-1번째 피보나치 + n-2번째 피보나치를 n에 넣어줌
            if (dp[n] == 0) {
                dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
            }
            //저장된 피보나치 return;
            return dp[n];
        }

        public static void main(String[] args) {
            int n = 6;   //n번째 피보나치 수열 return ( 0,1,1,2,3,5,8 ) -> index기준 6번째, 8
            int[] dp = new int[n + 1];        //dp 선언

            int result = fibonacci(n, dp);
            System.out.println(result);       // Output: 8
        }
    }

위 코드를 진행한다면,<br>

1. 6이 fibonacci 재귀 함수에 들어간다.
2. 아직 dp[6] 은 0이기 때문에, 5 , 4를 fibonacci 재귀 함수에 넣어준다.
3. 5와 4도 동일한 방법에 의해 5는 4, 3 4는 3,2를 재귀 함수에 넣어준다.
4. 3과 2도 각각 2,1 1,0을 넣어준다.
5. 1과0은 각각 1과 0을 return해준다.
6. 재귀적으로 2와 3은 각각 1과 2를 얻는다. 여기서 1은 이미 메모이제이션 되었기 때문에 한번만 수행한다.

이런식으로 점차 재귀 되면서 구현될 수 있다. 가장 큰 장점은 메모이제이션으로 인해 이미 수행한 연산은 수행하지 않는다는 것이다.<br>

                                        fib(5)
                         ________________|________________
                        |                                 |
                    fib(4)                              fib(3)
                  __|____                             ____|____
                 |       |                           |         |
               fib(3)  fib(2)                     fib(2)     fib(1)
              __|___    / \                         / \
             |     |  fib(1) fib(0)            fib(1) fib(0)
           fib(2) fib(1)
          / \
     fib(1) fib(0)

메모이제이션을 활용하지 않는다면 이 모든 연산을 다 수행해야 한다. 하지만,

                  fib(5)
                    |
                   / \
             fib(4)   fib(3)
                / \
            fib(3) fib(2)
            / \
        fib(2)  fib(1)
        /  \
    fib(1) fib(0)

DP를 활용하면 이렇게 짧은 연산으로 풀이할 수 있다.

😀DP는 정말 많은 경우에 효율적으로 쓰인다. 이 레포지토리에는 다양한 DP 문제를 올릴 예정이다. :)

</details>
<details>
<summary>Bottom Up</summary>
        <div>
        정의 : Bottom-Up 방식은 작은 부분 문제부터 시작하여 큰 전체 문제를 해결하는 방식으로 동작합니다. 이는 재귀적인 호출을 사용하지 않고 반복문을 통해 문제를 해결하는 특징을 갖고 있다.
        </div>
        <br>
        주요 특징 : 1. 작은 부분 문제부터 해결: 먼저 가장 작은 크기의 부분 문제부터 시작하여 해결한다. 이 작은 문제들은 주어진 문제의 하위 문제들로 분해된다.<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;2. Memoization 사용: 중복되는 부분 문제의 결과를 저장하여 필요할 때 다시 사용합니다.<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;3.상향식(bottom-up) 구성: 작은 부분 문제들을 해결한 결과를 이용하여 큰 부분 문제들을 해결하는 방향으로 구성한다. 이를 통해 전체 문제의 최적해를 구할 수 있다.<br>
<br>
예시 문제로 fibonacci 수열을 Top down으로 구현해 보겠다.
<br/>

    public class BottomUpDP {

    public static int fibonacci(int n) {
        if (n <= 1) return n;

        // Bottom-Up DP를 위한 배열 선언
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 0;
        dp[1] = 1;

        // 작은 부분 문제부터 시작하여 큰 문제까지 해결
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 최종 결과 반환
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;   // n번째 피보나치 수열 return (0, 1, 1, 2, 3, 5, 8) -> index 기준 6번째, 8

        int result = fibonacci(n);
        System.out.println(result);  // Output: 8
    }

}

위 코드를 진행한다면,<br>

1. dp[2] 는 dp[i-1] (1) 과 dp[i-2] (2) 를 더한 값이 된다.
2. for문을 진행하며 n까지 도달한다.

이런식으로 for으로 구현한다. 가장 큰 장점은 메모이제이션으로 인해 이미 수행한 연산은 수행하지 않는다는 것이다.<br>

                                        fib(5)
                         ________________|________________
                        |                                 |
                    fib(4)                              fib(3)
                  __|____                             ____|____
                 |       |                           |         |
               fib(3)  fib(2)                     fib(2)     fib(1)
              __|___    / \                         / \
             |     |  fib(1) fib(0)            fib(1) fib(0)
           fib(2) fib(1)
          / \
     fib(1) fib(0)

메모이제이션을 활용하지 않는다면 이 모든 연산을 다 수행해야 한다. 하지만,

                  fib(5)
                    |
                   / \
             fib(4)   fib(3)
                / \
            fib(3) fib(2)
            / \
        fib(2)  fib(1)
        /  \
    fib(1) fib(0)

DP를 활용하면 이렇게 짧은 연산으로 풀이할 수 있다.

Bottom Up 방식이 Top Down 방식에 비해 갖는 이점

1. 재귀 호출의 오버헤드 회피: Top-Down 방식은 재귀 호출을 사용하며 이는 함수 호출 스택을 사용하게 된다. 반면에 Bottom-Up은 반복문을 통해 진행되므로, 함수 호출의 오버헤드를 피할 수 있다.

2. 메모리 사용 효율성: Top-Down 방식에서는 재귀 호출에 따라 메모리에 함수 호출 스택이 쌓이게 되는데, 이는 메모리 사용량이 높아질 수 있다. Bottom-Up 방식은 반복문을 사용하며 필요한 부분만 계산하므로 메모리 사용이 효율적이다.

3. 캐시 지역성 강화: Bottom-Up 방식은 작은 문제부터 차례로 해결하기 때문에 CPU의 캐시 지역성을 더 강화할 수 있습니다. 이로 인해 캐시 히트율이 높아져 성능 향상에 도움이 될 수 있다.

4. 재귀 제한 우회: Top-Down 방식은 재귀 호출을 사용하며, 언어나 환경에 따라 재귀 호출 스택의 깊이에 제한이 있을 수 있다. Bottom-Up 방식은 이런 제한을 우회할 수 있다.

5. 코드의 명확성: Bottom-Up 방식은 반복문을 사용하므로 코드가 명확하고 직관적이다. Top-Down 방식에서는 재귀적인 구조가 코드를 복잡하게 만들 수 있다.

그러나 상황에 따라서는 Top-Down 방식이 특정 문제에 더 적합할 수 있다. 선택은 문제의 특성과 구현 세부사항에 따라 다를 수 있습니다.

😀나는 Bottom Up 방식을 선호한다. 재귀 코드는 직관적이지 않은 경우가 많기 때문이다. :)

</details>

<details>
<summary>LIS(Longest Increasing Subsequence)</summary>
        <div>
        정의 :주어진 수열에서 가장 긴 증가하는 부분 수열의 길이를 찾는 동적 계획법 기반의 알고리즘이다. 이 알고리즘은 수열의 순서를 유지하며, 원래 수열의 순서와 다른 위치에 있는 원소들로 이루어진 부분 수열 중에서 증가하는 순서로 구성된 가장 긴 부분 수열을 찾는다.
        </div>
        <br>
만약, [1 , 2 , 5 , 2 , 3 , 6] 에서 LIS를 구해본다면,<br> 
1. 우선 값을 구하는 DP 배열은 전부 1로 초기화한다.(자기 자신까지의 LIS는 1이기 때문에)<br>
2. 바깥 loop를 돌고(i) , 안쪽 loop(j) 는 자기 자신 전 반복을 진행한다.for(j=0 ; j < i ; j ++ )<br>
3. 만약, arr[j]값이 arr[i]값보다 작다면, 자기 자신보다 크기가 작기 때문에 LIS에 포함시켜야 할 것이다.<br>
4. dp[j]+1이 큰지, 아니면 dp[i](지금까지 내가 갱신한 최장 수열 크기)가 큰지 비교 후 dp[i] 에 max값을 넣어준다<br>
<br>
코드로 간단하게 표현해보겠다.
<br/>

    public class Main {
        public static void main(String[] args) throws Exception {
            int[]arr = {1,2,5,2,3,6}
            int N = arr.length
            int[]dp = new int[N]; //답을 저장할 dp 배열
            int max = 0;          //도출될 max(가장 긴 수열 길이) 값
            for(int i=0;i<N;i++){
                dp[i] = 1;        //나 자신을 1로 초기화
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]){      //만약 j원소가 나 자신보다 작다면,
                        dp[i] = Math.max(dp[i],dp[j]+1); //비교 후 max값을 넣어준다.
                    }
                }
                max = Math.max(max,dp[i]);    //max값 갱신
            }

            System.out.println(max);

        }
    }

! 자세한 설명은 기본문제와 풀이 링크를 참고 해주세요.<br>
<a href="https://www.acmicpc.net/problem/11053">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/223293484121">알고리즘 설명 및 풀이</a>

😀LIS는 기본적인 DP문제 중 하나이다. 아주 재밌으니 직접 풀이하는걸 강력 추천한다. :)

</details>
<details>
<summary>Knapsack</summary>
        <div>
        정의 :Knapsack 알고리즘은 한정된 가방 용량 안에서 물건의 가치를 최대화하는 최적화 문제를 해결하는 알고리즘이다. 이 문제는 '가치'와 '무게'가 각각 주어진 여러 물건을 가방에 넣을 때, 가방의 용량을 초과하지 않으면서 최대 가치를 얻을 수 있는 물건들의 조합을 찾는 것을 목표로 한다.
        </div>
        <br>
만약, 8kg을 담을 수 있는 가방이 있고, 각각 3kg 2kg 6kg 5kg 의 물건이 있다.<br>
그리고 이 물건의 가치는 각각 3 2 6 7 이라고 해보자.<br>
무게 w = [3,2,6,5]이고, 가치 v = [3,2,6,7]이다.<br>
여기서 8kg으로 가장 큰 value를 얻을 수 있는 조합은 3kg과 5kg을 담은 가치 10이 될것이다.<br>
<br>
1. 우선 dp배열을 선언하는데, 각각 물건의 개수와 총 담을 수 있는 무게를 선언한다.<br>
2. 이중 for문에서 바깥 for은 물건의 정보를 담고 있다.<br>
3. 안쪽 for은 8kg까지 j를 0부터 늘려간다. <br>
4. 여기가 핵심이다. 만약 j가 지금 물건의 무게보다 커진다면,<br>
5. 이 물건 무게를 뺐을 때의 가치+지금 물건 가치 vs 그전에 가치를 비교하는 것이다.<br>
    
    즉, 3kg의 물건을 더했을때의 가치가 더 커지는지 아니면 없을때의 가치가 더 컸는지 비교하는 것이다.
    지금 가방에 넣을 무게가 3kg이고, 1kg+3kg, 2kg+3kg ... 5kg+3kg (8kg 까지 넣을 수 있기 때문에)
    가치를 비교했을때, 이 3kg짜리 물건을 넣는게 더 이득이면, 갱신해주는 간단한 알고리즘이다 :) 
    
    점화식은 dp[i][j] = Math.max(dp[i][j],dp[i-1][j-w]+w[j]); 가 된다.
    여기서 dp[i-1][j-w]는 이 물건을 넣기전에 가방 상태에서의 3kg 전의 무게 + 3kg 물건의 가치가 된다.

그림으로 쉽게 설명한 풀이가 링크에 있다. 참고하면 큰 도움이 될것이다 :)
<br/>

    import java.util.*;
    import java.io.*;

    public class Main {

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int answer = 0;

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //dp 배열
            int [][] dp;

            int [] W = new int[N+1];
            int [] V = new int[N+1];

            //input
            for(int i=1;i<N+1;i++) {
                st = new StringTokenizer(br.readLine()," ");
                W[i] = Integer.parseInt(st.nextToken());
                V[i] = Integer.parseInt(st.nextToken());

            }
            //dp 선언
            dp = new int[N+1][K+1];
            for(int i=1;i<N+1;i++) { //물건 개수만큼 for
                for(int j=1;j<K+1;j++) { //기준이 되는 무게만큼만 for
                    dp[i][j] = dp[i-1][j]; //그전꺼 저장
                    if(W[i]<=j) { //K까지 가는 j보다 자기 무게가 작다면
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
                        //이전에 구한 가치 vs 남은 무게의 가치+지금 물건의 가치  중 큰 값
                    }
                }
            }
            answer = dp[N][K];
            System.out.println(answer);

        }
    }

! 자세한 설명은 기본문제와 풀이 링크를 참고 해주세요.<br>
<a href="https://www.acmicpc.net/problem/12865">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/222960926583">알고리즘 설명 및 풀이</a>

😀Knapsack은 워낙 유명한 DP 문제이다. 반드시 숙지하도록 하자 :)

</details>
</details>

## <!--구분선-->

<details>
<summary>6. 이진탐색(Binary Search)</summary>
<h3>
이진탐색(Binary Search)은 정렬된 배열 또는 리스트에서 특정 항목을 찾는 알고리즘이다. 이 알고리즘은 배열을 반으로 나누어 찾고자 하는 항목이 있는 부분을 결정하고, 반으로 나눈 부분에서 다시 검색을 반복하는 방식으로 동작한다.
</h3>
시간복잡도 : O(LogN);
<br>
이진탐색의 가장 큰 장점은 빠른 속도로 탐색할 수 있다는 것이다.<br>
만약 [1,2,3,4,10,15,20,25] 이라는 배열이 있고, 여기서 '3'이라는 숫자의 개수를 찾는다고 해보자<br>

    int[]arr = {1,2,3,4,10,15,20,25};
    int target = 3;

    for(int i=0;i<N;i++){
        if(arr[i]==target) System.out.println("찾았다"); 
    }

선형 탐색의 경우 배열의 크기인 O(N)만에 탐색을 할 수 있다.<br> 예시의 arr의 크기가 작아서 그렇지만, 만약 배열의 크기가 1억 10억 100억이 된다면? 또 컴퓨터는 괴로울 것이다.<br>
이진탐색은 그 정의와 같게 반으로 나누어서 탐색한다.
찾고자 하는 값: 3
1. 중간 위치를 찾음: 배열의 중간은 4번째 위치에 있는 4
2. 4 > 3이므로, 왼쪽 부분만 남김: [1, 2, 3]
3. 다시 중간 위치를 찾음: 배열의 중간은 2번째 위치에 있는 2
4. 2 < 3이므로, 오른쪽 부분만 남김: [3]
5. 중간 위치를 찾음: 배열의 중간은 3
6. 3 == 3 (찾고자 하는 값 발견)

이렇게 반을 갈라가며 해답을 찾을 수 있다.
<br>
이진 탐색은 두가지 방법이 쓰인다. 같은 알고리즘이지만, 상황에 맞게 써야 하기 때문에 모두 설명할 예정이다.
<br><br>
우선, Lower Bound방식이다.<br>
Lower Bound 이진 탐색은 배열에서 찾고자 하는 값 이상이 처음으로 나타나는 위치를 찾는 방식이다.<br> 
이 방식은 배열 내에 찾고자 하는 값과 일치하는 값이 여러 개 있을 때, 그 중 가장 작은 인덱스를 찾는다.

<br/>

    public class BinarySearchLowerBound {
        public static int lowerBound(int[] arr, int target) {
            int L = 0;
            int R = arr.length;

            while (L < R) {
                int mid =  (L + R) / 2;
                if (arr[mid] < target) L = mid + 1;
                else R = mid;
            }
            return L;
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 10, 15, 20, 25};
            int target = 3;
            int lowerIndex = lowerBound(array, target);
            System.out.println("Lower Bound Index: " + lowerIndex);
        }
    }
    

위 코드를 진행한다면,<br>

1. 처음 L은 0, R은 배열 크기인 8이기 때문에, mid = 4가 된다.
2. 배열의 4번째 값은 10이고, 타겟은 3이기 때문에 R값이 mid가 된다(R=4)
3. L은 0, R은 4이기 때문에 mid =2 이다.
4. 배열의 2값은 3이고, target은 3이기 때문에 R값이 mid가 된다(R=2)
5. L은 0, R은 2이기 때문에 mid =1 이다.
6. 배열의 1값은 2이고 target은 3이기 때문에 L값이 mid+1이 된다(L=2)
7. while문에 의해 break;되고, L인 2를 return 한다.

이런 과정들로 인해 3의 바로 전인 index 2값을 얻을 수 있다.
<br>
다음은, Upper Bound방식이다.<br>
Upper Bound 이진 탐색은 배열에서 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치를 찾는 방식이다. 
<br> 
이 방식은 배열 내에 찾고자 하는 값과 일치하는 값이 여러 개 있을 때, 그 중 가장 큰 인덱스를 찾는다.

<br/>

    public class BinarySearchUpperBound {
        public static int upperBound(int[] arr, int target) {
            int L = 0;
            int R = arr.length;

            while (L < R) {
                int mid = L + (L + R) / 2;
                if (arr[mid] <= target) L = mid + 1;
                else R = mid;
            }
            return L;
        }

        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 10, 15, 20, 25};
            int target = 3;

            int upperIndex = upperBound(array, target);

            System.out.println("Upper Bound Index: " + upperIndex);
        }
    }

위 코드를 진행한다면,<br>

1. 처음 L은 0, R은 배열 크기인 8이기 때문에, mid = 4가 된다.
2. 배열의 4번째 값은 10이고, 타겟은 3이기 때문에 R값이 mid가 된다(R=4)
3. L은 0, R은 4이기 때문에 mid =2 이다.
4. 배열의 2값은 3이고, target은 3이기 때문에 L값이 mid+1가 된다(L=3)
5. L은 3, R은 4이기 때문에 mid =3 이다.
6. 배열의 3값은 4이고 target은 3이기 때문에 R값이 mid가 된다(R=3)
7. while문에 의해 break;되고, L인 3을 return 한다. 

Lower Bound와 Upper Bound를 활용하여 {1,2,3,4,10,15,20,25} 배열에서 3의 값은<br>
Lower Bound의 2값, Upper Bound의 3값을 알 수 있다.<br>
이 두 결과는 2의 경우 해당 해답을 포함하는 가장 작은 인덱스이고,<br>
Upper Bound는 해당 해답을 포함하지 않는 바로 위의 값이다.<br>
<br>
이를 활용한 많은 문제들이 있지만, 가장 좋다고 생각하는 문제의 링크를 달려고 한다.<br>
<a href="https://www.acmicpc.net/problem/2110">문제</a><br>
<a href="https://blog.naver.com/hansaem900d/223202965087">알고리즘 설명 및 풀이</a>


😀정말 극한의 효율로 해답을 찾을 수 있는 알고리즘이다. 많은 기업에서 최근 많이 출제되는 유형이니 꼭 익숙해지도록 하자 :)
</details>

## <!--구분선-->

<details>
<summary>6. 그리디(Greedy)</summary>
<h3>
그리디 알고리즘(Greedy Algorithm)은 최적해를 구하기 위해 매 순간마다 가장 좋아 보이는 선택을 하는 알고리즘이다. 이 알고리즘은 각 단계에서 지금까지의 선택을 통해 최종적인 해답을 찾아내려고 하는 특징을 가지고 있다. 그리디 알고리즘은 각 선택이 지역적으로는 최적이지만, 그 선택들이 모여 전역적으로 최적이라는 보장은 없다.
</h3>
<details>
<summary>기본 그리디</summary>
        <div>
        기본적인 그리디 문제를 예시로 설명을 하려고 한다.
       </div>
       <br>       
Q : 만약, Nkg의 설탕을 5kg짜리 포대와 3kg짜리 포대로 운반해야 한다.<br>
여기서 조건은 최대한 적은 수의 포대를 사용하는 것이다.<br>
만약 8kg의 설탕을 운반하려면 3kg짜리 포대, 5kg자리 포대를 한개씩 써서 총 2개의 포대가 나올 것이다.<br>
여기서 최대한 '탐욕'적으로 답을 도출해내려면 어떻게 해야할까?<br><br>
바로 Nkg 설탕을 최대한 많은 5kg짜리 포대로 옮기면 가능하다!<br>
그럼, 만약 9kg 설탕을 옮기려 한다면? 5kg를 쓸 수 없지만 3kg짜리 3개 포대로 운반이 가능하다.<br><br>
이 문제를 그리디한 아이디어로 풀어내려면, 이 설탕 Nkg를 5kg의 배수가 될때까지 3kg의 포대로 옮기면 된다!
<br/>

    import java.util.*;
    import java.io.*;
    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            while(0<N){
                if(N%5==0) {
                    ans += N/5;
                    break;
                }
                N -= 3;
                ans++;
            }
            System.out.println(N<0 ? -1 : ans);
        }
    }

코드 자체가 굉장히 단순하다. N이 5kg의 배수가 되는 순간, 바로 5kg로 다 옮기고 return,<br> 
그게 아니라면 N에서 3kg를 뺴준다.<br>
만약 포대를 옮길 수 없다면 -1을 return해주면 된다.<br>

😀그리디 알고리즘의 특징은 특정 알고리즘이 없다는 것이다. 아이디어를 많이 요구하는 만큼 재밌는 문제가 많다. :)


</details>
<details>
<summary>정렬 그리디</summary>
       <div>
        기본적인 정렬 그리디 문제를 예시로 설명을 하려고 한다.
       </div>
       <br>
Q : ATM을 사용하기 위해 사람들이 줄을 서있다.<br>
각 사람들은 ATM을 사용하기 위한 시간이 각각 다르다<br>
각각 사람들이 사용할 시간이 [3,2,1,5,6] 형태로 주어진다.<br>
사람들 위치를 재배치시켜 모든 사람이 ATM을 사용하는 최단시간을 알아내려고 한다.<br>
[3,2,1,5,6]일 경우, <br>
첫번째 사람은 3분, 두번쨰 사람은 대기시간3+사용시간 2분<br>
세번째 사람은 대기시간 5+사용시간1...<br>
총 3 + 5 + 6 + 11 + 17 = 42시간이 걸리것이다. 최단시간을 구해보자.<br><br>

이 문제의 경우 시간이 중첩되기 때문에 시간이 짧은 사람이 먼저 사용하게 하면 가장 짧은 시간을 구할 수 있다.<br>
[1,2,3,5,6] 이렇게 정렬할 경우, 대기시간까지 계산하면<br>
1 + 3 + 6 + 11 + 17 = 28로 가장 최적해를 구할 수 있다!


    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            int answer = 0;
            int tmp = 0;
            for(int i=0;i<N;i++){
            tmp += arr[i];
            answer += tmp;
            } 
            System.out.println(answer);
        }
    }


😀예시 문제들은 정말 기본적인 그리디 문제이다. 다양한 그리디 문제가 많고, 개발자로서의 두뇌를 말랑말랑하게 할 수 있는 알고리즘이니, 연습하면 너무 좋다 :)


</details>
</details>