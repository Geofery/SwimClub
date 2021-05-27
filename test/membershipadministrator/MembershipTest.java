package membershipadministrator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {


  String generateMemberIdTest() {
    Membership membership = new Membership();
    String actual = membership.generateMemberIdTest();
    return actual;
  }

  @Test
  void ValidateGenerateMemberId(){
    String expected = "M1";

    String actual = generateMemberIdTest();

    assertEquals(expected, actual);
  }
}