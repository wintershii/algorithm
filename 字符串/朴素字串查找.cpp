#include<stdio.h>
#include<string.h>

void search(char str[], char son[],int pos)
{
	int index;
	int i = pos;	//主串中的位置下标 
	int j = 0;	//字串中的位置下标
	int len1 = strlen(str);
	int len2 = strlen(son);
	
	while(i < len1 && j < len2)
	{
		if(str[i] == son[j])
		{
			i++;
			j++;
		}
		else
		{
			i = i - j + 1;
			j = 0;
		}
	}
	if(j = len2)
	{
		if(pos >= len1-len2 || i >= len1)
		{
			printf("不存在子串了\n");
			return;
		}
		printf("查找到子串，起始索引在主串的%d处\n",i-len2);
		search(str,son,i-len2+1);				//递归继续搜索 
	}
}

int main()
{
	char str[1000];
	char son[1000];
	gets(str);
	gets(son); 
	search(str,son,0);
	return 0;
}
