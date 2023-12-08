package com.club.sysEng;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ControllerTest {

    @FXML
    public TextField DobID;

    @FXML
    public TextField emailID;

    @FXML
    public TextField firstNameID;

    @FXML
    public TextField lastNameID;

    @FXML
    public ComboBox<String> membershipLevelID;

    @FXML
    public TextField mobileNumberID;

    @FXML
    private TextField checkInNumber;

    @FXML
    private TextField MembershipIdForCancellation;

    @FXML
    private String membershipPlan;

    @FXML
    private Label checkedInStatus;

    @FXML
    public Label registrationSuccess;

    @FXML
    private Label memberShipCancelled;

    @FXML
    public Label membershipID;

    @FXML
    private Label errorMessage;

    @FXML
    private Label welcomeComment;



    String firstName;
    String lastName;
    String Dob;
    String email;
    String mobileNumber;
    String membershipLevel;
    String checkResult="";


    @Mock
    private MemberService memberService;

    private Controller controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new Controller(memberService,checkInNumber, checkedInStatus);
        //controller = new Controller(memberService, firstNameID, lastNameID,DobID,emailID,mobileNumberID,membershipLevelID, checkResult);

    }
    @BeforeAll
    public static void initJFX() {
        Platform.startup(() -> {});
    }

    @AfterAll
    public static void cleanupJFX() {
        Platform.exit();
    }





    @Test
    void processMessageTest() {
        String result = controller.processMessage("10000006");
        assertEquals("Access Granted: 10000006", result);
    }


    @Test
    public void submitCheckInTest() throws IOException {
        // Arrange
        String member_id = "10000005";
        String expectedResult = "10000005";

        when(memberService.checkInMemberID(member_id)).thenReturn(expectedResult);
        TextField textField = new TextField("10000005");
        Label textFieldStatus = new Label("10000005");

         Controller controller = new Controller(memberService, textField, textFieldStatus);
        // Act
        try {
            controller.SubmitCheckIn();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Test
//   public void memberRegistrationSubmitTest() throws IOException {
//         firstName = "sam";
//         lastName = "rockey";
//         Dob = "1996-12-12";
//         email = "Syed@gmail.com";
//         mobileNumber = "3128668234";
//         membershipLevel = "Purple";
        // String expectedResult = "10000022";
//
//        when(memberService.registerMember(firstName,lastName,Dob,email,mobileNumber,membershipLevel)).thenReturn(expectedResult);



//        TextField firstNameID = new TextField("sam");
//        TextField lastNameID = new TextField("rockey");
//        TextField DobID = new TextField("1996-12-12");
//        TextField emailID = new TextField("Syed@gmail.com");
//        TextField mobileNumberID = new TextField("3128668234");
//        ComboBox<String> membershipLevelID = new ComboBox<>();
//        membershipLevelID.getItems().addAll("Purple");
//        membershipLevelID.setValue("Purple");
//
//        firstNameID.setText("sam");
//        lastNameID.setText("rockey");
//        DobID.setText("1996-12-12");
//        emailID.setText("Syed@gmail.com");
//        mobileNumberID.setText("9089089080");
//        membershipLevelID.setValue("Purple");
//
//
//        Controller controller = new Controller(memberService, firstNameID, lastNameID,DobID,emailID,mobileNumberID,membershipLevelID, checkResult);
//        when(memberService.isFormValid(firstName, lastName,Dob, email, mobileNumber)).thenReturn("");
//
//
//        // Act
//        controller.memberRegistrationSubmit();
//
//    }
}