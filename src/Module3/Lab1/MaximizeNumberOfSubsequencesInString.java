package Module3.Lab1;

import java.util.Scanner;

public class MaximizeNumberOfSubsequencesInString {

    //#######
    public static long maximumSubsequenceCount(String text, String pattern) {

        long result = 0, first = 0, second = 0;

        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == pattern.charAt(1)) {
                result += first;
                second++;
            }

            if (text.charAt(i) == pattern.charAt(0))
                first++;
        }

        return result + Math.max(first, second);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String b = input.nextLine();

        long ret = maximumSubsequenceCount(a, b);
        System.out.println(ret);
    }
}
