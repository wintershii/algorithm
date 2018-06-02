#include<stdio.h>

struct note{
	int x;
	int y;
};

char map[20][21];

int getnum(int i,int j)
{
	int sum,x,y;
	sum = 0;
	
	x = i;
	y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G');
			sum++;
		x--;
	}
	x = i;
	y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G');
			sum++;
		x++;
	}
	x = i;
	y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G');
			sum++;
		y--;
	}
	x = i;
	y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G');
			sum++;
		y++;
	}
	return sum;
}

int main()
{
	struct note que[401];
	int head,tail;
	int book[20][20] = {0};
	int i,j;
	int sum,max = 0;
	int mx,my,startx,starty,tx,ty;
	int m,n,k;
	int next[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};
	scanf("%d %d %d %d",&m,&n,&startx,&starty);
	for(i = 0; i <= n-1; i++)
		scanf("%s",map[i]);
	head = 1;
	tail = 1;
	que[tail].x = startx;
	que[tail].y = starty;
	tail++;
	book[startx][starty] = 1;
	max = getnum(startx,starty);
	mx = startx;
	my = starty;
	while(head < tail)
	{
		for(k = 0; k <=3; k++)
		{
			tx = que[head].x + next[k][0];
			ty = que[head].y + next[k][1];
			
			if(tx < 0 || tx > n - 1 || ty < 0|| ty > m-1)
				continue;
			if(map[tx][ty] == '.' && book[tx][ty] == 0)
			{
				book[tx][ty] = 1;
				que[tail].x = tx;
				que[tail].y = ty;
				tail++;
				sum = getnum(tx,ty);
				if(sum > max)
				{
					max = sum;
					mx = tx;
					my = ty;
				 } 
			}
		}
		head++;
	}
	printf("将炸弹放在(%d %d)处,可以消灭%d 个敌人",mx,my,max);
	return 0;
} 











