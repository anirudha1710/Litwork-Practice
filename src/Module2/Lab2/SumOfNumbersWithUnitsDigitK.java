package Module2.Lab2;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfNumbersWithUnitsDigitK {

    //#######
    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }

        if (k == 0) {
            if (num % 10 == 0) {
                return 1;
            }
            return -1;
        }

        if (num < k) {
            return -1;
        }

        HashMap<Integer, int[]> d = new HashMap<>();
        d.put(1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        d.put(2, new int[]{2, 4, 6, 8, 0});
        d.put(3, new int[]{3, 6, 9, 2, 5, 8, 1, 4, 7, 0});
        d.put(4, new int[]{4, 8, 2, 6, 0});
        d.put(5, new int[]{5, 0});
        d.put(6, new int[]{6, 2, 8, 4, 0});
        d.put(7, new int[]{7, 4, 1, 8, 5, 2, 9, 6, 3, 0});
        d.put(8, new int[]{8, 6, 4, 2, 0});
        d.put(9, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});

        if (!contains(d.get(k), num % 10)) {
            return -1;
        } else {
            int i = indexOf(d.get(k), num % 10) + 1;
            if (num < i * k) {
                return -1;
            }
            return i;
        }
    }

    private static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    private static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int k = 0;
        try {
            k = scanner.nextInt();
        } catch (Exception ignored) {
        }

        int result = minimumNumbers(num, k);
        System.out.println(result);
    }
}
