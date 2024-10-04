//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        // Check if the provided arguments are valid
        if (args == null || args.length != 1) {
            System.out.println ( Constants.ARGUMENTS );// Print error message for invalid arguments
            return;// Exit if arguments are invalid
        }

        // Load the contents of the student list file
        String readLine = file_reader ( Constants.FILE_NAME );
        String words[] = readLine.split ( Constants.STUDENT_ENTRY_DELIMITER );
        System.out.println ( Constants.LOADING_DATA_TEXT );

        // If the argument is to show all students
        if (args[0].equals ( Constants.SHOW_ALL )) {
            try {
                for ( String word : words ) {
                    System.out.println ( word.trim () );
                }
            } catch (Exception e) {
                // Catch any exception that occurs during file writing
            }
            // If the argument is to show a random student entry
        } else if (args[0].equals ( Constants.SHOW_RANDOM )) {
            try {
                Random random = new Random ();
                int randomInt = random.nextInt ( words.length );
                System.out.println ( words[randomInt] );
            } catch (Exception e) {
                // Catch any exception that occurs during file writing
            }
            // If the argument is to add a new student entry
        } else if (args[0].contains ( Constants.ADD_ENTRY )) {
            try {
                String word = args[0].substring ( 1 );
                DateFormat dateFormat = new SimpleDateFormat ( Constants.DATE_FORMAT );
                String finalDate = dateFormat.format ( new Date () );
                file_writer ( Constants.FILE_NAME, word, finalDate );
            } catch (Exception e) {
                // Catch any exception that occurs during file writing
            }
            // If the argument is to find a specific student entry
        } else if (args[0].contains ( Constants.FIND_ENTRY )) {
            try {
                String target = args[0].substring ( 1 );
                for ( int idx = 0; idx < words.length; idx++ ) {
                    if (words[idx].trim ().equals ( target )) {
                        System.out.println ( Constants.FOUND_TEXT );
                        break;
                    }
                }
            } catch (Exception e) {
                // Catch any exception that occurs during file writing
            }
            // If the argument is to show the count of student entries
        } else if (args[0].contains ( Constants.SHOW_COUNT )) {
            try {
                System.out.println ( words.length + Constants.WORDS_FOUND );
            } catch (Exception e) {
                // Catch any exception that occurs during file writing
            }
        } else {
            System.out.println ( Constants.ARGUMENTS );
        }
        System.out.println ( Constants.LOADED_DATA_TEXT );
    }

    // Method to load data from the specified file
    public static String file_reader(String file_name) {
        try {
            // Read the file
            BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( file_name ) ) );
            return bufferedReader.readLine ();
        } catch (Exception e) {
            return null;
        }
    }

    // Method to update the file content with a new entry
    public static void file_writer(String file_name, String word, String final_date) {
        try {
            // Open the file for appending
            BufferedWriter bufferedReader = new BufferedWriter ( new FileWriter ( file_name, true ) );
            bufferedReader.write ( Constants.STUDENT_ENTRY_DELIMITER + word + Constants.UPDATE_CONTENT + final_date );
            bufferedReader.close ();
        } catch (Exception e) {
            // Catch any exception that occurs during file writing
        }
    }
}
