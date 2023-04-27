import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};
        build(arr);


    }

    public static int[] mark(int[] arr, int left, int right, int currentLevel, int[] levels) {
        if(left == right) {
            levels[left] = currentLevel;
            return levels;
        }
        int middle = (left + right) / 2;
        levels[middle] = currentLevel;
        mark(arr, left, middle - 1, currentLevel + 1, levels);
        mark(arr, middle + 1, right, currentLevel + 1, levels);
        return levels;
    }

    public static void build(int[] arr) {
        int[] levels = new int[arr.length];
        mark(arr, 0, arr.length - 1, 0, levels);
        int maxLevel = maxArrValue(levels, levels.length);
        for (int l = 0; l < maxLevel + 1; l++) {
            for (int i = 0; i < arr.length; i++) {
                if (levels[i] == l) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }

    }

    public static int maxArrValue(int[] arr, int length) {
        if(length == 0) {
            return arr[0];

        }
        return Math.max(arr[length - 1], maxArrValue(arr, length - 1));

    }
}
