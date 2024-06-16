import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        String[] ss = words.split(" ");
        String str = "";
        for(String s : ss){
            str += s;
        }
        Stack<Double> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        double ans;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
//            if(c == ' '){
//                continue;
//            }
            if (Character.isDigit(c)) {
                int j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    j++;
                }
                double num = Double.parseDouble(str.substring(i, j));
                numStack.push(num);
                i = j - 1;
            } else {
                while (!opStack.isEmpty() && compare(opStack.peek(), c) >= 0) {
                    double b = numStack.pop();
                    double a = numStack.pop();
                    char op = opStack.pop();
                    double result = calculate(a, b, op);
                    numStack.push(result);
                }
                opStack.push(c);
            }
        }
        while (!opStack.isEmpty()) {
            double b = numStack.pop();
            double a = numStack.pop();
            char op = opStack.pop();
            double result = calculate(a, b, op);
            numStack.push(result);
        }
        ans = numStack.pop();
        System.out.println(ans);
    }

    public static int compare(char a, char b) {
        if ((a == '+' || a == '-') && (b == '*' || b == '/')) {
            return -1;
        } else if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double calculate(double num1, double num2, char ch) {
        if(ch == '+'){
            return num1 + num2;
        }else if(ch == '-'){
            return num1 - num2;
        }else if(ch == '*'){
            return num1 * num2;
        }else if(ch == '/'){
            return num1 / num2;
        }
        return 0;
    }
}