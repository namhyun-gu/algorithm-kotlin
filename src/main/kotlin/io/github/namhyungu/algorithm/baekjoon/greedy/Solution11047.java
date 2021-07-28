package io.github.namhyungu.algorithm.baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution11047 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();

    ArrayList<Integer> coinValues = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int coinValue = scanner.nextInt();
      if (coinValue < K) {
        coinValues.add(coinValue);
      }
    }

    int answer = 0;
    while (K != 0) {
      int min = Integer.MAX_VALUE;
      int minIdx = 0;

      for (int i = 0; i < coinValues.size(); i++) {
        int cnt = K / coinValues.get(i);
        if (cnt != 0 && cnt < min) {
          min = cnt;
          minIdx = i;
        }
      }

      K -= (coinValues.get(minIdx) * min);
      answer += min;
    }
    System.out.print(answer);
  }
}
