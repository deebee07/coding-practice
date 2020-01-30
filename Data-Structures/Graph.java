class Result {
    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. Vertex origin
     */
​
    /*
     * For your reference:
     *
     * Vertex {
     *     Character id;
     *     List<Vertex> edges;
     * }
     *
     */    
    
    
    public static String bfs(Vertex origin) {
        String res = "";
        if(origin == null) return res;
        
        //Init queue & seen set
        Queue<Vertex> q = new LinkedList<>();
        HashSet<Character> seen = new HashSet<>();
        
        //Add origin vertex to queue and seen set
        q.add(origin);
        seen.add(origin.id);
        //init "current" vertex var
        Vertex curr;
        //while queue is not empty
        while(q.size() > 0) {
            //pop vertex from queue
            curr = q.remove();
            //add current vertex id to res string
            res += curr.id;
        
            //loop through edges of current vertex
            for(Vertex edge: curr.edges) {
                //check if edge id is seen
                if(!seen.contains(edge.id)) {
                    //add edge to queue & edge id to seen set
                    q.add(edge);
                    seen.add(edge.id);
                }
            }
        }
        return res;
    }
​
}