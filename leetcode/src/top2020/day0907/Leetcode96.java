package top2020.day0907;

/**
 * 不同的二叉搜索树
 * 输入n，求1....n组成的二叉搜索树有多少种
 * 思路：假设G（n）是由n个节点组成二叉搜索树的个数。那么跟节点就是1...n中的一个
 * 我们假设i为根节点，那么i的左右子二叉搜索树的个数分别是G(i-1)和G(n-i),f(i) = G(i-1)*G(n-i)
 */
public class Leetcode96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
