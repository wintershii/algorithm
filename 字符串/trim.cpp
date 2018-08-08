#include<stdio.h>
#include<string.h>

void move(int n,char str[])
{
	int len = strlen(str);
	for(int i = n; i < len; i++)
	{
		str[i] = str[i+1];
	}
}

void trim(char str[])
{
	int len = strlen(str);
	for(int i = 0; str[i] == ' ';)
	{
		move(i,str);
	}
	int len2 = strlen(str);
	for(int i = len2-1; str[i] == ' '; i--)
	{
		str[i] = '\0';
	}
}

int main()
{ 
	char str[1000];
	gets(str);
	trim(str);
	printf("%s",str);
	return 0;
} 
