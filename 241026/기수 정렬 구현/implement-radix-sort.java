import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        ArrayList<Integer>[] arr_new = new ArrayList[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxPos = getMaxPos(arr);

        for (int pos = 0; pos < maxPos; pos++) {
            for (int digitNum = 0; digitNum < 10; digitNum++) {
                arr_new[digitNum] = new ArrayList<>();
            }
            for (int num : arr) {
                int digit = getDigit(num, pos);
                arr_new[digit].add(num);
            }

            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int num : arr_new[i]) {
                    arr[index++] = num;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int getMaxPos(int[] arr) {
        int maxNum = 0;
        for (int num : arr) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return Integer.toString(maxNum).length();
    }

    private static int getDigit(int num, int pos) {
        return (int) (num / Math.pow(10, pos)) % 10;
    }

}