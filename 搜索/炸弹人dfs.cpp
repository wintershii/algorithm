#include<stdio.h>
char map[20][21];
int book[20][20];
int mx,my,m,n,max;

int getnum(int i,int j)
{
	int x,y,sum = 0;
	x = i; y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G')
			sum++;
		x--;
	}
	x = i; y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G')
			sum++;
		x++;
	}
	x = i; y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G')
			sum++;
		y--;
	}
	x = i; y = j;
	while(map[x][y] != '#')
	{
		if(map[x][y] == 'G')
			sum++;
		y++;
	}
	return sum;
}

void dfs(int x,int y)
{
	int k,tx,ty;
	int next[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
	int num = getnum(x,y);
	if(num > max)
	{
		max = num;
		mx = x;
		my = y;
	}
	for(k = 0; k < 3; k++)
	{
		tx = x + next[k][0];
		ty = y + next[k][1];
		
		if(tx < 0 || tx > m || ty < 0 || ty > n)
			continue;
		if(map[tx][ty] == '.' && book[tx][ty] == 0)
		{
			book[tx][ty] = 1;
			dfs(tx,ty);
		}
	}
	return;
}

int main()
{
	int startx,starty;
	int i,j;
	scanf("%d %d %d %d",&m,&n,&startx,&starty);
	for(i = 0; i < m; i++)
		scanf("%s",map[i]);
	book[startx][starty] = 1;
	max = getnum(startx,starty);
	mx = startx;
	my = starty;
	dfs(startx,starty);
	printf("%d  (%d  %d)\n",max,mx,my);
	return 0;
} 
