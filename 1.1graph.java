/* 1.1. Graph, Topological, Union Find */

// 1. Graph
// (1) Undirected Graph :: Use 2D matrix / Map
class UnGraph {
	Map<String, Set<String>> graph;
	UnGraph() {
		graph = new HashMap<>();
	}
	void addEdge(int u, int v) {
		graph.putIfAbsent(u, new HashSet<>());
		graph.putIfAbsent(v, new HashSet<>());
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
}

// (2) Directed Graph
class DiGraph {
	Map<String, Set<String>> graph;
	DiGraph() {
		graph = new HashMap<>();
	}
	void addEdge(int u, int v) { // u -> v
		graph.putIfAbsent(u, new HashSet<>());
		graph.get(u).add(v);
	}
}


// 2. Topological :: Directed Graph; needs number of income edges/
// EX. prerequisite courses; Course Schedule
class Graph {
	Map<String, Integer> incomings;
	Map<String, Set<String>> outgoings;
	Graph() {
		incomings = new HashMap<>();
		outgoings = new HashMap<>();
	}
	void addEdge(int u, int v) { // u -> v
		outgoings.putIfAbsent(u, new HashSet<>());
		if(!outgoings.get(u).contains(v)) {
			outgoings.get(u).add(v);
			incomings.put(v, incomings.getOrDefault(v, 0) + 1);
		}
	}
}


// 3. Union Find :: union/ find func
class UnionFind {
	int[] parents; 
	int[] ranks;
	int island;

	UnionFind(int n) {
		parnets = new int[n];
		ranks = new int[n];
		island = n;
	}

	boolean union(int u, int v) {
		int parent_u = find(u);
		int parent_v = find(v);
		if(parent_u == parent_v) {
			return false;
		}

		island--;
		if(ranks[parent_u] < rank[parent_v]) {
			rank[parent_v] += rank[parent_u];
			parents[parent_u] = parent_v;
		}else {
			rank[parent_u] += rank[parent_v];
			parents[parent_v] = parent_u;
		}
	}

	int find(int x) {
		if(parents[x] != x) {
			parents[x] = find(parents[x]); 
		}
		return parents[x];
	}
}


























