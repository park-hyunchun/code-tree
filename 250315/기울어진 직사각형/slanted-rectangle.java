import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[] dr = { -1, -1, 1, 1 };
    static int[] dc = { 1, -1, -1, 1 };
    static int R, C;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j < N-1; j++) {
                R = i;
                C = j;
                makeSquare(i, j, 0, 0);
            }
        }

        System.out.println(result);

    }

    private static void makeSquare(int r, int c, int sum, int dir) {

        if (sum != 0 && R == r && C == c) {
            if (result < sum) {
                result = sum;
            }
            return;
        }

        sum += map[r][c];

        for (int d = dir; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(check(nr, nc)) {
                makeSquare(nr, nc, sum, d);
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}