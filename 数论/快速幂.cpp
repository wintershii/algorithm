#include<stdio.h>
#define ll long long

ll quick_pow(ll a,ll pow)
{
	ll ans = 1;
	while(pow > 0)
	{
		if(pow & 1)
			ans *= a;
		a *= a;
		pow >>= 1;
	}
	return ans;
}

int main()
{
	ll a,b;
	while(~scanf("%lld %lld",&a,&b))
		printf("%lld",quick_pow(a,b));
	return 0;
} 
