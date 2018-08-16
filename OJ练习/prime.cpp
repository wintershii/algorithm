#include<stdio.h>
#include<math.h>

int prime(int a)
{
	if(a == 1)
	{
		return 0;
	}
	for(int i = 2; i <= sqrt(a); i++)
	{
		if(a % i == 0)
			return 0;
	}
	return 1;
}

int main()
{
	int a;
	scanf("%d",&a);
	int flag = prime(a);
	if(flag == 0)
		printf("not prime\n");
	else
		printf("prime\n");
	return 0;
}
