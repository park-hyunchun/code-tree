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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        while(!que.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                que.offer(que.poll());
            }
            System.out.print(que.poll() + " ");
        }

    }
}