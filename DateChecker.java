import java.text.SimpleDateFormat;

public class DateChecker{
    //First time meddling in Java directly, code might not be standardized
     public static void main(String []args){
        printBonusDatesBetween(0, 2105); //This does treat all dates as 4 digit numbers
     }
     
     static void printBonusDatesBetween(int fromYear, int toYear)
     {  
         if(fromYear < 0 || fromYear > 9999 || toYear < 0 || toYear > 9999){
            System.out.println("The dates cannot be negative or have more than 5 digits");
            return;
         }
         else if(toYear < fromYear) {
            System.out.println("The dates should be provided in ascending manner");
            return;
         }
         
         for(int i = fromYear; i<=toYear; i++){
         
            int vCentury = ReverseInt(i / 100); //Extracting the century-day
            int vDecade = ReverseInt(i % 100); //Extracting the decade-month
            
            if(vCentury > 0 && vDecade <=12 && vDecade > 0) //Just to limit possibility of false positives
                try{
                    String gDate = Integer.toString(i) + '-' + 
                                    (vDecade<10?"0" + vDecade : vDecade) + '-' + 
                                    (vCentury<10?"0" + vCentury : vCentury); //adding a zero in front if they are single digit
                                    
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println(simpleDateFormat.format(simpleDateFormat.parse(gDate)));//Trying to parse the date will check if the numbers are also in range
                }
                catch(Exception e){ //Don't need to do anything if exception is caught
                }
         }
     }
     
     static int ReverseInt(int Reversable){
         int vReturn = 0;
         if(Reversable<10){
             return Reversable*10; //For specific one-digit numbers in this implementation. 
         }
         
         for(int i = String.valueOf(Reversable).length()-1; Reversable > 0; i--){//i symbolize how many symbols are left.
             vReturn += (Reversable % 10) * Math.pow(10, i);//increasing by power allows to allocate the correct number/
             Reversable /= 10;
         }
         
         return vReturn;
     }
}