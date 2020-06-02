package p05;

public class SumNums_m64 {
    public int sumNums(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumNums(n-1);
    }

    public int sumNums_1(int n) {
        return (((int)Math.pow(n,2) + n) >> 1);
    }


    public int sumNums_2(int n) {
        int res = n;
        boolean flag = n > 0 && (res += sumNums_2(n-1)) > 0;
        return res;
    }
}
