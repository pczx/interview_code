package solution;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String a = input.next();
            String b = input.next();
            System.out.println(multiply(a, b));
        }
    }

    public static String multiply(String s1, String s2) {
        String ans = "";
        String sb1 = new StringBuilder(s1).reverse().toString();
        String sb2 = new StringBuilder(s2).reverse().toString();
        for (int i = 0; i < sb2.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j > 0; j--) {
                sb.append("0");
            }
            int carry = 0;
            int b = sb2.charAt(i) - '0';
            for (int j = 0; j < sb1.length(); j++) {
                int a = sb1.charAt(j) - '0';
                int mul = a * b + carry;
                sb.append(mul % 10);
                carry = mul / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            ans = addString(ans, sb.toString());
        }
        return new StringBuilder(ans).reverse().toString();
    }

    public static String addString(String s1, String s2) {
        if (s1.equals("")) {
            return s2;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0, j = 0;
        while (i < s1.length() || j < s2.length() || carry != 0) {
            int a = i < s1.length() ? s1.charAt(i) - '0' : 0;
            int b = j < s2.length() ? s2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i++;
            j++;
        }
        return sb.toString();
    }
}
