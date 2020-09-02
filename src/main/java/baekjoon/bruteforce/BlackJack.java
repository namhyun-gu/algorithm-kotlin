package baekjoon.bruteforce;

import java.util.Scanner;

public class BlackJack {
    private static int maxSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        permutation(cards, 0, 3, M);
        System.out.print(maxSum);
    }

    private static void permutation(int[] array, int depth, int r, int max) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += array[i];
            }
            if (sum > maxSum && sum <= max) {
                maxSum = sum;
            }
            return;
        }

        for (int i = depth; i < array.length; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, r, max);
            swap(array, depth, i);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
