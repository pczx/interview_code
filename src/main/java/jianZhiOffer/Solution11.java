package jianZhiOffer;

public class Solution11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int index1 = 0, index2 = numbers.length - 1, indexMid = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = index1 + (index2 - index1) / 2;

            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[indexMid]) {
                return minInOrder(numbers, index1, index2);
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }

    private int minInOrder(int[] numbers, int index1, int index2) {
        int result = numbers[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result < numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}