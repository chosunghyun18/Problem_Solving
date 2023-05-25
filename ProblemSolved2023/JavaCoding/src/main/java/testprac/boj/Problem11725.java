package testprac.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(graph, visited, ans);

        for (int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int[] ans) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int a = node;

            for (int i : graph[node]) {
                if (!visited[i]) {
                    ans[i] = a;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}