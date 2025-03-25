import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    // static int[] dr = { -1, -1, 1, 1 };
    // static int[] dc = { }

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
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        if (dir == 0) {
            moveCW(r, c, m1, m2, m3, m4);
        } else {
            moveCCW(r, c, m1, m2, m3, m4);
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void moveCCW(int r, int c, int m1, int m2, int m3, int m4) {

        int temp = map[r][c];

        for (int i = 0; i < m1; i++) {
            map[r][c] = map[--r][++c];
        }

        for (int i = 0; i < m2; i++) {
            map[r][c] = map[--r][--c];
        }

        for (int i = 0; i < m3; i++) {
            map[r][c] = map[++r][--c];
        }

        for (int i = 0; i < m4; i++) {
            map[r][c] = map[++r][++c];
        }

        map[r-1][c-1] = temp;

    }

    private static void moveCW(int r, int c, int m1, int m2, int m3, int m4) {

        int temp = map[r][c];

        for (int i = 0; i < m4; i++) {
            map[r][c] = map[--r][--c];
        }

        for (int i = 0; i < m3; i++) {
            map[r][c] = map[--r][++c];
        }

        for (int i = 0; i < m2; i++) {
            map[r][c] = map[++r][++c];
        }

        for (int i = 0; i < m1; i++) {
            map[r][c] = map[++r][--c];
        }

        map[r-1][c+1] = temp;

    }

}