import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Customer.class)


public class CustomerTest {




    @Test
    public void takeOutLoan() throws Exception {

        Customer c = new Customer("John",96.66);

        Loan newLoan = EasyMock.createMock(Loan.class);

        PowerMock.expectNew(Loan.class,5000.00,5).andReturn(newLoan);

        expect(newLoan.getMonthlyPayment()).andReturn(96.66);

        PowerMock.replay(newLoan,Loan.class);

        c.takeoutloan();



        double result = c.getMonthlypayments();


        assertEquals(96.66,result,0.005);
        assertEquals("John",c.getName());

        PowerMock.verify(newLoan,Loan.class);

    }

}