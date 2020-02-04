import java.util.*;

class KnapSack{

    int[] profit = new int[]{10, 5, 20, 7, 6, 18, 2};
    int[] weight = new int[]{2, 3, 5, 7, 1, 4, 1};
    int sackWeight = 15;
    int remainingWeight;

    private static int find_index_of_max_profit_object(double[] profits, double k) {

        //Search for the index of object in an unsorted profit array
        //Index is calculated so that the respective profits and weights are known
        for(int i=0;i<profits.length;i++) {
            if(profits[i] == k)
                return i;
        }
        return -1;
    }

    private double calculate_maximum_profit() {

        //Calculate profit per unit weight of each object
        double[] profitPerWeight = new double[profit.length];
        for(int i=0;i<profit.length;i++) {
            profitPerWeight[i] = (double)profit[i] / weight[i];
        }
        double[] portion_of_object = new double[profitPerWeight.length];

        //Sort the profit per unit weight array to put the object into sack in descending order
        double temp[] = profitPerWeight.clone();
        Arrays.sort(temp);

        for(int j=1;j<=profitPerWeight.length;j++) {
            double val = temp[profit.length - j];
            
            //find jth highest object
            int indexOfNextHighestProfit = find_index_of_max_profit_object(profitPerWeight,val);

            //proceed if sack has some space
            if(sackWeight > 0){
                //calculate amount that remains in sack after adding object
                remainingWeight = sackWeight - weight[indexOfNextHighestProfit]; 

                //Add the entire object into sack if remaining weight >= 0 
                if(remainingWeight >= 0) {

                    //decrement sack capacity and update portion of the object added
                    sackWeight -= weight[indexOfNextHighestProfit];
                    portion_of_object[indexOfNextHighestProfit] = 1;

                }

                //Add only the portion of the object into sack if remaining weight < 0
                else
                {
                    if(remainingWeight < 0) {

                        //calculate the portion of the object to be added and set sack capacity to 0
                        portion_of_object[indexOfNextHighestProfit] = (double)sackWeight/weight[indexOfNextHighestProfit];
                        sackWeight = 0;
                        
                    }
                }
            }

            //discard the object if sack is full
            else
            {
                portion_of_object[indexOfNextHighestProfit] = 0;
            }
        }

        //Calculate total profit of objects added
        double maxProfit = 0;
        for(int k=0;k<portion_of_object.length;k++)
        {
            maxProfit += portion_of_object[k] * profit[k]; 
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        KnapSack ks = new KnapSack();
        System.out.println("The maximum profit is "+ks.calculate_maximum_profit());
    }
}