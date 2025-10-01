// Leetcode 1854. Maximum Population Year

//You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

//The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

//Return the earliest year with the maximum population.

//  TC = O(n+101)

//  SC = O(1)
// package LeetCode.Array.PrefixSum;
class maximumPopulationYear{
    public static void main(String[] args){

    }
    public int maximumPopulation(int[][] logs) {
        int[] popu = new int[101];
        for (int[] log : logs) {
            int birthDate = log[0];
            int deathDate = log[1];
            popu[birthDate - 1950] += 1;
            popu[deathDate - 1950] -= 1;
        }

        int max = popu[0];
        int maxYear = 0;
        for(int i = 1;i<101;i++){
            popu[i] += popu[i-1];
            if(popu[i]>max){
                maxYear = i;
                max = popu[i];
            }
        }
        return maxYear + 1950;
    }
}