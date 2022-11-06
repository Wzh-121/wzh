#include<stdio.h>

int Max(int *a,int n) {

	int max = a[0];
	int count = 0;

	for (int i = 0; i < n; ) {

		int sum = 0;

		for (int j = i; j < n - count; j++) {

			sum += a[j];	

		}
		if (max < sum) {

			max = sum;

		}

		count++;

		if (count == n) {

			i++;
			count = 0;

		}
	}

	return max;
}

int main()
{
	int n;
	int max;
	int count = 0;
	int a[100];
	scanf_s("%d", &n);

	for (int k = 0; k < n; k++) {

		scanf_s("%d", &a[k]);

		if (a[k] < 0) {

			count++;

		}
	}
	if (count != n) {

		max = Max(a, n);

	} 
	else {

		max = 0;

	}
	
	printf("×î´ó×Ö¶ÎºÍ = %d", max);

}