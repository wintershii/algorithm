#include<stdio.h>

typedef struct good{
	char name[20];
	double price;
	int num;
}good;

int main()
{
	int n;
	scanf("%d",&n);
	good g[101];
	double sum = 0;
	for(int i = 0; i < n; i++)
	{
		scanf("%s %lf %d",g[i].name,&g[i].price,&g[i].num);
		sum += g[i].price * g[i].num * 1.0;
	}
	printf("%lf",sum);
	return 0;
}
