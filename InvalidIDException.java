public class InvalidIDException extends Exception{
   String errorMsg ;
   public InvalidIDException(String s){
       this.errorMsg = s;
   }
public String toString(){
return (errorMsg );
}
}