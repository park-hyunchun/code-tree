import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n-1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIdx = selectPivot(arr, low, high);

        int pivot = arr[pivotIdx];
        
        swap(arr, pivotIdx, high);

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);

        return i+1;

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pos = partition(arr, low, high);

            quickSort(arr, low, pos - 1);
            quickSort(arr, pos + 1, high);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static int selectPivot(int[] arr, int low, int high) {
        int pivot;
        int len = arr.length;
        if (len > 3) {
            int mid = len/2;
            if ((arr[low] >= arr[mid] && arr[low] <= arr[high]) || (arr[low] <= arr[mid] && arr[low] >= arr[high])) {
                pivot = low;
            } else if ((arr[mid] >= arr[low] && arr[mid] <= arr[high]) || (arr[mid] <= arr[low] && arr[mid] >= arr[high])) {
                pivot = mid;
            } else {
                pivot = high;
            }
        } else {
            pivot = high;
        }

        return pivot;
    }

}