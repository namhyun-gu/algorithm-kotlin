package misc.permutation;

import java.util.Arrays;

public class VisitPermutation {
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        visited = new boolean[array.length];
        result = new int[array.length];
        permutation(array, 0, 3);
    }

    public static void permutation(int[] array, int index, int r) {
        if (index == r) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                continue;
            }
            result[index] = array[i];
            visited[i] = true;
            permutation(array, index + 1, r);
            visited[i] = false;
        }
    }
}
