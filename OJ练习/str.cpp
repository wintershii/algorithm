#include<stdio.h>
#include<string.h>

void judge(char str[])
{
	int a = 0,b = 0, c = 0, d = 0;
	int len = strlen(str);
	for(int i = 0; i < len; i++)
	{
		if((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z') )
			a++;
		else if(str[i] >= '0' && str[i] <= '9')
			b++;
		else if(str[i] == ' ')
			c++;
		else 
			d++;
	}
	printf("%d %d %d %d\n",a,b,c,d);
}

int main()
{
	char str[1000];
	gets(str);
	judge(str);
	return 0;
}
