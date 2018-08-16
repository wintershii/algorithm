#include<stdio.h>
#include<string.h>

void solve(char str[])
{
	int len = strlen(str);
	for(int i = 0; i < len; i++)
	{
		if((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z'))
		{
			str[i] += 1;
		}
	}
}

int main()
{
	char str[1000];
	gets(str);
	solve(str);
	printf("%s",str);
}
