package 전체문제2026.February.Fourth;

import java.io.*;
import java.util.*;

public class BJ_6443_애너그램_Gold_5 {
    static int N;
    static char[] arr;
    static boolean[] visited;
    static char[] result;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            words.add(br.readLine());
        }
        words.sort(Comparator.comparingInt(String::length));

        for (String str : words) {
            N = str.length();
            arr = str.toCharArray();
            Arrays.sort(arr);
            visited = new boolean[N];
            result = new char[N];
            dfs(0);
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth == N) {
            bw.write(result);
            bw.newLine();
            return;
        }

        char prev = 0; // 이전에 사용한 문자 (중복 방지)
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (arr[i] == prev) continue; // 같은 레벨에서 중복 문자 스킵

            prev = arr[i];
            visited[i] = true;
            result[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
