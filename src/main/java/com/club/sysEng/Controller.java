package com.club.sysEng;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * The Controller class manages user interactions and controls the SysEng Club application.
 * -
 *  * This class handles various actions such as new member registration, membership cancellation,
 *  * member check-in, and related UI interactions. It interacts with the MemberService to
 *  * validate and process user input and updates the user interface accordingly.
 *  -
 * created on: 11/28/2023
 * Author:
 */
public class Controller  {

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

    String checkResult;
    private MemberService memberService = new MemberService();



     //enable only when doing testing: contructore for Controller Test - checkIn it will mock the controller constants.
//    public Controller(MemberService memberService, TextField checkInNumber, Label checkedInStatus) {
//        this.memberService = memberService;
//        this.checkInNumber = checkInNumber;
//        this.checkedInStatus = checkedInStatus;
//    }

    /**
     * Initiates the process for new member registration in the SysEng Club.
     * This method loads the SysEngMemberRegistration.fxml file to display a new
     * scene for member registration. It sets up and shows a new stage (window)
     * with the title "SysEng Club Member Registration".
     * -
     * Note: Any IOException during the loading of the FXML file is caught
     * and printed to the standard error stream.
     * -
     * created Date: 11/29/2023
     * Author:
     */

    @FXML
    public void NewMemberRegistration() {
        //public String NewMemberRegistration(ActionEvent event)
        System.out.println("NewMemberRegistration");
        try {
            FXMLLoader loader  = new FXMLLoader(getClass().getResource("SysEngMemberRegistration.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("SysEng Club Member Registration");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

    }





    /**
     * Opens the membership cancellation scene for the SysEng Club.
     * This method loads the SysEngMemberCancellation.fxml file to create a new scene
     * for handling membership cancellations. It sets up and displays a new stage (window)
     * with the title "SysEng Club Member Cancellation".
     * -
     * Note: If an IOException occurs during the FXML file loading, it is caught
     * and printed to the standard error stream. This exception handling may need
     * to be adjusted based on specific application requirements.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    public void cancelMembership(){
        System.out.println("cancelMembership");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SysEngMemberCancellation .fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("SysEng Club Member Cancellation");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }





    /**
     * Opens the member check-in scene for the SysEng Club.
     * This method loads the SysEngMemberCheckIn.fxml file to create a new scene
     * for member check-in. It sets up and displays a new stage (window)
     * with the title "SysEng Club Member CheckIn".
     * -
     * Note: If an IOException occurs during the FXML file loading, it is caught
     * and printed to the standard error stream. Proper exception handling should be implemented
     * based on specific application requirements.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    public void memberCheckIn() {
        System.out.println("checkInMembership");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SysEngMemberCheckIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("SysEng Club Member CheckIn");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }





    /**
     * Handles the selection of a membership level.
     * This method retrieves the selected membership level from a UI component (presumably a dropdown)
     * and logs the selected level. The selected membership level is then stored in a variable for
     * further processing or use elsewhere in the application.
     * -
     * Note: Additional logic related to the membership level selection should be implemented as needed.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    public void SelectLevel() {
        String selectedLevel = membershipLevelID.getValue();
        System.out.println("Selected Level: " + selectedLevel);

        membershipPlan = selectedLevel;
    }





    /**
     * Handles the submission of the member registration form.
     * This method retrieves user input from various text fields,
     * validates the form data, and then attempts to register a new member
     * using the provided details. If registration is successful, it displays a success message
     * and the membership ID. If the form validation fails, it displays an error message.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    void memberRegistrationSubmit() {

        String result;

        firstName = firstNameID.getText();
        System.out.print(firstName + " ,");

        lastName = lastNameID.getText();
        System.out.print(lastName + " ,");

        Dob = DobID.getText();
        System.out.print(Dob + " ,");

        email = emailID.getText();
        System.out.print(email + " ,");

        mobileNumber = mobileNumberID.getText();
        System.out.print(mobileNumber + " ,");

        membershipLevel = membershipLevelID.getValue();
        System.out.print(membershipPlan);

        checkResult = memberService.isFormValid(firstName, lastName, Dob, email, mobileNumber);
        System.out.println("the checkResult is: "+checkResult);

        if (checkResult.isEmpty()) {
            // Call the service layer to register the member
            result = memberService.registerMember(firstName, lastName, Dob, email, mobileNumber, membershipPlan);
            welcomeComment.setText("Welcome to SysEng Club");
            registrationSuccess.setText("Registration is successfully done");
            membershipID.setText("Membership ID: " + result);
        } else {
            // Show error message
            errorMessage.setText(checkResult);
            errorMessage.setTextFill(Color.RED);
        }
    }





    /**
     * Handles the check-in process for a member.
     * This method retrieves the member ID from a text field, logs the check-in attempt,
     * and then uses a service to validate the member ID. The result of the check-in attempt
     * is processed and displayed in the UI.
     *
     * @throws IOException If an I/O error occurs during the process.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    void SubmitCheckIn() throws IOException {
        String member_id = checkInNumber.getText();
        System.out.println("member check in: " + member_id);
        String message = memberService.checkInMemberID(member_id);
        // Process the message to determine if it's a number or text
        message = processMessage(message);
        checkedInStatus.setText(message);
    }





    /**
     * Processes a given message to determine its nature and format the response.
     * If the message is a number (indicative of a member ID), it prefixes the message
     * with "Access Granted: ". If the message is not a number, it returns the message as is.
     * This method is typically used to process responses from member check-in services.
     *
     * @param message The message string to be processed.
     * @return A formatted message depending on whether the input is a number or text.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    public String processMessage(String message) {
        String numberRegex = "\\b\\d{8}\\b";
        if (message.matches(numberRegex)) {
            // If the message is a number, prepend "access Granted: "
            return "Access Granted: " + message;
        } else {
            // If the message is not a number, return it as is
            return message;
        }
    }





    /**
     * Handles the cancellation of a membership.
     * This method retrieves a member ID from a text field, logs the cancellation request,
     * and then uses a service to process the membership cancellation. The result of the
     * cancellation process is displayed in the UI.
     *
     * @throws IOException If an I/O error occurs during the process.
     * -
     * created Date: 11/29/2023
     * Author:
     */
    @FXML
    void membershipCancellation() throws IOException {
        String cancelMemberID =MembershipIdForCancellation.getText();
        System.out.println("membership cancel : "+cancelMemberID);
        String message = memberService.cancelMembership(cancelMemberID);
        memberShipCancelled.setText("Membership Cancelled: "+message);
    }
}
