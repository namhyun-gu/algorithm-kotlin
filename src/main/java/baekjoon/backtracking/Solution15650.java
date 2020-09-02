package baekjoon.backtracking;

import java.util.Scanner;

public class Solution15650 {
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        solution(0, new boolean[N + 1], "");
    }

    private static void solution(int depth, boolean[] visited, String str) {
        if (depth == M) {
            System.out.println(str);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(depth + 1, visited.clone(), str.isEmpty() ? "" + i : str + " " + i);
            }
        }
    }
}
