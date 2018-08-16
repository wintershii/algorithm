#include<stdio.h>

int main()
{
	int a[3][3];
	for(int i = 0; i < 3; i++)
	{
		for(int j = 0; j < 3; j++)
		{
			scanf("%d",&a[i][j]);
		}
	}
	int sum1 = 0,sum2 = 0;
	sum1 = a[0][0] + a[1][1] + a[2][2];
	sum2 = a[2][0] + a[1][1] + a[0][2];
	printf("%d %d\n",sum1,sum2);
 } 
