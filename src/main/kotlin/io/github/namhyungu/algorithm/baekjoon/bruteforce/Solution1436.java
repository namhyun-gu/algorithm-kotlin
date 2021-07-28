package io.github.namhyungu.algorithm.baekjoon.bruteforce;

import java.util.Scanner;

public class Solution1436 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    int n = 0;
    int num = 0;
    while (n != N) {
      if (String.valueOf(++num).contains("666")) {
        n++;
      }
    }
    System.out.print(num);
  }
}
