
/**
	KMP模式匹配算法+递归搜索
	与朴素字符串匹配相比，取消了主串索引i的回溯，并且
	通过求next数组使子串索引j有规律回溯
	大大提高了效率 
*/

#include<stdio.h>
#include<string.h>

void get_next(char son[],int next[])
{
	int i,j;
	int len = strlen(son);
	i = 0;
	j = -1;
	next[0]=0;
	while(i < len)
	{
		if(j == -1 || son[i] == son[j])
		{
			i++;
			j++;
			next[i] = j + 1;
		}
		else
			j = next[j] -1;
	}
}

void KMP(char str[],char son[],int pos)
{
	int i = pos;	//主串中的位置索引 
	int j =-1;		//子串中的位置索引
	
	int len1 = strlen(str);
	int len2 = strlen(son);
	
	int next[1000];	//next数组
	get_next(son,next);
	
	while(i < len1 && j <len2)
	{
		if(j == -1 || str[i] == son[j])
		{
			i++;
			j++;
		}
		else
		{
			j = next[j] - 1;
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
		KMP(str,son,i-len2+1);
	}
}

int main()
{
	char str[1000];
	char son[1000];
	gets(str);
	gets(son);
	
	KMP(str,son,0);
	
	return 0;
} 
