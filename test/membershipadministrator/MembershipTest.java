package membershipadministrator;

import membertypes.Member;
import org.junit.jupiter.api.Test;
import userinterface.UI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

//
/*class MembershipTest {

    @Test
    void validateAge(UI ui) {
        Membership membership = new Membership();

        String intyear = "2000";
        //Arrange
        boolean expected = true;
        //Act
        boolean actual = membership.validateAge(intyear,ui);


        // Assert
        assertEquals(expected, actual);
    }*/

   /* @Test
    void validateGender(Membership membership, UI ui) {
        String gender = "M";
        ui.getString() = gender;
        //Arrange
        String expected = "Male";
        //Act
        String actual = membership.validateGender(ui);


        // Assert
        assertEquals(expected, actual);
    }
}*/
   /* public String validateGender(UI ui) {
        String gender;
        gender = ui.getString();
        if (gender.equals("f") || gender.equals("F") || gender.equals
                ("female") || gender.equals("Female") || gender.equals("FEMALE")) {
            gender = "Female";
            return gender;
        } else if (gender.equals("m") || gender.equals("M") || gender.equals
                ("male") || gender.equals("Male") || gender.equals("MALE")) {
            gender = "Male";
            return gender;
        }
        ui.errorRed("Invalid gender");
        return validateGender(ui);
    }*/