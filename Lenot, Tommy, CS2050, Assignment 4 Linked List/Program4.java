// Lenot,Tommy CS2050, Assignment: Program #4 Linked List
// Please note that when I did this, I had the Program4.txt in the same file directory inside the Project's name, not inside the src folder so it should be in the same area as in the same with Projecjname.iml and that I had to close and reopened IntelliJ to see that Program4.txt was in it as well.
//Please note that in Program4.txt as you said to put our name, assignment, etc. on each file i did so, but in Program3.txt it will  - Stacks: Infix to Postfix   ->   invalid character. This is beacuse of having my name and assignment will produce that so erasing my name will remove that, and again you did say you wanted our names, assignment of file, etc. on each one we created and sent.
import java.io.*;

public class Program4 {

    public static String InfixToPostfix(String s) {
        MyLinkedStack<Character> stack = new MyLinkedStack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') continue; // Skip spaces
            if (Character.isDigit(c) || c == '.') {
                postfix.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                postfix.append(' '); // Separate numbers and operators
                while (!stack.empty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    postfix.append(' ');
                    postfix.append(stack.pop());
                }
                if (stack.empty() || stack.pop() != '(') {
                    return "unmatched parens";
                }
            } else {
                return "invalid character";
            }
        }

        while (!stack.empty()) {
            if (stack.peek() == '(') {
                return "unmatched parens";
            }
            postfix.append(' ');
            postfix.append(stack.pop());
        }

        return postfix.toString().trim(); // Remove any trailing spaces
    }

    private static int precedence(char op) {
        switch (op) {
            case '+': case '-':
                return 1;
            case '*': case '/': case '%':
                return 2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Program4.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("Program4.out"));

        String line;
        while ((line = reader.readLine()) != null) {
            String postfix = InfixToPostfix(line);
            writer.println(line + "   ->   " + postfix);
        }

        reader.close();
        writer.close();
    }
}
