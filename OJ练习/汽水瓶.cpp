#include<stdio.h>

int main()
{
	int n;
	while((~scanf("%d",&n) ) && n != 0)
	{
		int sum = 0;
		while(n >= 3)
		{
			n -= 3;
			sum++;
			n++;
		}
		if(n == 2)
		{
			sum++;
			n = 0;
		}
		printf("%d\n",sum);
	}
	return 0;
}
