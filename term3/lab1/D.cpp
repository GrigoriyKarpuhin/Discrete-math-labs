#include <algorithm>
#include <cstring>
#include <iostream>
#include <vector>
 
using namespace std;
 
class Graph {
public:
  explicit Graph(int V) : V(V) {
    adjacencyMatrix = new bool *[V];
    for (int i = 0; i < V; i++) {
      adjacencyMatrix[i] = new bool[V];
      memset(adjacencyMatrix[i], false, V * sizeof(bool));
    }
  }
 
  void addEdge(int source, int destination) const {
    adjacencyMatrix[source][destination] = true;
    adjacencyMatrix[destination][source] = true;
  }
 
  [[nodiscard]] bool isEdge(int source, int destination) const {
    return adjacencyMatrix[source][destination];
  }
 
  [[nodiscard]] int getV() const { return V; }
 
  bool **adjacencyMatrix;
  int V;
};
 
void printAdjacencyMatrix(bool **adjacencyMatrix, int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      std::cout << (adjacencyMatrix[i][j] ? "1 " : "0 ");
    }
    std::cout << std::endl;
  }
}
 
void DFSUtil(int v, vector<bool> &visited, vector<int> &path,
             bool **adjacencyMatrix, int n) {
  visited[v] = true;
  for (int i = 0; i < n; ++i) {
    if (adjacencyMatrix[v][i] && !visited[i]) {
      DFSUtil(i, visited, path, adjacencyMatrix, n);
    }
  }
  path.push_back(v);
}
 
void findTournamentCycle(bool **adjacencyMatrix, int n) {
  vector<bool> visited(n, false);
  vector<int> path;
  for (int i = 0; i < n; ++i) {
    path.clear();
    visited.assign(n, false);
    DFSUtil(i, visited, path, adjacencyMatrix, n);
    std::reverse(path.begin(), path.end());
    if (path.size() == n && adjacencyMatrix[path.back()][i]) {
      break;
    }
  }
  for (int vertex : path) {
    cout << vertex + 1 << " ";
  }
}
 
int main() {
  int n;
  cin >> n;
  auto *graph = new Graph(n);
  for (int i = 1; i < n; i++) {
    string row;
    cin >> row;
    if (row.length() == 0)
      continue;
    for (int j = 0; j < i; j++) {
      graph->adjacencyMatrix[i][j] = row[j] == '1';
      graph->adjacencyMatrix[j][i] = !graph->adjacencyMatrix[i][j];
    }
  }
  findTournamentCycle(graph->adjacencyMatrix, n);
  cout << endl;
  return 0;
}