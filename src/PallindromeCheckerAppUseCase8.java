import java.util.Scanner;

public class PallindromeCheckerAppUseCase8 {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine().toLowerCase();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (head == null || head.next == null) {
            System.out.println("The given string is a Palindrome.");
            scanner.close();
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        int flag = 0;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                flag = 1;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (flag == 0) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}