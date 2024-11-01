import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(arr, n);

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = i * 2;
        int r = i * 2 + 1;

        if (l <= n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r <= n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void heapSort(int[] arr, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(arr, n, i);
        }

        for (int i = n; i > 1; i--) {
            swap(arr, 1, i);
            heapify(arr, i-1, 1);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}