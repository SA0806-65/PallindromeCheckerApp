import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PallindromeCheckerAppUseCase13 {

    public static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
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

    public static boolean dequeMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.addLast(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean stackResult = stackMethod(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerMethod(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        System.out.println("Stack Method Result: " + stackResult);
        System.out.println("Stack Method Time (ns): " + stackTime);

        System.out.println("Deque Method Result: " + dequeResult);
        System.out.println("Deque Method Time (ns): " + dequeTime);

        System.out.println("Two Pointer Method Result: " + twoPointerResult);
        System.out.println("Two Pointer Method Time (ns): " + twoPointerTime);

        scanner.close();
    }
}