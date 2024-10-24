import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        String command;
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch(command) {
                case "push_back":
                num = Integer.parseInt(st.nextToken());
                arr.add(num);
                break;
                case "get": 
                num = Integer.parseInt(st.nextToken());
                System.out.println(arr.get(num-1));
                break;
                case "size": System.out.println(arr.size());
                break;
                case "pop_back": arr.remove(arr.size()-1);
                break;
            }

        }

    }
}