/*
https://leetcode.com/problems/the-skyline-problem/
https://www.youtube.com/watch?v=GSBLe8cKu0s

Let's say you want to implement a dictionary and print it in alphabetical order, you can use a combination of a TreeMap and a TreeSet:

TreeMap class extends AbstractMap and it implements NavigableMap interface. 
By default, TreeMap stores key-value pairsin a sorted ascending order(based on the key). 
The retrieval speed of an element out of a TreeMap is fast, even in a TreeMap with a large number of elements. 
Hence, TreeMap is the best candidate for a situation where one needs to store a large number of sorted elements in the form of key-value pairs and their fast access.
*/

//Solution 1: TreeMap
class Point{
    int axis, height;
    boolean isStart;
    Point( int axis, int height, boolean isStart ) {
        this.axis = axis;
        this.height = height;
        this.isStart = isStart;
    }
}

class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> cornerPoints = new ArrayList();
        List<List<Integer>> ans = new ArrayList();

        for( int[] building : buildings ) {
            cornerPoints.add( new Point(building[0], building[2], true) );
            cornerPoints.add( new Point(building[1], building[2], false) );
        }
        Collections.sort(cornerPoints, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                if(p1.axis != p2.axis)
                    return p1.axis - p2.axis;
                else
                    return (p1.isStart? -p1.height:p1.height) - (p2.isStart? -p2.height:p2.height);
            }
        });
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0,1);
        int prevMax = 0;
        for( Point p : cornerPoints ) {
            if(p.isStart)
                tm.put( p.height, tm.getOrDefault(p.height, 0) + 1 );
            else {
                if(tm.get(p.height) == 1) tm.remove(p.height);
                else tm.put(p.height, tm.get(p.height) - 1);
            }
            int currMax = tm.lastKey();
            if(currMax != prevMax) {
                ans.add(Arrays.asList(p.axis, currMax));
                prevMax = currMax;
            }
        }
        return ans;
    }
}



// Solution 2: 
class Solution {
    private PriorityQueue<Event> queue = new PriorityQueue<Event>((a, b) -> b.height - a.height);
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;      
        ArrayList<Event> events = new ArrayList<Event>();
        
        for (int i = 0; i < n; ++i) {
            int[] b = buildings[i];
            Event entering = new Event(b[0], b[2], 1);
            Event leaving = new Event(b[1], b[2], -1, entering);
            events.add(entering);
            events.add(leaving);
        }
        
        events.sort((e1, e2) -> {
            return e1.x == e2.x ? e2.height * e2.type - e1.height * e1.type : e1.x - e2.x; 
        });
        
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
       for (Event e :events) {
           if (e.type == 1) {
               if (this.queue.isEmpty() || e.height > this.queue.peek().height) {
                   List<Integer> temp = new ArrayList<Integer>();
                   temp.add(e.x);
                   temp.add(e.height);
                   ans.add(temp);
               }
               this.queue.offer(e);
           } else {
               this.queue.remove(e.enteringEvent);
               if (this.queue.isEmpty() || e.height  > this.queue.peek().height) {
                   List<Integer> temp = new ArrayList<Integer>();
                   temp.add(e.x);
                   if (this.queue.isEmpty()) {
                       temp.add(0);
                   } else {
                       temp.add(this.queue.peek().height);
                   }
                   ans.add(temp);
               }
           }
       }                
       return ans;
        
    }
}

class Event {
    public int x;
    public int height;
    public int type;
    public Event enteringEvent;
    
    public Event(int x, int h, int type) {
        this.x = x;
        this.height = h;
        this.type = type;
    }
    
    public Event(int x, int h, int type, Event event) {
        this(x, h, type);
        this.enteringEvent = event;
    }
}
