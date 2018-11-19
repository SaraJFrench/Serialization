import java.io.*; 


  public class Payroll implements Serializable {
    private String name;
    private int id;
    private double rate;
    private double hoursWorked;

    private static final long serialVersionUID = 1L;

    public Payroll(String name, int id) throws InvalidNameException, InvalidIDException {
        setName(name);
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String empName) throws InvalidNameException {
        if (empName == null || empName.equals("")) {
            throw new InvalidNameException("Invalid Name. Name can not be empty");
        }
        this.name = empName;
    }

    public int getId() {
        return id;
    }

    public void setId(int empID) throws InvalidIDException {

        if (empID <= 0) {
            throw new InvalidIDException("EmpID can not be negative or zero");
        }
        this.id = empID;
    }

    public double getHourlyRate() {
        return rate;
    }

    public void setHourlyRate(double rate) throws HourlyRateException {

        if (rate < 0 || rate > 25) {
            throw new HourlyRateException("rate can not be negative or greater than 25");
        }
        this.rate = rate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hours) throws ValidHoursException {
        if(hours < 0 || hours > 84 ){
            throw new ValidHoursException("hours can not be negative or greater than 84");
        }
        this.hoursWorked = hours;
    }
      public double getGrossPay() {
    return rate * hoursWorked;
}
  }
  
    
  

