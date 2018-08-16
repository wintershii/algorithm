#include<stdio.h>
#include<stdlib.h>

int compare(const void *a,const void *b)
{
	return -((*(int *)a) - (*(int *)b));
}

int main()
{
	int n;
	int num[1000];
	scanf("%d",&n);
	for(int i = 0; i < n; i++)
		scanf("%d",&num[i]);
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int l,r,k;
		scanf("%d %d %d",&l,&r,&k);
		int num2[1000];
		for(int i = l-1,j = 0; i < r; i++,j++)
			num2[j] = num[i];
		qsort(num2,r-l+1,sizeof(int),compare);
		printf("%d\n",num2[k-1]);
	}
	return 0;
}
