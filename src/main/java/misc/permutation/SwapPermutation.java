package misc.permutation;

import java.util.Arrays;

public class SwapPermutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        permutation(array, 0, 3);
    }

    public static void permutation(int[] array, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(array));
            return;
        }

        for (int i = depth; i < array.length; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, r);
            swap(array, depth, i);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
