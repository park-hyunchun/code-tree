import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static String[] strs;
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        n = str.length();

        strs = new String[n];

        result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            strs[i] = Character.toString(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            count();
            shift();
        }

        System.out.println(result);

    }

    private static void shift() {
        String temp = strs[0];
        for (int i = 0; i < n-1; i++) {
            strs[i] = strs[i+1];
        }
        strs[n-1] = temp;
    }

    private static void count() {
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        arr.add(strs[0]);
        for (int i = 1; i < n; i++) {
            if (strs[i].equals(arr.get(arr.size()-1))) {
                cnt++;
            } else {
                arr.add(Integer.toString(cnt));
                cnt = 1;
                arr.add(strs[i]);
            }
        }
        if (arr.size()%2 != 0) {
            arr.add(Integer.toString(cnt));
        }

        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }

        int len = sb.toString().length();
        result = result > len ? len : result;
    }

}