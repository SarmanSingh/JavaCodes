public class BuyStocks{
    public static int maxProitStock(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
            int profit=prices[i]-buyPrice;
            maxProfit=Math.max(maxProfit,profit);
            }
            else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String [] args){
        int prices[]={2,6,11,8,9,5};
        int p=maxProitStock(prices);
        System.out.println(p);
    }
}