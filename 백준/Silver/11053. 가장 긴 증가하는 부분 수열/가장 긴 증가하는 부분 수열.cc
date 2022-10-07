#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>

using namespace std;

int cache[1001];
int lis(int start, const vector<int>& A, int n)
{
	int&ret = cache[start];
	if(ret != -1)
		return (ret);
	ret = 1;
	for	(int next = start + 1; next < n; ++next)
		if(A[start] < A[next])
			ret = max(ret, lis(next, A, n) + 1);
	return (ret);
}

int main(void)
{
	int n;
	int maxLen = 0;
	memset(cache, -1, sizeof(cache));

	cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for (int begin = 0; begin < n; begin++)
	{
		maxLen = max(maxLen, lis(begin, a, n));
	}
	cout << maxLen;
	return (0);
}