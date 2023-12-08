package com.club.sysEng;

/**
 * The Constants class contains constant values and configurations used in the SysEng Club application.
 * -
 * This class was created on: 11/29/2023
 * Author:
 */
public class Constants {

    // Number of visits (initialized to 0)
    public static final int numberOfVisits = 0;

    // File path for member data
    public static final String MEMBER_DATA_FILE = "src/main/resources/Data/memberData.csv";

    // Header for the CSV file
    public static final String CSV_HEADER = "Membership Id,First Name,Last Name,DOB(yyyy-MM-dd),Age,Email ID,Mobile Number,membershipLevel,Membership Status,Visits";

    // Membership status constants
    public static final String MEMBERSHIP_ACTIVATED = "Activated";
    public static final String MEMBERSHIP_CANCELLED = "Cancelled";

    // Default starting ID if file is empty
    public static final int DEFAULT_STARTING_MEMBER_ID = 10000000;

}
