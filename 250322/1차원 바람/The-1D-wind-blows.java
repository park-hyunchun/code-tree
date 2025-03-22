import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, M, Q;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r;
        String d;
        for (int i = 0; i < Q; i++) {            
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            d = st.nextToken();

            if (d.equals("L")) {
                leftWind(r);
            } else {
                rightWind(r);
            }

            checkUp(r, d);    
            checkDown(r, d);
            
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void checkDown(int r, String d) {

        if (r == N-1) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < M; i++) {
            if (map[r+1][i] == map[r][i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            if (d.equals("R")) {
                leftWind(r+1);
                checkDown(r+1, "L");
            } else {
                rightWind(r+1);
                checkDown(r+1, "R");
            }
        }

    }

    private static void checkUp(int r, String d) {

        if (r == 0) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < M; i++) {
            if (map[r-1][i] == map[r][i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            if (d.equals("R")) {
                leftWind(r-1);
                checkUp(r-1, "L");
            } else {
                rightWind(r-1);
                checkUp(r-1, "R");
            }
        }
    }

    private static void rightWind(int r) {
        int temp = map[r][0];
        for (int i = 0; i < M-1; i++) {
            map[r][i] = map[r][i+1];
        }
        map[r][M-1] = temp;
    }

    private static void leftWind(int r) {
        int temp = map[r][M-1];
        for (int i = M-1; i > 0; i--) {
            map[r][i] = map[r][i-1];
        }
        map[r][0] = temp;
    }

}