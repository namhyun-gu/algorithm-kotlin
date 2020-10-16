package baekjoon.backtracking;

import java.util.Scanner;

public class Solution9663 {
    private static int N;
    private static int[] columns;
    private static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        columns = new int[N];
        cnt = 0;

        nQueen(0);

        System.out.println(cnt);
    }

    private static void nQueen(int row) {
        if (row == N) {
            cnt++;
        } else {
            for (int column = 0; column < N; column++) {
                if (isPossible(row, column)) {
                    columns[row] = column;
                    nQueen(row + 1);
                }
            }
        }
    }

    private static boolean isPossible(int row, int column) {
        for (int x = 0; x < row; x++) {
            int y = columns[x];
            if (column == y) {
                return false;
            }

            int rowDist = Math.abs(x - row);
            int colDist = Math.abs(y - column);
            if (rowDist == colDist) {
                return false;
            }
        }
        return true;
    }
}
