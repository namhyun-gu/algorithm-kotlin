package baekjoon.backtracking;

import java.util.Scanner;

public class Solution14888 {
    private static int[] nums;
    private static int[] operators;
    private static int[] order;

    private static int N;
    private static int min;
    private static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        nums = new int[N];
        operators = new int[4];
        order = new int[N - 1];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = scanner.nextInt();
        }

        solution(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void solution(int idx) {
        if (idx == N - 1) {
            int calc = nums[0];
            for (int i = 1; i < N; i++) {
                int operator = order[i - 1];
                if (operator == 0) {
                    calc += nums[i];
                } else if (operator == 1) {
                    calc -= nums[i];
                } else if (operator == 2) {
                    calc *= nums[i];
                } else {
                    if (calc < 0) {
                        calc = -(Math.abs(calc) / nums[i]);
                    } else {
                        calc /= nums[i];
                    }
                }
            }
            min = Math.min(min, calc);
            max = Math.max(max, calc);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                order[idx] = i;
                solution(idx + 1);
                operators[i]++;
            }
        }
    }
}
