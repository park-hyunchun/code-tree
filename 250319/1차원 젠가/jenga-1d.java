import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] zengar;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        zengar = new int[N];

        for (int i = 0; i < N; i++) {
            zengar[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int len = N-(e-s+1);
        temp = new int[len];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (i >= s-1 && i < e) continue;
            temp[idx++] = zengar[i];
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int len2 = len-(e-s+1);
        zengar = new int[len2];

        idx = 0;
        for (int i = 0; i < len; i++) {
            if (i >= s-1 && i < e) continue;
            zengar[idx++] = temp[i];
        }

        System.out.println(len2);
        for (int i = 0; i < len2; i++) {
            System.out.println(zengar[i]);
        }
        
    }
}