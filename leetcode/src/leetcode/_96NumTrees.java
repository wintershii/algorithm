package leetcode;

/**
 * 不同的二叉搜索树
 * 给定一个整数n,求以1...n为节点组成的二叉搜索树有多少种
 *
 * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
 * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
 * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 */
public class _96NumTrees {


    public int numTrees(int n) {
        int[] f=new int[n+1];
        f[1]=1;
        f[0]=1;
        int point=2;
        while (point <= n){
            for (int i = 1; i <= point; i++)
                f[point] += f[i - 1] * f[point - i];
            point++;
        }
        return f[n];
    }

}
