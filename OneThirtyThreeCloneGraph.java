/**
Companies
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
/ Fill a map with all nodes so we can easily reference them and copy them.
*/

class Solution {
    
    
    public void fillMap(Node node, Map<Integer, Node> oMap, Map<Integer, Node> cMap) {
        
        oMap.put(node.val, node);
        cMap.put(node.val, new Node(node.val));
        
        for (Node n : node.neighbors) {
            if (!oMap.containsKey(n.val))
                fillMap(n, oMap, cMap);
        }
        return;
    }
    
    
    public Node cloneGraph(Node node) {
        
        if (node == null)
            return null;
        
        Map<Integer, Node> oMap = new HashMap<Integer, Node>();
        Map<Integer, Node> cMap = new HashMap<Integer, Node>();
        
        fillMap(node, oMap, cMap);
        
        for (int i = 1; i <= oMap.size(); i++) {
            
            Node oCur = oMap.get(i);
            Node cCur = cMap.get(i);
            
            for (Node n : oCur.neighbors) {
                cCur.neighbors.add(cMap.get(n.val));
            }
            
        }
        
        
        return cMap.get(node.val);
        
    }
}
