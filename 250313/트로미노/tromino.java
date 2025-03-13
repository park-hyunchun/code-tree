import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;

        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i + 1 < n && j + 1 < m) {
                    temp = goA(i, j);
                    max = max < temp ? temp : max;
                }
                if (i + 2 < n) {
                    temp = goB(i, j);
                    max = max < temp ? temp : max;
                }
                if (j + 2 < m) {
                    temp = goC(i, j);
                    max = max < temp ? temp : max;
                }
            }
        }

        System.out.println(max);

    }

    private static int goA(int r, int c) {
        int result;
        int temp;
        result = grid[r][c] + grid[r+1][c] + grid[r+1][c+1];
        temp = grid[r+1][c] + grid[r+1][c+1] + grid[r][c+1];
        result = result < temp ? temp : result;
        temp = grid[r+1][c+1] + grid[r][c+1] + grid[r][c];
        result = result < temp ? temp : result;
        temp = grid[r][c+1] + grid[r][c] + grid[r+1][c];
        result = result < temp ? temp : result;
        return result;
    }

    private static int goB(int r, int c) {
        int sum = 0;
        for (int i = r; i < r + 3; i++) {
            sum += grid[i][c];
        }
        return sum;
    }

    private static int goC(int r, int c) {
        int sum = 0;
        for (int i = c; i < c + 3; i++) {
            sum += grid[r][i];
        }
        return sum;
    }

}