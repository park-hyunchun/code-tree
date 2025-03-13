import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
    
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            boolean isHappy = false;
            for (int j = 0; j < n-1; j++) {
                if (grid[i][j] == grid[i][j+1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt == m) {
                    isHappy = true;
                }
            }
            if (isHappy || cnt == m) {
                result++;
            }
        }

        for (int j = 0; j < n; j++) {
            int cnt = 1;
            boolean isHappy = false;
            for (int i = 0; i < n-1; i++) {
                if (grid[i][j] == grid[i+1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt == m) {
                    isHappy = true;
                }
            }
            if (isHappy || cnt == m) {
                result++;
            }
        }

        System.out.println(result);

    }
}