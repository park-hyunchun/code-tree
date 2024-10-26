import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Character> list = new LinkedList<>();

        String bread = br.readLine();
        for (int i = 0; i < n; i++) {
            list.offer(bread.charAt(i));
        }

        ListIterator<Character> it = list.listIterator(list.size());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "L":
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case "R":
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case "D":
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    it.add(c);
                    break;
            }
        }

        it = list.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }


    }
}