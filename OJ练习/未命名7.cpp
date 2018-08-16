#include<stdio.h>

int main()
{
	double e = 0.0;
	double sum = 1;
	double t = 1;
	for(int i = 1; sum >= 1E-7; i++)
	{
		t *= i;
		sum = 1.0/t;
		e += sum;
	}
	printf("%lf",e+1);
	return 0;
}
