#include<stdio.h>
#include<math.h>

int main()
{
	double a,b,c;
	while(~scanf("%lf %lf %lf",&a,&b,&c))
	{
		if(a <= 0 || b <= 0 || c <= 0)
		{
			printf("It can not be created a triangle.\n");
			continue;
		}
		double s = (a+b+c)/2.0;
		double l = a+b+c;
		double re = sqrt(s*(s-a)*(s-b)*(s-c));
		printf("The area is:%.3f.\n",re);
		printf("The perimeter is %.3f.\n",l);
	}	
	return 0;
}
