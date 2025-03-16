import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int N, t;
    static int[][] belt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        belt = new int[3][N];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                belt[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N-1; i >= 0; i--) {
            belt[2][i] = Integer.parseInt(st.nextToken());
        }

        for (int time = 0; time < t; time++) {
            int temp = belt[2][0];
            for (int i = 0; i < N-1; i++) {
                belt[2][i] = belt[2][i+1];
            }
            belt[2][N-1] = belt[1][N-1];
            for (int i = N-1; i > 0; i--) {
                belt[1][i] = belt[1][i-1];
            }
            belt[1][0] = belt[0][N-1];
            for (int i = N-1; i > 0; i--) {
                belt[0][i] = belt[0][i-1];
            }
            belt[0][0] = temp;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(belt[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = N-1; i >= 0; i--) {
            System.out.print(belt[2][i] + " ");
        }

    }
}