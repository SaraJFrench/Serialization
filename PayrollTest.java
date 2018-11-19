import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class PayrollTest {

    Payroll p;


    @Before
    public void createPayroll() {
        try {
            p = new Payroll("Default", 100);
        } catch (InvalidNameException | InvalidIDException e) {
            throw new AssertionFailedError("Unable to create payroll object");
        }
    }

    @Test()
    public void testPayroll0() {
        try {
            p = new Payroll(null, 100);
            throw new AssertionFailedError("Create payroll object with null name");
        } catch (InvalidNameException e) {
            // fine
        } catch (InvalidIDException e) {
            throw new AssertionFailedError("Wrong exception type!");
        }
    }

    @Test()
    public void testPayroll1() {
        try {
            p = new Payroll("", 100);
            throw new AssertionFailedError("Create payroll object with blank name");
        } catch (InvalidNameException e) {
            // fine
        } catch (InvalidIDException e) {
            throw new AssertionFailedError("Wrong exception type!");
        }
    }

    @Test
    public void testPayroll2() {
        try {
            p = new Payroll("Default", -100);
            throw new AssertionFailedError("Create payroll object with negative id");
        } catch (InvalidNameException e) {
            throw new AssertionFailedError("Wrong exception type!");
        } catch (InvalidIDException e) {
            // fine
        }
    }

    @Test
    public void testPayroll3() {
        try {
            p = new Payroll("Default", 0);
            throw new AssertionFailedError("Create payroll object with id as 0");
        } catch (InvalidNameException e) {
            throw new AssertionFailedError("Wrong exception type!");
        } catch (InvalidIDException e) {
            // fine
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Default", p.getName());
    }

    @Test
    public void testSetName() {
        try {
            p.setName("Default1");
            assertEquals("Default1", p.getName());
        } catch (InvalidNameException e) {
            throw new AssertionFailedError("Exception occurred in set name!");
        }
    }

    @Test
    public void testGetId() {
        assertEquals(100, p.getId());
    }

    @Test
    public void testSetId() {
        try {
            p.setId(1000);
            assertEquals(1000, p.getId());
        } catch (InvalidIDException e) {
            throw new AssertionFailedError("Exception occurred in set id!");
        }
    }

    @Test
    public void testGetHourlyRate() {
        assertEquals(0, p.getHourlyRate(), 0.000001);
    }

    @Test
    public void testSetHourlyRate1() {
        try {
            p.setHourlyRate(15.4);
            assertEquals(15.4, p.getHourlyRate(), 0.000001);
        } catch (HourlyRateException e) {
            throw new AssertionFailedError("Exception occurred in setHourlyRate!");
        }
    }

    @Test
    public void testSetHourlyRate2() {
        try {
            p.setHourlyRate(35.4);
            throw new AssertionFailedError("Exception didn't occurr in setHourlyRate "
                    + "with invalid rate value!");
        } catch (HourlyRateException e) {
            assertEquals(0, p.getHourlyRate(), 0.000001);
        }
    }

    @Test
    public void testSetHourlyRate3() {
        try {
            p.setHourlyRate(-5.4);
            throw new AssertionFailedError("Exception didn't occurr in setHourlyRate "
                    + "with invalid rate value!");
        } catch (HourlyRateException e) {
            assertEquals(0, p.getHourlyRate(), 0.000001);
        }
    }

    @Test
    public void testGetHoursWorked() {
        assertEquals(0, p.getHoursWorked(), 0.000001);
    }

    @Test
    public void testSetHoursWorked1() {
        try {
            p.setHoursWorked(15.4);
            assertEquals(15.4, p.getHoursWorked(), 0.000001);
        } catch (ValidHoursException e) {
            throw new AssertionFailedError("Exception occurred in setHoursWorked!");
        }
    }

    @Test
    public void testSetHoursWorked2() {
        try {
            p.setHoursWorked(105.4);
            throw new AssertionFailedError("Exception didn't occurr in setHoursWorked "
                    + "with invalid hour value!");
        } catch (ValidHoursException e) {
            assertEquals(0, p.getHoursWorked(), 0.000001);
        }
    }

    @Test
    public void testSetHoursWorked3() {
        try {
            p.setHoursWorked(-5.4);
            throw new AssertionFailedError("Exception didn't occurr in setHoursWorked "
                    + "with invalid hour value!");
        } catch (ValidHoursException e) {
            assertEquals(0, p.getHoursWorked(), 0.000001);
        }
    }

    @Test
    public void testGetGrossPay() {
        try {
            p.setHourlyRate(10.5);
            p.setHoursWorked(4);
            assertEquals(p.getGrossPay(), 42, 0.000001);
        } catch (ValidHoursException e) {
            //e.printStackTrace();
        } catch (HourlyRateException e) {
            //e.printStackTrace();
        }
    }

}
