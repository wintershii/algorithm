#include<stdio.h>
#include<string.h>

int main()
{
	char s[7000] = "0";
	int n;
	scanf("%d",&n);
	while(n--)
	{
		int len = strlen(s);
		for(int i = 0; i < len; i++)
		{
			if(s[i] == '0')
				s[i] = '1';
			else if(s[i] == '1'){
				for(int j = len-1; j >= i; j--)
				{
					s[j+1] = s[j];
				}
				s[i] = '0';
				i++;
				len++;
			}
		}
	}
	printf("%s",s);
	return 0;
}
