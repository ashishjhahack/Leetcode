class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCost = 0;

        int start = 0;
        int tank = 0;

        for(int i = 0; i<gas.length; i++){
            totGas += gas[i]; // total gas available in all station
            totCost += cost[i];  // total cost available in all station

            tank += gas[i] - cost[i];   // check the curr tank

            // if tank b/m -ve then current start cannot be the answer
            if(tank < 0){
                start = i+1; // if -ve, then try next station
                tank = 0;  // reset the tank = 0
            }
        }
        if(totGas < totCost) return -1;   // instantly return -1
        return start;
    }
}