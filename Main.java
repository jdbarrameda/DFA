import java.util.Scanner;

public class Main {
    
    enum State {
        q0, q1, q2
    }

    public static boolean isAccepted(String input) {
        State currentState = State.q0;  

        for (char ch : input.toCharArray()) {
            switch (currentState) {
                case q0:
                    if (ch == '0') {
                        currentState = State.q1;
                    } else if (ch == '1') {
                        currentState = State.q0;  
                    }
                    break;
                case q1:
                    if (ch == '0') {
                        currentState = State.q1;  
                    } else if (ch == '1') {
                        currentState = State.q2;  
                    }
                    break;
                case q2:
                    if (ch == '0') {
                        currentState = State.q1;  
                    } else if (ch == '1') {
                        currentState = State.q0;  
                    }
                    break;
            }
        }

        return currentState == State.q2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a binary string (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (!input.matches("[01]+")) {
                System.out.println("Invalid input. Please enter a binary string containing only '0' and '1'.");
                continue;
            }

            if (isAccepted(input)) {
                System.out.println("The string is accepted by the DFA.");
            } else {
                System.out.println("The string is not accepted by the DFA.");
            }
        }
        scanner.close();
    }
}
