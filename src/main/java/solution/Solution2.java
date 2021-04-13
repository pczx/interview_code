package solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            input.nextLine();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = input.nextInt();
                points[i][1] = input.nextInt();
                input.nextLine();
            }
            int ans = 0;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        if ((points[k][1] - points[j][1]) * (points[j][0] - points[i][0]) != (points[j][1] - points[i][1]) * (points[k][0] - points[j][0])) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
