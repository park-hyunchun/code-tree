import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

    static int N, T;
    static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        belt = new int[2][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            belt[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N-1; i >= 0; i--) {
            belt[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < T; t++) {
            int temp = belt[1][0];
            for (int i = 0; i < N-1; i++) {
                belt[1][i] = belt[1][i+1];
            }
            belt[1][N-1] = belt[0][N-1];
            for (int i = N-1; i >= 1; i--) {
                belt[0][i] = belt[0][i-1];
            }
            belt[0][0] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(belt[0][i] + " ");
        }
        System.out.println();
        for (int i = N-1; i >= 0; i--) {
            System.out.print(belt[1][i] + " ");
        }

    }
}