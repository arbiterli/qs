#include <iostream>
using namespace std;
void sort(int *a, int len) {
	int i, j, t;
	for(i = 0; i < len - 1; ++i) {
		for(j = i + 1; j < len; ++j) {
			if(a[i] > a[j]) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
	}
}
int main() {
    int a[5] = {5, 4, 3, 2, 1}, i;
    sort(a, 5);
    for(i = 0; i < 5; ++i) {
    	cout << a[i] << ' ';
    }
    cout << endl;
    return 0;
}
