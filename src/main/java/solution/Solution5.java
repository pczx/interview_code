package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hp = Integer.parseInt(br.readLine());
        int normalAttack = Integer.parseInt(br.readLine());
        int buffedAttack = Integer.parseInt(br.readLine());
        System.out.println(minTurn(hp, normalAttack, buffedAttack));
    }

    public static int minTurn(int hp, int normalAttack, int buffedAttack) {
        if (2 * normalAttack >= buffedAttack) {
            return (hp - 1) / normalAttack + 1;
        }
        int turn = 0;
        int sum = 0;
        while (sum < hp) {
            turn++;
            if ((turn & 1) == 1) {
                sum += normalAttack;
            } else {
                sum = turn / 2 * buffedAttack;
            }
        }
        return turn;
    }
}
