package misc.permutation;

import java.util.Arrays;

public class CppStylePermutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        do {
            System.out.println(Arrays.toString(array));
        } while (nextPermutation(array));
    }

    public static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        int j = array.length - 1;

        // 1) 꼭대기 찾기
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i <= 0) {
            // 순열의 마지막 순서
            return false;
        }

        // 2) 다음 순열의 값 찾기
        while (array[i - 1] > array[j]) {
            j--;
        }
        swap(array, i - 1, j);

        // 3) 순서 정해주기
        j = array.length - 1;
        for (; i < j; i++, j--) {
            swap(array, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
