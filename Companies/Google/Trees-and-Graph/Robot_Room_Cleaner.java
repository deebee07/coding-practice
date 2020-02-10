// track the cells the robot has cleaned, start a index pair (i, j) from (0, 0). When go up, i-1; go down, i+1; go left, j-1; go right: j+1.
// Also use DIR to record the current direction of the robot
// https://leetcode.com/problems/robot-room-cleaner/
    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        Set<String> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<String> set, int i, 
    			int j, int cur_dir) {
    	String tmp = i + "->" + j;
    	if(set.contains(tmp)) {
            return;
        }
        
    	robot.clean();
    	set.add(tmp);

    	for(int n = 0; n < 4; n++) {
        // the robot can to four directions, we use right turn
    		if(robot.move()) {
    			// can go directly. Find the (x, y) for the next cell based on current direction
    			int x = i, y = j;
    			switch(cur_dir) {
    				case 0:
    					// go up, reduce i
    					x = i-1;
    					break;
    				case 90:
    					// go right
    					y = j+1;
    					break;
    				case 180:
    					// go down
    					x = i+1;
    					break;
    				case 270:
    					// go left
    					y = j-1;
    					break;
    				default:
    					break;
    			}

    			backtrack(robot, set, x, y, cur_dir);
                       // go back to the starting position
			robot.turnLeft();
    			robot.turnLeft();
    			robot.move();
    			robot.turnRight();
    			robot.turnRight();

    		} 
    		// turn to next direction
    		robot.turnRight();
    		cur_dir += 90;
    		cur_dir %= 360;
    	}

    }


    /**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

public void cleanRoom(Robot robot) {
    clean(robot, 0, 0, 0, new HashSet<>());
}

private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
    // Clean current cell.
    robot.clean();
    visited.add(x + " " + y);
    
    for (int i = 0; i < 4; i++) {
        int nx = x + directions[curDirection][0];
        int ny = y + directions[curDirection][1];
        if (!visited.contains(nx + " " + ny) && robot.move()) {
            clean(robot, nx, ny, curDirection, visited);
        }
        // Change orientation.
        robot.turnRight();
        curDirection++;
        curDirection %= 4;
    }
    
    // Move backward one step while maintaining the orientation.
    robot.turnRight();
    robot.turnRight();
    robot.move();
    robot.turnRight();
    robot.turnRight();
}
}