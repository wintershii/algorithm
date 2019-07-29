package leetcode;

public class Divide_29 {
    public static void main(String[] args) {
        System.out.println(new Divide_29().mySolve(-2147483648,1));
    }

    public int mySolve(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        boolean positive = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            positive = false;
        }
        long tempDividend = (long)dividend;
        long tempDivisor = (long)divisor;
        //转为正整数
        if(tempDividend < 0) {
            tempDividend = -tempDividend;
        }
        if(tempDivisor < 0) {
            tempDivisor = -tempDivisor;
        }
        //商的结果
        long result = 0;
        //当被除数还大于除数时
        while(tempDividend >= tempDivisor) {
            //最开始减一倍的除数
            long k = 1;
            long temp = tempDivisor;
            while(tempDividend >= temp) {
                tempDividend -= temp;
                result += k;
                k += k;
                temp += temp;
            }
        }
        if(positive) {
            if(result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }else {
                return (int)result;
            }
        }else {
            if(-result < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }else {
                return (int)(-result);
            }
        }
    }
}
