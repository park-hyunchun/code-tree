import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Queue<Integer> que = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String command;
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    que.offer(num);
                    break;
                case "pop":
                    System.out.println(que.poll());
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(que.peek());
                    break;
            }

        }

    }
}