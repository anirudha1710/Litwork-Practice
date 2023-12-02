package Contests.Module1;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class OOOD_Dancing_pair {
    public static void findValidPairs(int[] heights) {
    if (heights.length == 0) {
        System.out.println("No Valid pairs");
        return;
    }

    Map<Integer, Integer> heightFrequency = new HashMap<>();

        for (int height : heights) {
        heightFrequency.put(height, heightFrequency.getOrDefault(height, 0) + 1);
    }

        if (heightFrequency.size() == 1) {
        System.out.println("No Valid pairs");
        return;
    }

    int[] uniqueHeights = heightFrequency.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();

    int tallIndex = uniqueHeights.length - 1;
    int shortIndex = 0;

        while (tallIndex > shortIndex) {
        int tallHeight = uniqueHeights[tallIndex];
        int shortHeight = uniqueHeights[shortIndex];

        System.out.println(tallHeight + " " + shortHeight);

        heightFrequency.put(tallHeight, heightFrequency.get(tallHeight) - 1);
        heightFrequency.put(shortHeight, heightFrequency.get(shortHeight) - 1);

        if (heightFrequency.get(tallHeight) == 0) {
            tallIndex--;
        }
        if (heightFrequency.get(shortHeight) == 0) {
            shortIndex++;
        }
    }
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int[] heights = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            findValidPairs(heights);
        } catch (NumberFormatException e) {
            System.out.println("Input string was not in a correct format");
        }
    }
}
