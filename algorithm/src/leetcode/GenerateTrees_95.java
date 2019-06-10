package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees_95 {
    public List<TreeNode> generateTrees(int n) {
        // 先划分再递归
        List<TreeNode> res = new ArrayList<>();
        if(n<1)
            return res;
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);
            for(TreeNode j:left){
                for(TreeNode k:right){
                    TreeNode root = new TreeNode(i);
                    root.left=j;
                    root.right=k;
                    res.add(root);
                }
            }
        }
        return res;

    }
}
