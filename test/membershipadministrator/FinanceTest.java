package membershipadministrator;

import org.junit.jupiter.api.Test;
import userinterface.UI;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class FinanceTest {

    @Test
    void financeCreditors() {
        Finance finance = new Finance();
        Membership membership = new Membership();
        int youthPrice = 1000;
        double percentage = membership.getYouthTeam().size() * 0.02;


        //Arrange
        int expected = 1000;
        //Act
        int actual = (int) Math.ceil(percentage) * youthPrice;
        // Assert
        assertEquals(expected, actual);
    }


 /*   @Test
    void getBadstandingMembers() {
        //Arrange
        ArrayList<Integer> list = new ArrayList<Integer>();
        int expected = list.size() + 1;
        //Act
        int actual = orderList.generateOrderNr();
        // Assert
        assertEquals(expected, actual);*/
    }

