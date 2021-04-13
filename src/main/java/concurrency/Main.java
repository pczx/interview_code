package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> weight = new HashMap<Character, Integer>(){
            {
                put('+', 1);
                put('-', 1);
                put('*', 2);
                put('/', 2);
            }
        };
        String str;
        while ((str = br.readLine()) != null) {
            Stack<Integer> data = new Stack<>();
            Stack<Character> operator = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int digit = 0;
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        digit = 10 * digit + str.charAt(i) - '0';
                        i++;
                    }
                    i--;
                    data.push(digit);
                } else {
                    if (str.charAt(i) == '-') {
                        if (i < 1 || str.charAt(i - 1) == '(') {
                            data.push(0);
                        }
                    }
                    if (operator.empty()) {
                        operator.push(str.charAt(i));
                    } else if (weight.getOrDefault(operator.peek(), 0) < weight.getOrDefault(str.charAt(i), 0) || str.charAt(i) == '(') {
                        operator.push(str.charAt(i));
                    } else {
                        if (str.charAt(i) == ')') {
                            while (operator.peek() != '(') {
                                Character op = operator.pop();
                                int data2 = data.pop();
                                int data1 = data.pop();
                                int res = compute(data1, data2, op);
                                data.push(res);
                            }
                            operator.pop();
                        } else {
                            while (!operator.empty() && weight.getOrDefault(operator.peek(), 0) >= weight.getOrDefault(str.charAt(i), 0)) {
                                Character op = operator.pop();
                                int data2 = data.pop();
                                int data1 = data.pop();
                                int res = compute(data1, data2, op);
                                data.push(res);
                            }
                            operator.push(str.charAt(i));
                        }
                    }
                }
            }
            while (!operator.empty()) {
                Character op = operator.pop();
                int data2 = data.pop();
                int data1 = data.pop();
                int res = compute(data1, data2, op);
                data.push(res);
            }
            System.out.println(data.pop());
        }
    }

    private static int compute(int data1, int data2, Character op) {
        int res = 0;
        switch (op) {
            case '+':
                res = data1 + data2;
                break;
            case '-':
                res = data1 - data2;
                break;
            case '*':
                res = data1 * data2;
                break;
            case '/':
                res = data1 / data2;
                break;
            default:
        }
        return res;
    }
}