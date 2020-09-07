package programmers.kakao.blind_recruitment.v2020;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int extendLockSize = lock.length * 3;
        int[][] newLock = new int[extendLockSize][extendLockSize];
        for (int y = 0; y < lock.length; y++) {
            for (int x = 0; x < lock.length; x++) {
                newLock[lock.length + y][lock.length + x] = lock[y][x];
            }
        }
        return adjust(key, newLock);
    }

    private boolean adjust(int[][] key, int[][] lock) {
        int limit = lock.length - key.length;
        for (int y = 0; y < limit; y++) {
            for (int x = 0; x < limit; x++) {
                int[][] rotated = copyArray(key);
                for (int i = 0; i < 4; i++) {
                    rotated = rotate(rotated);
                    if (isFit(rotated, lock, x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isFit(int[][] key, int[][] lock, int curX, int curY) {
        int lockSize = lock.length / 3;
        int[][] fitted = copyArray(lock);
        for (int y = 0; y < key.length; y++) {
            for (int x = 0; x < key.length; x++) {
                fitted[curY + y][curX + x] = lock[curY + y][curX + x] ^ key[y][x];
            }
        }
        for (int y = 0; y < lockSize; y++) {
            for (int x = 0; x < lockSize; x++) {
                if (fitted[lockSize + y][lockSize + x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate(int[][] array) {
        int size = array.length;
        int[][] newArray = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                newArray[size - x - 1][y] = array[y][x];
            }
        }
        return newArray;
    }

    private int[][] copyArray(int[][] src) {
        int[][] dest = new int[src.length][];
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i].clone();
        }
        return dest;
    }
}
