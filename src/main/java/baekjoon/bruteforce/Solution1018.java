package baekjoon.bruteforce;

import java.util.Scanner;

public class Solution1018 {
    private static char[][] chess;
    private static char[][] chessPattern = {
            "WBWBWBWB".toCharArray(),
            "BWBWBWBW".toCharArray()
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        chess = new char[N][M];
        for (int n = 0; n < N; n++) {
            chess[n] = scanner.nextLine().toCharArray();
        }

        int minRepainted = Integer.MAX_VALUE;
        for (int startY = 0; startY <= N - 8; startY++) {
            for (int startX = 0; startX <= M - 8; startX++) {
                int repained = repaintChess(startX, startY);
                if (repained < minRepainted) {
                    minRepainted = repained;
                }
            }
        }
        System.out.print(minRepainted);
    }

    private static int repaintChess(int startX, int startY) {
        int minRepainted = Integer.MAX_VALUE;
        for (int pattern = 0; pattern < 2; pattern++) {
            int repainted = 0;
            for (int y = startY; y < startY + 8; y++) {
                for (int x = startX; x < startX + 8; x++) {
                    if (chess[y][x] != chessPattern[(y + pattern) % 2][x % 8]) {
                        repainted++;
                    }
                }
            }
            if (repainted < minRepainted) {
                minRepainted = repainted;
            }
        }
        return minRepainted;
    }
}
