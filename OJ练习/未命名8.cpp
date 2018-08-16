#include<stdio.h>

int main()
{
	int n;
	scanf("%d",&n);
	int num = 0;
	int s = 0;
	for(int i = 1; i <= n; i++)
	{
		num += i;
		s += num;
	}
	printf("%d",s);
}
