/*
https://leetcode.com/problems/car-pooling/

Sort the trips array by start location;
Use a PriorityQueue to store the trips, order by ending location.
Loop through the trips array, for each start location, keep polling out the arrays with correpoinding end location <= current start location, for each polled out array, add the corresponding passengers to capacity; deduct passengers at current start location from capacity, if capacity < 0, return false.
Repeat 3 till end, if never encounter false, return true.
*/

public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
    for (int[] trip : trips) {
        while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) // any passengers need to get off?
            capacity += pq.poll()[0]; // more capacity as passengers out.
        capacity -= trip[0]; // less capacity as passengers in.
        if (capacity < 0) return false; // not enough capacity.
        pq.offer(trip); // put into PriorityQueue the infomation at current location.
    }
    return true;
}


// The idea is very simple.
// Step1: Compute the total number of people at every given destinations. At start add the number of passanger and at end subtract the number of passangers.

// Step 2: Add the net number of people at very position. If at any point the people is over capacity return false.

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
		int[] count = new int[1001];
		for (int i = 0; i < trips.length; i++) {
			count[trips[i][1]] += trips[i][0];
			count[trips[i][2]] -= trips[i][0];
		}

		int curr = 0;
		for (int i : count) {
			curr += i;
			if (curr > capacity) {
				return false;
			}
		}

		return true;
	}
}


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return true;
        int[] map = new int[1001];
        for (int[] t : trips) {
            map[t[1]] += t[0];
            map[t[2]] -= t[0];
        }
        for (int num : map) {
            capacity -= num;
            if (capacity < 0) return false;
        }
        return true;
    }
}


