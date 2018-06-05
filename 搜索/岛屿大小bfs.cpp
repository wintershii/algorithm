#include<stdio.h>

struct node{
	int x;
	int y;
};

int main()
{
	struct node que[2501];
	int head,tail;
	int map[51][51];
	int book[51][51] = {0};
	int i,j,k,sum,max = 0,m,n,startx,starty,tx,ty;
	int next[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};
	scanf("%d %d %d %d",&m,&n,&startx,&starty);
	for(i = 1; i <= m; i++)
		for(j = 1; j <= n; j++)
			scanf("%d",&map[i][j]);
	head = 1;
	tail = 1;
	que[tail].x = startx;
	que[tail].y = starty;
	tail++;
	book[startx][starty] = 1;
	sum = 1;
	while(head < tail)
	{
		for(k = 0; k <= 3; k++)
		{
			tx = que[head].x + next[k][0];
			ty = que[head].y + next[k][1];
			if(tx < 0 || tx > m || ty < 0 || ty > n)
				continue;
			if(map[tx][ty] > 0 && book[tx][ty] == 0)
			{
				sum++;
				book[tx][ty] = 1;
				que[tail].x = tx;
				que[tail].y = ty;
				tail++;
			}
		}
		head++;
	}
	printf("%d",sum);
	return 0;
}
