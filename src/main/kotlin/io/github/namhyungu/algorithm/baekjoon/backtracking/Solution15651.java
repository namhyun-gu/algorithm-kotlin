package io.github.namhyungu.algorithm.baekjoon.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution15651 {
  private static BufferedWriter writer;

  private static int N;
  private static int M;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    writer = new BufferedWriter(new OutputStreamWriter(System.out));
    N = scanner.nextInt();
    M = scanner.nextInt();

    solution(0, "");
    writer.flush();
  }

  private static void solution(int depth, String str) throws IOException {
    if (depth == M) {
      writer.write(str + "\n");
      return;
    }

    boolean[] visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        solution(depth + 1, str.isEmpty() ? "" + i : str + " " + i);
      }
    }
  }
}
