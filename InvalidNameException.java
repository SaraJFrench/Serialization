//InvalidNameException.java


public class InvalidNameException extends Exception{
   String errorMsg ;
   public InvalidNameException(String s){
       this.errorMsg = s;
   }
public String toString(){
return (errorMsg ) ;
}  
}

