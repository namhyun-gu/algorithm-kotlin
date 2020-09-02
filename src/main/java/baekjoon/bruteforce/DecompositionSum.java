package baekjoon.bruteforce;

import java.util.Scanner;

public class DecompositionSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int min = N;
        for (int creator = N - 1; creator > 0; creator--) {
            if (N == creator + sumDigits(creator)) {
                if (creator < min) {
                    min = creator;
                }
            }
        }
        if (min == N) min = 0;
        System.out.print(min);
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
