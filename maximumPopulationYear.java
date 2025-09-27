class maximumPopulationYear{
    public static void main(String[] args){

    }
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
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