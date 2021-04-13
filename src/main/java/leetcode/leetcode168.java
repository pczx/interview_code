package leetcode;

public class leetcode168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            ans.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new leetcode168().convertToTitle(701));
    }
}