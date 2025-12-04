public class StockBuySell {

    public static void main(String[] args) {
      int[] arr={7,1,5,3,6,4};
        System.out.println(stockBuyAndSell(arr));

    }

    public static int stockBuyAndSell(int[] prices){
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice) minPrice=prices[i];
            else{
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return  maxProfit;
    }
}
