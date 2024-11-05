import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Deque<Integer> deque = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while(deque.size() != 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.peek());

    }
}