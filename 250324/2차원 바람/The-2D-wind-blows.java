import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, M, Q;
    static int[][] map;
    static int[][] temp;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;

            turn(r1, c1, r2, c2);
            fill(r1, c1, r2, c2);
            copyMap();   
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    private static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }

    private static int avg(int r, int c) {
        int result = map[r][c];
        int cnt = 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (check(nr, nc)) {
                cnt++;
                result += map[nr][nc];
            }
        }
        return result/cnt;
    }

    private static void fill(int r1, int c1, int r2, int c2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i >= r1 && i <= r2) && (j >= c1 && j <= c2)) {
                    temp[i][j] = avg(i, j);
                } else {
                    temp[i][j] = map[i][j];
                }
            }
        }
    }

    private static void turn(int r1, int c1, int r2, int c2) {
        int temp = map[r1][c1];

        for (int i = r1; i < r2; i++) {
            map[i][c1] = map[i + 1][c1];
        }

        for (int i = c1; i < c2; i++) {
            map[r2][i] = map[r2][i + 1];
        }

        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i - 1][c2];
        }

        for (int i = c2; i > c1; i--) {
            map[r1][i] = map[r1][i - 1];
        }

        map[r1][c1+1] = temp;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}