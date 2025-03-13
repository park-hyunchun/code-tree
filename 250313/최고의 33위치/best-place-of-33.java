import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int coin = countCoin(i, j, grid);
                if (max < coin) {
                    max = coin;
                }
            }
        }

        System.out.println(max);
    }
    private static int countCoin(int row, int col, int[][] gird) {
        int total = 0;
        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col+3; j++) {
                if (gird[i][j] == 1) {
                    total++;
                }
            }
        }
        return total;
    }
}