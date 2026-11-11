
package 전체문제2026.November.Seventh;

import java.util.*;
import java.io.*;

public class SWEA_1849_영준이의무게측정_D6 {
    static int[] parent;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            dist = new long[N + 1];

            for (int i = 1; i <= N; i++) parent[i] = i;

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                char act = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (act == '?') {
                    int pA = find(a);
                    int pB = find(b);

                    if (pA != pB) {
                        sb.append("UNKNOWN ");
                    } else {
                        sb.append(dist[b] - dist[a]).append(" ");
                    }
                } else {
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int find(int node) {
        int root = node;
        long total = 0;

        // 1. 루트 탐색 및 전체 거리 계산
        while (parent[root] != root) {
            total += dist[root];
            root = parent[root];
        }

        // 2. 경로 압축 및 거리 갱신
        while (parent[node] != node) {
            int p = parent[node];
            long d = dist[node];

            parent[node] = root;
            dist[node] = total;

            total -= d;
            node = p;
        }

        return root;
    }

    static void union(int a, int b, int w) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        long diff = dist[a] - dist[b] + w;

        if (rootA < rootB) {
            parent[rootB] = rootA;
            dist[rootB] = diff;
        } else {
            parent[rootA] = rootB;
            dist[rootA] = -diff;
        }
    }
}
