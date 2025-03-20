import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int num = map[r][c];
        map[r][c] = 0;

        bomb(r, c, num);
        down(r, c, num);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bomb(int r, int c, int num) {

        for (int dist = 1; dist < num; dist++) {
            for (int d = 0; d < 4; d++) {
                int nr = r + (dr[d] * dist);
                int nc = c + (dc[d] * dist);
                if (check(nr, nc)) {
                    map[nr][nc] = 0;
                }   
            }
        }

    }

    private static void down(int r, int c, int num) {
        int start = c - (num-1);
        start = start < 0 ? 0 : start;
        int end = c + (num-1);
        end = end > N-1 ? N-1 : end;

        for (int i = start; i <= end; i++) {
            if (i == c) continue;
            for (int j = r; j > 0; j--) {
                map[j][i] = map[j-1][i];
            }
            map[0][i] = 0;
        }

        int startIdx = 0;
        int endIdx = N-1;
        for (int i = 0; i < N; i++) {
            if (map[i][c] == 0) {
                startIdx = i-1;
            } else if (map[i][c] != 0 && startIdx != 0) {
                endIdx = i-1;
            }
        }

        if (startIdx < 0) {
            return;
        }

        for (int i = 0; i <= startIdx; i++) {
            map[endIdx--][c] = map[startIdx][c];
            map[startIdx--][c] = 0;
        }

    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}