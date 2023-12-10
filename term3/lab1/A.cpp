#include <algorithm>
#include <cstring>
#include <deque>
#include <iostream>
 
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
 
void findHamiltonianCycle(bool **adjacencyMatrix, int n) {
  deque<int> vertices;
  for (int v = 0; v < n; v++) {
    vertices.push_back(v);
  }
 
  for (int k = 0; k < n * (n + 1); k++) {
    if (!adjacencyMatrix[vertices[0]][vertices[1]]) {
      int i = 2;
      while (i < n - 1 && (!adjacencyMatrix[vertices[0]][vertices[i]] ||
                           !adjacencyMatrix[vertices[1]][vertices[i + 1]])) {
        i++;
      }
 
      reverse(vertices.begin() + 1, vertices.begin() + i + 1);
    }
 
    vertices.push_back(vertices[0]);
    vertices.pop_front();
  }
 
  for (int vertex : vertices) {
    cout << vertex + 1 << " ";
  }
  cout << endl;
}
 
void printAdjacencyMatrix(bool **adjacencyMatrix, int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      std::cout << (adjacencyMatrix[i][j] ? "1 " : "0 ");
    }
    std::cout << std::endl;
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
      if (row[j] == '1') {
        graph->addEdge(i, j);
      }
    }
  }
  findHamiltonianCycle(graph->adjacencyMatrix, graph->getV());
  cout << endl;
  return 0;
}