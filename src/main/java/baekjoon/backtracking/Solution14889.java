package baekjoon.backtracking;

import java.util.Scanner;

public class Solution14889 {
    private static int[][] stats;
    private static boolean[] visited;

    private static int N;
    private static int minDiff;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        visited = new boolean[N];
        stats = new int[N][N];
        minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stats[i][j] = scanner.nextInt();
            }
        }
        solution(0, 0);
        System.out.print(minDiff);
    }

    private static void solution(int start, int picks) {
        if (picks == N / 2) {
            int sumS = sumStats(true);
            int sumL = sumStats(false);
            int diff = Math.abs(sumS - sumL);
            minDiff = Math.min(minDiff, diff);
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(i + 1, picks + 1);
                visited[i] = false;
            }
        }
    }

    private static int sumStats(boolean isTeamS) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && visited[i] == isTeamS && visited[j] == isTeamS) {
                    sum += stats[i][j];
                }
            }
        }
        return sum;
    }
}
