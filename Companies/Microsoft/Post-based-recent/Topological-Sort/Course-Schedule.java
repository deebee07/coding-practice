/*
https://leetcode.com/tag/topological-sort/
https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

https://www.youtube.com/watch?v=rG2-_lgcZzo

DIRECTED GRAPH
*/



public class Solution {
    // The basic idea is to use Topological algorithm: put NODE with 0 indgree into the queue, then make indegree of NODE's successor dereasing 1. Keep the above steps with BFS.
    
    // Finally, if each node' indgree equals 0, then it is validated DAG (Directed Acyclic Graph), which means the course schedule can be finished.

    /*
    We are give prerequisites and numCourses
    if numCourses == 0 || prerequisites.length == 0 return true
    int inDegree = new int[numCourses];

    for (int i=0; i < prerequisites.length; i++){
        inDegree[prerequisites[i][0]]++;
    }

    Queue<Integer> queue = new LinkedList<Integer>();

    for (int i =0; i<numCourses;i++){
        if (indegree[i] == 0) {
            queue.add(i);
        }
    }

    int noPreq = queue.size();

    while(!queue.isEmpty()) {
        int prerequisite = queue.remove(); // already finished the course
        for(int i =0;i<prerequisites.length;i++){
            if (prerequisites[i][1]==prequisite) {
                indegree[prerequisite[i][0]]--;
                if (indegree[prerequisite[i][0]] == 0) {
                    noPreq++;
                    queue.add(i);
                }

            }
        }
    }
    return noPreq == numCourses
    */
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;
    
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    
    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0)
                queue.add(i);
    
        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();  
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) { 
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
    
        return (canFinishCount == numCourses);    
    }
    }
    