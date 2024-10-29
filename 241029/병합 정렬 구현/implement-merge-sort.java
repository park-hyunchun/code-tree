import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n-1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] mergedArr = new int[arr.length];
        int i = low;
        int j = mid + 1;

        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArr[k++] = arr[i++];
            } else {
                mergedArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            mergedArr[k++] = arr[i++];
        }

        while (j <= high) {
            mergedArr[k++] = arr[j++];
        }

        for (k = low; k <= high; k++) {
            arr[k] = mergedArr[k];
        }
    }
}