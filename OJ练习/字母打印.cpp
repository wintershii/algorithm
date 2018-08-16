#include<stdio.h>
#include<math.h> 

#define PI 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825170679
int main()
{
	long r;
	scanf("%ld",&r);
	double s = PI*r*r*1.0;
	printf("%.7lf",s);
}
