package leetcode;

public class NumTrees_96 {


    public int numTrees(int n) {
        int[] f=new int[n+1];
        f[1]=1;
        f[0]=1;
        int point=2;
        while (point<=n){
            for(int i=1;i<=point;i++)
                f[point]+=f[i-1]*f[point-i];
            point++;
        }
        return f[n];
    }

}
