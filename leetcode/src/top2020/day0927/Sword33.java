package top2020.day0927;

public class Sword33 {
    public boolean verifyPostorder(int[] postorder) {
        return rebuild(postorder, 0, postorder.length-1);
    }

    public boolean rebuild(int[] postorder, int left, int right) {
        if (left > right) {
            return true;
        }
        int tmp = left;
        while (postorder[tmp] < postorder[right]) {
            tmp++;
        }
        int mid = tmp;
        while (postorder[tmp] > postorder[right]) {
            tmp++;
        }
        return tmp == right && rebuild(postorder, left, mid-1) && rebuild(postorder, mid, right-1);
    }
}
