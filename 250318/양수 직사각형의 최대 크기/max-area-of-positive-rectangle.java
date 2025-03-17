import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {

    static int N, M;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for  (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < M; c2++) {

                        int cnt = 0;
                        boolean flag = true;
                        for (int i = r1; i <= r2; i++) {
                            for (int j = c1; j <= c2; j++) {
                                if (map[i][j] > 0) {
                                    cnt++;
                                } else {
                                    cnt = 0;
                                    flag = false;
                                    break;
                                }
                            }
                        }

                        if (flag) {
                            result = Math.max(result, cnt);
                        }

                    }
                }
            }
        }

        System.out.println(result);

    }
}