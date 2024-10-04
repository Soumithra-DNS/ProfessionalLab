//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
//		Check arguments
        if (args == null || args.length != 1) {
            System.out.println ( Constants.ARGUMENTS );
            return;
        }

        String readLine = file_reader ( Constants.FILE_NAME );
        String words[] = readLine.split ( Constants.STUDENT_ENTRY_DELIMITER );
        System.out.println ( Constants.LOADING_DATA_TEXT );

        if (args[0].equals ( Constants.SHOW_ALL )) {
            try {
                for ( String word : words ) {
                    System.out.println ( word.trim () );
                }
            } catch (Exception e) {
            }
        } else if (args[0].equals ( Constants.SHOW_RANDOM )) {
            try {
                Random random = new Random ();
                int randomInt = random.nextInt ( words.length );
                System.out.println ( words[randomInt] );
            } catch (Exception e) {
            }
        } else if (args[0].contains ( Constants.ADD_ENTRY )) {
            try {
                String word = args[0].substring ( 1 );
                DateFormat dateFormat = new SimpleDateFormat ( Constants.DATE_FORMAT);
                String finalDate = dateFormat.format (  new Date () );
                file_writer ( Constants.FILE_NAME, word, finalDate );
            } catch (Exception e) {
            }
        } else if (args[0].contains ( Constants.FIND_ENTRY )) {
            try {
                boolean done = false;
                String target = args[0].substring ( 1 );
                for ( int idx = 0; idx < words.length && !done; idx++ ) {
                    if (words[idx].trim ().equals ( target )) {
                        System.out.println ( Constants.FOUND_TEXT );
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
        } else if (args[0].contains ( Constants.SHOW_COUNT)) {
            try {
                char characters[] = readLine.toCharArray ();
                boolean in_word = false;
                int count = 0;
                for ( char character : characters ) {
                    if (character == Constants.SPACE) {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println ( count + Constants.WORDS_FOUND);
            } catch (Exception e) {
            }
        }
        System.out.println ( Constants.LOADED_DATA_TEXT );
    }

    public static String file_reader(String file_name) {
        try {
            BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( file_name ) ) );
            return bufferedReader.readLine ();
        } catch (Exception e) {
            return null;
        }
    }
    public static void file_writer(String file_name, String word, String final_date) {
        try {
            BufferedWriter bufferedReader = new BufferedWriter ( new FileWriter ( file_name, true ) );
            bufferedReader.write ( Constants.STUDENT_ENTRY_DELIMITER + word + Constants.UPDATE_CONTENT + final_date );
            bufferedReader.close ();
        } catch (Exception e) {

        }
    }
}
