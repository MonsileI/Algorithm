
import java.util.*;
import java.io.*;

public class SWEA_7988_내전경기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            List<List<Integer>> list = new ArrayList<>();

            int idx = -1;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, ++idx);
                    list.add(new ArrayList<>());
                }

                if (!map.containsKey(b)) {
                    map.put(b, ++idx);
                    list.add(new ArrayList<>());
                }

                list.get(map.get(a)).add(map.get(b));
                list.get(map.get(b)).add(map.get(a));
            }

            boolean flag = false;
            int[] color = new int[idx + 1];

            for (int i = 0; i <= idx; i++) {
                if (color[i] != 0) continue;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int next : list.get(node)) {
                        if (color[next] == 0) {
                            color[next] = 3 - color[node];
                            q.offer(next);
                        }
                        else if (color[next] == color[node]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            sb.append("#").append(t).append(" ")
                    .append(flag ? "No" : "Yes")
                    .append("\n");
        }

        System.out.print(sb);
    }
}
