import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    private static String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private static boolean checkWithStack(String input) {
        String normalized = normalize(input);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWithDeque(String input) {
        String normalized = normalize(input);
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.addLast(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWithTwoPointers(String input) {
        String normalized = normalize(input);
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("      Palindrome Checker App");
        System.out.println("       UC13: Performance");
        System.out.println("==================================");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();
        scanner.close();

        long start;
        long end;

        start = System.nanoTime();
        boolean stackResult = checkWithStack(input);
        end = System.nanoTime();
        long stackTime = end - start;

        start = System.nanoTime();
        boolean dequeResult = checkWithDeque(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        start = System.nanoTime();
        boolean twoPointerResult = checkWithTwoPointers(input);
        end = System.nanoTime();
        long twoPointerTime = end - start;

        System.out.println();
        System.out.println("Input (normalized): " + normalize(input));
        System.out.println("Stack Method Result      : " + stackResult + " | Time(ns): " + stackTime);
        System.out.println("Deque Method Result      : " + dequeResult + " | Time(ns): " + dequeTime);
        System.out.println("Two Pointer Method Result: " + twoPointerResult + " | Time(ns): " + twoPointerTime);
    }
}
