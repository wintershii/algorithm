#include<stdio.h>
#include<stdlib.h>

int min = 9999;
int dir[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};

void dfs(int map[][9],int x1,int y1,int x2,int y2,int step,int flag[][9])
{
	if(x1 == x2 && y1 == y2)
	{
		if(step < min)
			min = step;
		return;
	}
	
	for(int i = 0;i < 4; i++)
	{
		int tx = x1 + dir[i][0];
		int ty = y1 + dir[i][1];
		if(map[tx][ty] == 1 || flag[tx][ty] == 1)
			continue;
		if(map[tx][ty] == 0 && flag[tx][ty] == 0)
		{
			flag[tx][ty] = 1;
			dfs(map,tx,ty,x2,y2,step+1,flag);
			flag[tx][ty] = 0;
		}
	}
	return;
}

int main()
{
	int n;
	scanf("%d",&n);
	int map[9][9] = {1,1,1,1,1,1,1,1,1,
 					 1,0,0,1,0,0,1,0,1,
 					 1,0,0,1,1,0,0,0,1,
					 1,0,1,0,1,1,0,1,1,
					 1,0,0,0,0,1,0,0,1,
					 1,1,0,1,0,1,0,0,1,
 					 1,1,0,1,0,1,0,0,1,
					 1,1,0,1,0,0,0,0,1,
					 1,1,1,1,1,1,1,1,1};
	while(n--)
	{
		int x1,y1,x2,y2;
		scanf("%d %d  %d %d",&x1,&y1,&x2,&y2);
		min=9999;
		int flag[9][9] = {0};
		flag[x1][y1] = 1;
		dfs(map,x1,y1,x2,y2,0,flag);
		printf("%d\n",min);
	}
	return 0;
}
