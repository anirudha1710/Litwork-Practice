package Module4.Lab1;

import java.util.Scanner;
import java.util.Stack;

public class ClumsyFactorial {

    //#######
    public static int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        int idx = 0;
        for (int i = n - 1; i > 0; --i) {
            if (idx % 4 == 0) {
                stack.push(stack.pop() * i);
            } else if (idx % 4 == 1) {
                stack.push(stack.pop() / i);
            } else if (idx % 4 == 2) {
                stack.push(i);
            } else {
                stack.push(-i);
            }
            ++idx;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = clumsy(n);
        System.out.println(result);
    }
}
