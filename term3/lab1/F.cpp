#include <iostream>
#include <set>
 
using namespace std;
 
void buildTree(const int *P, int n) {
  set<int> V;
  int *arrayDeg = new int[n];
  for (int i = 0; i < n; i++) {
    arrayDeg[i] = 0;
  }
  for (int i = 1; i <= n - 2; i++) {
    arrayDeg[P[i - 1] - 1]++;
  }
  for (int i = 1; i <= n; i++) {
    if (arrayDeg[i - 1] == 0) {
      V.insert(i);
    }
  }
  int u, v;
  int iter = 0;
  while (iter < n - 2) {
    u = P[iter];
    arrayDeg[u - 1]--;
    v = *V.begin();
    cout << u << " " << v << endl;
    iter++;
    V.erase(v);
    if (arrayDeg[u - 1] == 0) {
      V.insert(u);
    }
  }
  cout << *V.begin();
  V.erase(V.begin());
  cout << " " << *V.begin() << endl;
}
 
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int *P = new int[n - 2];
  for (int i = 0; i < n - 2; i++) {
    cin >> P[i];
  }
  buildTree(P, n);
  return 0;
}