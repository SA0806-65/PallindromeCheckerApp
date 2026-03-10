import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class PallindromeCheckerAppUseCase7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();
        String original = input.toLowerCase();

        for (int i = 0; i < original.length(); i++) {
            deque.addLast(original.charAt(i));
        }

        int flag = 0;

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
