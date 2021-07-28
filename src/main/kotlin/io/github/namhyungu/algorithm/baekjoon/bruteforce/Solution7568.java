package io.github.namhyungu.algorithm.baekjoon.bruteforce;

import java.util.Scanner;

public class Solution7568 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[][] mans = new int[N][2];
    int[] ranks = new int[N];

    for (int i = 0; i < N; i++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();

      mans[i][0] = x;
      mans[i][1] = y;
    }

    for (int i = 0; i < N; i++) {
      int manX = mans[i][0];
      int manY = mans[i][1];

      int rank = 0;
      for (int j = 0; j < N; j++) {
        if (i == j) {
          continue;
        }
        int manP = mans[j][0];
        int manQ = mans[j][1];

        if (manX < manP && manY < manQ) {
          rank++;
        }
      }
      ranks[i] = rank + 1;
    }

    for (int i = 0; i < N; i++) {
      System.out.print(ranks[i] + " ");
    }
  }
}
