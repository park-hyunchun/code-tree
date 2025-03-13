import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int num;
        boolean hasGold = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 1) {
                    hasGold = true;
                }
            }
        }

        if (hasGold) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k < N+3; k++) {
                        getDiamond(i, j, k);
                    }
                }
            }
            if (result == 0) {
                result = 1;
            }
        } else {
            result = 0;
        }

        System.out.println(result);

    }

    private static void getDiamond(int r, int c, int k) {
        int sum = 0;
        int gold = 0;
        for (int dr = -k; dr <= k; dr++) {
            for (int dc = -k; dc <= k; dc++) {
                if (Math.abs(dr) + Math.abs(dc) <= k) {
                    int x = r + dr;
                    int y = c + dc;
                    if (check(x, y) && map[x][y] == 1) {
                        sum += M;
                        gold++;
                    }
                }
            }
        }

        if (sum < ((int)Math.pow(k, 2) + (int)Math.pow(k+1, 2))) {
            return;
        }

        result = Math.max(result, gold);
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

};  