#include<stdio.h>
#include<string.h>

void ToLower(char str[])
{
	int len = strlen(str);
	for(int i = 0; i < len; i++)
	{
		if(str[i] >= 'A' && str[i] <= 'Z')
			str[i] -= ('A'-'a');
	}
}

void ToUpper(char str[])
{
	int len = strlen(str);
	for(int i = 0; i < len; i++)
	{
		if(str[i] >= 'a' && str[i] <= 'z')
			str[i] += ('A'-'a');
	}
}

int main()
{
	char str[1000];
	gets(str);
	//ToLower(str);
	ToUpper(str);
	printf("%s",str);
	return 0;
 } 
