package leetcode150;
//solution without using long int
public class Sqrtx69 {
    public int mySqrt(int x) {
        int[] vals = prep(x);
        int start = vals[0];
        int end = vals[1];
        return sqrtSimple(x, start, end);
    }

    private static int[] prep(int x){
        int[] values = new int[2];
        int counter=0;
        while(x!=0){
            x/=10;
            counter++;
        }
        counter = counter/2+1;
        int end = 0;

        for(int i=0;i<counter;i++){
            end=end*10+1;
        }
        int start = end/10-1;
        end=end*9;
        if(end>46340)
            end=46340;
        values[0]=start;
        values[1]=end;
        return values;
    }

    private static int sqrtSimple(int x, int start, int end){
        while(start!=end && start+1!=end){
            int mid=(start+end)/2;
            System.out.println("start: "+start+", mid: "+mid+", end: "+end);
            int midsq = mid*mid;
            if(midsq==x)
                return mid;
            else if(midsq>x)
                end = mid;
            else
                start = mid;
        }
        if(end*end<=x)
            return end;
        else
            return start;
    }
}
