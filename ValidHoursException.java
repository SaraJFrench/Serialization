//ValidHoursException.java


public class ValidHoursException extends Exception{
   String errorMsg ;
   public ValidHoursException(String s){
       this.errorMsg = s;
   }
public String toString(){
return (errorMsg ) ;
}  
}
