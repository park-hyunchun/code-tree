import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int size = 4;
    static int[] stack = new int[size];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String command;
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    System.out.println(index);
                    break;
                case "empty":
                    System.out.println(index > 0 ? 0 : 1);
                    break;
                case "top":
                    System.out.println(stack[index-1]);
                    break;
            }
        }

    }

    private static void push(int num) {
        if (index < size) {
            stack[index++] = num;
        }
        else {
            int[] temp = new int[size*2];
            for (int i = 0; i < size; i++) {
                temp[i] = stack[i];
            }
            size *= 2;
            stack = temp;
            stack[index++] = num;
        }
    }

    private static void pop() {
        System.out.println(stack[index-1]);
        index--;
    }
}