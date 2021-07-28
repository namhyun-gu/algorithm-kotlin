package io.github.namhyungu.algorithm.baekjoon.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution2580 {
  private static int[][] sudoku;
  private static ArrayList<Point> blanks;

  private static BufferedWriter writer;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    writer = new BufferedWriter(new OutputStreamWriter(System.out));
    sudoku = new int[9][9];
    blanks = new ArrayList<>();

    for (int y = 0; y < 9; y++) {
      for (int x = 0; x < 9; x++) {
        int num = scanner.nextInt();
        if (num == 0) {
          blanks.add(new Point(x, y));
        }
        sudoku[x][y] = num;
      }
    }

    solution(0);
  }

  private static void solution(int n) throws IOException {
    if (n == blanks.size()) {
      for (int y = 0; y < 9; y++) {
        for (int x = 0; x < 9; x++) {
          String suffix = (x < 8) ? " " : "\n";
          writer.write(sudoku[x][y] + suffix);
        }
      }
      writer.flush();
      System.exit(0);
    }

    Point blank = blanks.get(n);
    int x = blank.x;
    int y = blank.y;

    for (int num = 1; num <= 9; num++) {
      if (checkRow(y, num) && checkCol(x, num) && checkSquare(x, y, num)) {
        sudoku[x][y] = num;
        solution(n + 1);
        sudoku[x][y] = 0;
      }
    }
  }

  private static boolean checkRow(int y, int num) {
    for (int x = 0; x < 9; x++) {
      if (sudoku[x][y] == num) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkCol(int x, int num) {
    for (int y = 0; y < 9; y++) {
      if (sudoku[x][y] == num) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkSquare(int curX, int curY, int num) {
    int startX = (curX / 3) * 3;
    int startY = (curY / 3) * 3;

    for (int y = startY; y < startY + 3; y++) {
      for (int x = startX; x < startX + 3; x++) {
        if (sudoku[x][y] == num) {
          return false;
        }
      }
    }
    return true;
  }

  static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
