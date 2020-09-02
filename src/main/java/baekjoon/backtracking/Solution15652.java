package baekjoon.backtracking;

import java.util.Scanner;

public class Solution15652 {
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        solution(1, 0, new boolean[N + 1], "");
    }

    private static void solution(int n, int depth, boolean[] visited, String str) {
        if (depth == M) {
            System.out.println(str);
            return;
        }

        for (int i = n; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(i, depth + 1, new boolean[N + 1], str.isEmpty() ? "" + i : str + " " + i);
            }
        }
    }
}
