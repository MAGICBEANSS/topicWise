package org.dsa.topics.recursion;

public class FrogJump {
  /*  public static void main(String[] args) {
        int[] energy = {10,20,30,10};
        int n = energy.length;
        int energyConsumed = 0;
        int minCost = findMinEnergyPath(energy,n,0,energyConsumed,new ArrayList<>(),Integer.MAX_VALUE );
        System.out.println(minCost);
    }

    private static Integer findMinEnergyPath(int[] energy, int n, int i, int lastweight,int totalEnergyConsumed,List<Integer> path , Integer minCost) {
        if(i>=n) return Integer.MAX_VALUE;
        if(i==(n-1)) {
            path.add(i);
            minCost = Math.min(minCost,energyConsumed+energy[i]);
            path.remove(path.size()-1);
            return minCost;
        }
        path.add(i);
        int min1 = findMinEnergyPath(energy,n,i+1,Math.abs(energyConsumed+energy[i]),path,minCost);
        int min2 = findMinEnergyPath(energy,n,i+2,energyConsumed+energy[i],path,minCost);
        path.remove(path.size()-1);
        minCost = Math.min(min1,min2);
        return minCost;

    }*/
}
