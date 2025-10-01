import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FrankensteinProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ankush bhai Enter number : ");
        int noOfInput = sc.nextInt();
        String needPotion = "";
        HashMap<String,ArrayList<ArrayList<String>>> allPotion = new HashMap<>();
        for(int i = 0;i<=noOfInput;i++){
            if(i==noOfInput){
                needPotion = sc.next();
                break;
            }
            String currentPotion = sc.next();
            String currPotionName = "";
            char currCh = ' ';
            ArrayList<String> currInredients = new ArrayList<>();
            StringBuilder currItem = new StringBuilder();
            for(int len = 0;len<currentPotion.length();len++){
                currCh = currentPotion.charAt(len);
                if(currCh=='='){
                    currPotionName = currItem.toString();
                    currItem.setLength(0);
                }else if(currCh == '+'){
                    currInredients.add(currItem.toString());
                    currItem.setLength(0);
                }else{
                    currItem.append(currCh);
                }
            }
            if(currItem.length()>0){
                currInredients.add(currItem.toString());
                currItem.setLength(0);
            }

            if(allPotion.containsKey(currPotionName)){
                ArrayList<ArrayList<String>> arl = allPotion.get(currPotionName);
                arl.add(currInredients);
                allPotion.put(currPotionName, arl);
            }else{
                ArrayList<ArrayList<String>> arl = new ArrayList<>();
                arl.add(currInredients);
                allPotion.put(currPotionName,arl);
            }
        }

        HashMap<String,Integer> dp = new HashMap<>();
        int minOrb = findOrb(needPotion,dp,allPotion);
        System.out.println(minOrb);

    }
    public static int findOrb(String curr,HashMap<String,Integer> map,HashMap<String,ArrayList<ArrayList<String>>> allPotion){
        if(!allPotion.containsKey(curr)) return 0;
        ArrayList<ArrayList<String>> arl = allPotion.get(curr);
        int orbs = Integer.MAX_VALUE;

        for(int i =0;i<arl.size();i++){
            int preOrb = 0;
            ArrayList<String> currList = arl.get(i);
            for(int j = 0;j<currList.size();j++){
                String itemName =currList.get(j);
                if(!allPotion.containsKey(itemName)){
                    preOrb += 0;
                }
                else if(map.containsKey(itemName)){
                    preOrb += map.get(itemName);
                }
                else{
                   preOrb += findOrb(itemName, map, allPotion);
                }
            }
            if(orbs>preOrb+currList.size()) orbs = preOrb+currList.size();
        }
        orbs-=1;
        map.put(curr,orbs);
        return orbs;
    }
} 
