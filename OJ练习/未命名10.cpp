#include<stdio.h>
#include<stdlib.h>
typedef struct student{
	char name[20];
	char sex[20];
	int age;
	int gra;
}student;

int compare(const void *a,const void *b)
{
	return ((student *)a)->gra - ((student *)b)->gra;
}

int main()
{
	int n;
	scanf("%d",&n);
	student stu[1001];
	for(int i = 0; i < n; i++)
	{
		scanf("%s %s %d %d",stu[i].name,stu[i].sex,&stu[i].age,&stu[i].gra);
	}
	qsort(stu,n,sizeof(stu[0]),compare);
	for(int i = 0; i < n; i++)
	{
		printf("%s %s %d %d\n",stu[i].name,stu[i].sex,stu[i].age,stu[i].gra);
	}
	return 0;
}
