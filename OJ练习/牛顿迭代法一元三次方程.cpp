#include<stdio.h>
#include<math.h>
float han(float a,float *b)
{
	return *b*pow(a,3)+*(b+1)*pow(a,2)+*(b+2)*a+*(b+3);
}
float ha(float a,float *b)
{
	return *b*pow(a,2)*3+*(b+1)*a*2+*(b+2);
}
float num(float a,float b[4])
{
     return fabs(han(a,b)/ha(a,b))<1e-07?a:num(a-=han(a,b)/ha(a,b),b);
} 
int main()
{
	float a[4],x;
	scanf("%f %f %f %f %f",&a[0],&a[1],&a[2],&a[3],&x);
	printf("%f",num(x,a));
 } 
