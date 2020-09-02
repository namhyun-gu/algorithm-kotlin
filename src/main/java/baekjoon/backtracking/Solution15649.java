package baekjoon.backtracking;

import java.util.Scanner;

public class Solution15649 {
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            solution(i, 1, new boolean[N + 1], i + "");
        }
    }

    private static void solution(int n, int depth, boolean[] visited, String str) {
        if (depth == M) {
            System.out.println(str);
            return;
        }

        visited[n] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                solution(i, depth + 1, visited.clone(), str + " " + i);
            }
        }
    }
}
