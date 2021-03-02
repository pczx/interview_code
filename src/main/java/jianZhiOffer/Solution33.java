package jianZhiOffer;

class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorderCore(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorderCore(int[] postorder, int start, int end) {
        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > postorder[end]) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (postorder[j] < postorder[end]) {
                return false;
            }
        }
        boolean left = true;
        if (i > start) {
            left = verifyPostorderCore(postorder, start, i - 1);
        }
        boolean right = true;
        if (i < end) {
            right = verifyPostorderCore(postorder, i, end - 1);
        }
        return left && right;
    }
}
