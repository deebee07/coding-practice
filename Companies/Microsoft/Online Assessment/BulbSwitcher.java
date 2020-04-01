//https://leetcode.com/problems/bulb-switcher-iii/submissions/
//https://leetcode.com/discuss/interview-question/502549/microsoft-oa-light-bulb-switcher
class Solution {
    public int numTimesAllBlue(int[] light) {
            int rightMostLight = 0;
            int blueMoments = 0;
            int onLights = 0;
            
            for(int index = 0; index < light.length; index++){
                rightMostLight = Math.max(rightMostLight, light[index]);
                onLights++;
                
                if(rightMostLight == onLights){
                    blueMoments++;
                }
            }
            
            
            return blueMoments;
    }
    }