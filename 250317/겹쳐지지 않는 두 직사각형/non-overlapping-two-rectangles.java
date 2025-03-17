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
        result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum1;
        int sum2;
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < M; c2++) {

                        sum1 = 0;
                        for (int i = r1; i <= r2; i++) {
                            for (int j = c1; j <= c2; j++) {
                                sum1 += map[i][j];
                            }
                        }

                        for (int r3 = 0; r3 < N; r3++) {
                            for (int c3 = 0; c3 < M; c3++) {

                                if (r3 <= r2 && c3 <= c2) continue;

                                for (int r4 = r3; r4 < N; r4++) {
                                    for (int c4 = c3; c4 < M; c4++) {
                                        
                                        sum2 = 0;
                                        for (int i = r3; i <= r4; i++) {
                                            for (int j = c3; j <= c4; j++) {
                                                sum2 += map[i][j];
                                            }
                                        }

                                        result = Math.max(result, sum1 + sum2);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.println(result);

    }

}