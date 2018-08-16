#include<stdio.h>
#include<string.h>
int main()
{
	int re = 0;
	int a,b;
	char sum[100];
	char m,n;
	while(~scanf("%d%c%d%c%s",&a,&m,&b,&n,sum))
	{
		int num = 0;
		if(sum[0] == '?')
			continue;
		else
		{
			for(int i = 0; i < strlen(sum); i++)
			{
				num *= 10;
				num += sum[i]-'0';
			}
		}
		if(m == '+')
		{
			if(a + b == num)
				re++;
		}
		if(m == '-')
		{
			if(a - b == num)
				re++;
		}
	}
	printf("%d",re);
}
