/**
 * Auto Generated Java Class.
 */

 import java.util.Scanner;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.ObjectOutputStream;
 import java.io.*;
// TestPayroll.javan
public class TestPayroll {

    // this method serialize a payroll object int file payroll.ser
    public void serializePayroll(Payroll payroll) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream("payroll.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(payroll);

            System.out.println("Done. File written to " + System.getProperty("user.dir"));

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args)throws HourlyRateException,InvalidIDException,ValidHoursException,InvalidNameException {
           
        Scanner in = new Scanner(System.in);
        String name;
        int empID;
        System.out.print("Enter employee's name: ");
        name = in.next();
        System.out.print("Enter employee's empID: ");
        empID = in.nextInt();
        Payroll payroll = new Payroll(name, empID);
        System.out.print("Enter employee's hourly rate: ");

        double rate = in.nextDouble();
        payroll.setHourlyRate(rate);
        System.out.print("Enter employee's number of hours worked: ");
        double hours = in.nextDouble();

        payroll.setHoursWorked(hours);

        // Payroll.main(name, empID, rate, hours);

        System.out.println("Gross pay is " + payroll.getGrossPay());

    }

}