import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z') {
                stack.push(numbers[exp.charAt(i) - 'A']);
            } else {
                if (!stack.isEmpty()) {
                    double first = stack.pop();
                    double second = stack.pop();

                    switch (exp.charAt(i)) {
                        case '+':
                            stack.push(first + second);
                            break;
                        case '-':
                            stack.push(second - first);
                            break;
                        case '*':
                            stack.push(first * second);
                            break;
                        case '/':
                            stack.push(second / first);
                            break;
                    }
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
