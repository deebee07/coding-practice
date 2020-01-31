/*
https://leetcode.com/problems/day-of-the-week/
*/

// import java.time.*;
// class Solution {
//     public String dayOfTheWeek(int day, int month, int year) {
//         String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//         int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
//         return weeks[weekOfDay];
//     }
// }

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; 
        int[] daysOfMonth = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; 
        
        int base = 5 + 
            day + 
            daysOfMonth[month-1] + 
            (year-1971)*365 + 
            ((year-1)-1972)/4 + 
            (year%4==0&&month>2? 1 : 0);

        return days[base%7]; 
    }
    
}