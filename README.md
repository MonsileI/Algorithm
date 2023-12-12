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
<div markdown="1">
    <div>예제 구현 형식은 전부 DFS(깊이 우선 탐색)방식, 재귀 방식을 따를 것이다. 완전탐색의 일종이다.</div>
    <details>
    <summary>순열(Permutation)</summary>
    <div markdown="1">
        <div>
        정의 : 순열은 주어진 원소들로 만들 수 있는 모든 가능한 순서나 배열을 나열하는 것을 의미한다.
        </div>
        <div></div>
        <div>
        시간복잡도 : O(n!)
        </div>
        <div>
        ex [1,2,3] 이라는 배열이 있고, 2개의 길이를 가진 순열을 구한다면,
        [1, 2]
        [1, 3]
        [2, 1]
        [2, 3]
        [3, 1]
        [3, 2]
        로 총 6가지의 경우의 수가 나올 것이다.
        

    import java.util.Arrays;
    
    public class Main {
    
        static int [] tmp;
        static boolean[]visited;
        static int[]arr;
        static int N; //배열의 길이
        static int M; //구하고자 하는 원수의 개수
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


2. false 처리를 해주고 perm()함수를 depth+1한 상태로 재귀한다.

3. DFS 특성상, 가장 깊은 1,2가 tmp에 들어가는 순간, depth==M이 될 것이다. 그럼 tmp를 리턴한다.

4. 그럼 마지막 for문 입장에서는 visited[i]가 false인 3을 tmp[depth]에 넣어주고, perm을 한다. 그럼 depth가 2가 되고, 1,3이 tmp가 되는 것이다.

        
😀재귀코드는 머리로 따라가기가 쉽지 않다. 플랫하게 생각하며 그림을 직접 그려보며 코드를 따라가면 누구나 이해할 수 있다!
        
</div>
</detail>
    
    

</div>
</details>

        