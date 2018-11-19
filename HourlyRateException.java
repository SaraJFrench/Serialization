//HourlyRateException.java

public class HourlyRateException extends Exception{
   String errorMsg ;
   public HourlyRateException(String s){
       this.errorMsg = s;
   }
public String toString(){
return (errorMsg ) ;
}
}