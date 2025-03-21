import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int N, R, C;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static Queue<int[]> que;
    static boolean[][] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken())-1;
        C = Integer.parseInt(st.nextToken())-1;

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        que = new LinkedList<>();
        que.offer(new int[] {R, C});
        sb.append(map[R][C]).append(" ");
        visited[R][C] = true;

        bfs();

        System.out.println(sb.toString());

    }

    private static void bfs() {

        while(!que.isEmpty()) {

            int[] cur = que.poll();
            int r = cur[0];
            int c = cur[1];
            int num = map[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (check(nr, nc) && !visited[nr][nc]) {
                    if (map[nr][nc] > num) {
                        visited[nr][nc] = true;
                        que.offer(new int[] { nr, nc });
                        sb.append(map[nr][nc]).append(" ");
                        break;
                    }
                }
            }

        }

    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}