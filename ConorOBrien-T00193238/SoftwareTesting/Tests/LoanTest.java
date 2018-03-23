import org.junit.Test;

import static org.junit.Assert.*;

public class LoanTest {

    private Loan l;
    private int nullValue;

    @Test
    public void noArgConstructorTest() { l = new Loan(); }
    @Test
    public void constructorTest() {
        l = new Loan(2500, 3);
    }

    @Test
    public void getAmount() throws Exception {
        l = new Loan(10000, 5);

        assertEquals(10000.0, l.getAmount(), .0f);
    }

    @Test
    public void getPeriod() throws Exception {
        l = new Loan(10000, 3);

        assertEquals(3, l.getPeriod());
    }

    @Test
    public void getRate() throws Exception {
        l = new Loan(3000, 4);
        assertEquals(6, l.getRate(),.0f);
    }

    @Test
    public void getMonthlyPayment() throws Exception {
        l = new Loan(3000, 4);
        l.getRate();
        assertEquals(70,l.getMonthlyPayment(),.5f);
    }

    @Test
    public void getTotalPayment() throws Exception {
        l = new Loan(3000, 4);
        l.getRate();
        assertEquals(3382,l.getTotalPayment(),.2f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase1() throws Exception {
        l = new Loan( nullValue, 3);
        l.getRate();

        assertEquals(l.getMonthlyPayment(),l.getMonthlyPayment(),1f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase2() throws Exception {
        l = new Loan(250, 3);
        l.getRate();

        assertEquals(0.0,l.getMonthlyPayment(),.5f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCase3() throws Exception {
        l = new Loan(12000,3);
        l.getRate();

        assertNotEquals(20000,l.getMonthlyPayment(),.5f);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCase4() throws Exception {
        l = new Loan(2400,0);
        l.getRate();

        assertEquals(0.0,l.getMonthlyPayment(),.5f);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCase5() throws Exception {
        l = new Loan(2750,0);
        //Unable to perform test on time sections less than a year but greater than 0
        l.getRate();

        assertEquals(0.0,l.getMonthlyPayment(),.4f);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCase6() throws Exception {
        l = new Loan(7800,10);
        l.getRate();

        assertEquals(82.7,l.getMonthlyPayment(),.3f);
    }

    @Test
    public void testCase7() throws Exception {
        l = new Loan(3000, 2);
        l.getRate();

        assertEquals(138,l.getMonthlyPayment(), 1f);
    }

    @Test
    public void testCase8() throws Exception {
        l = new Loan(8000,3);
        l.getRate();

        assertEquals(250,l.getMonthlyPayment(),1f);
    }

    @Test
    public void testCase9() throws Exception {
        l = new Loan(2000,4);
        l.getRate();

        assertEquals(47,l.getMonthlyPayment(),1f);
    }

    @Test
    public void testCase10() throws Exception {
        l = new Loan(9000,5);
        l.getRate();

        assertEquals(170,l.getMonthlyPayment(),1f);
    }



}