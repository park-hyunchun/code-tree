import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        String answer = "Yes";

        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer = "No";
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = "No";
        }

        System.out.println(answer);

    }
}