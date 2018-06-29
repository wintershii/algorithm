#include<stdio.h>

int gcd(int a,int b)
{
	return a % b? gcd(b,a%b):b;
}

int lcm(int a,int b)
{
	return a * b/gcd(a,b);
}

int main()
{
	int a,b;
	while(~scanf("%d %d",&a,&b))
	{
		printf("gcd :%d  ",gcd(a,b));
		printf("lcm :%d  ",lcm(a,b));
	}
	return 0;
}
