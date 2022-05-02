class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int firstFruit = -1;
        int secondFruit = -1;
        int curSum = 0;
        int secondFruitCnt = 0;
        for (int fruit: fruits){
            if(fruit == firstFruit || fruit == secondFruit){
                curSum++;
            }else{
                curSum = secondFruitCnt+1;
            }
            if(fruit == secondFruit){
                secondFruitCnt++;
            }else{
                secondFruitCnt = 1;
            }
            if(fruit != secondFruit){
                firstFruit = secondFruit;
                secondFruit = fruit;
            }
            res = Math.max(res,curSum);
        }
        return res;
    }
}
