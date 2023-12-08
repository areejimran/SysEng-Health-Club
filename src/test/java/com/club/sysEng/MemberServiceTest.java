package com.club.sysEng;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The MemberServiceTest class contains JUnit test cases for testing the methods
 * of the MemberService class in the SysEng Club application.
 * -
 * It includes tests for member registration, membership cancellation, and member check-in.
 * The tests cover various scenarios, such as new member registration, membership cancellation,
 * handling already cancelled memberships, and checking in members.
 */
class MemberServiceTest {

    MemberService testService = new MemberService();


    // Test the registerMember method to ensure it returns the expected member ID
    // (Change mobile number and memberID before running the test)
    @Test
    void registerMemberTest() {
        String memberID= testService.registerMember("John", "Doe", "1990-01-01", "john@example.com", "1234567891", "Purple");
        assertEquals("10000007", memberID);
    }

    // Test the cancelMembership method to ensure it cancels the membership correctly
    // (Check membership status column should not be "Cancelled")
    @Test
    void cancelMembershipTest() throws IOException {
        String memberID= testService.cancelMembership("10000004");
        assertEquals("10000004", memberID);
    }

    // Test the cancelMembership method to ensure it handles already cancelled memberships
    // (Check membership status column should be "Cancelled")
    @Test
    void cancelMembershipAlreadyCancelledTest() throws IOException {
        String memberIDs = testService.cancelMembership("10000001");
        assertEquals("Membership already cancelled", memberIDs);
    }

    // Test the checkInMemberID method to ensure it checks in members correctly
    // (Check membership status column should not be "Cancelled")
    @Test
    void checkInMemberIDTest() throws IOException {
        String memberID= testService.checkInMemberID("10000005");
        assertEquals("10000005", memberID);
    }

    // Test the checkInMemberID method to ensure it handles already cancelled memberships
    // (Check membership status column should be "Cancelled")
    @Test
    void checkInMemberIDAlreadyCancelledTest() throws IOException {
        String memberID= testService.checkInMemberID("10000001");
        assertEquals("Membership already cancelled", memberID);
    }

    @Test
    void isFormValidTest() {
        String validate = testService.isFormValid("shahrukh", "alok", "1996-12-12", "Syed@gmail.com", "3128668048");
        assertEquals("", validate);
    }

    @Test
    void isFormValidFristNameTest() {
        String validate = testService.isFormValid("sh", "alok", "1996-12-12", "Syed@gmail.com", "3128668048");
        assertEquals("Please enter a full first name with at least 3 characters.", validate);
    }

    @Test
    void isFormValidLastNameTest() {
        String validate = testService.isFormValid("shahrukh", "a", "1996-12-12", "Syed@gmail.com", "3128668048");
        assertEquals("Please enter a full last name with at least 3 characters.", validate);
    }

    @Test
    void isFormValidDobTest() {
        String validate = testService.isFormValid("shahrukh", "alok", "1996-31-12", "Syed@gmail.com", "3128668048");
        assertEquals("Please enter a correct date of birth in YYYY-MM-DD format.", validate);
    }

    @Test
    void isFormValidDobAgeTest() {
        String validate = testService.isFormValid("shahrukh", "alok", "2020-12-12", "Syed@gmail.com", "3128668048");
        assertEquals("You must be at least 18 years old to register.", validate);
    }

    @Test
    void isFormValidEmailIdTest() {
        String validate = testService.isFormValid("shahrukh", "alok", "1996-12-12", "Syed@.com", "3128668048");
        assertEquals("Please enter a valid email address.", validate);
    }

    @Test
    void isFormValidMobileNumTest() {
        String validate = testService.isFormValid("shahrukh", "alok", "1996-12-12", "Syed@gmail.com", "3128648");
        assertEquals("Please enter a 10-digit mobile number.", validate);
    }
}





