//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
//		Check arguments
        if (args == null || args.length != 1) {
            System.out.println ( "Wrong arguments" );
            return;
        }

        String readLine = file_reader ( "students.txt" );
        String words[] = readLine.split ( "," );
        System.out.println ( "Loading data ..." );

        if (args[0].equals ( "a" )) {
            try {
                for ( String word : words ) {
                    System.out.println ( word.trim () );
                }
            } catch (Exception e) {
            }
        } else if (args[0].equals ( "r" )) {
            try {
                Random random = new Random ();
                int randomInt = random.nextInt ( words.length );
                System.out.println ( words[randomInt] );
            } catch (Exception e) {
            }
        } else if (args[0].contains ( "+" )) {
            try {
                String word = args[0].substring ( 1 );
                Date date = new Date ();
                String dataFormetSample = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat ( dataFormetSample );
                String finalDate = dateFormat.format ( date );
                file_writer ( "students.txt", word, finalDate );
            } catch (Exception e) {
            }
        } else if (args[0].contains ( "?" )) {
            try {
                boolean done = false;
                String target = args[0].substring ( 1 );
                for ( int idx = 0; idx < words.length && !done; idx++ ) {
                    if (words[idx].trim ().equals ( target )) {
                        System.out.println ( "We found it!" );
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
        } else if (args[0].contains ( "c" )) {
            try {
                char characters[] = readLine.toCharArray ();
                boolean in_word = false;
                int count = 0;
                for ( char character : characters ) {
                    if (character == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println ( count + " word(s) found " );
            } catch (Exception e) {
            }
        }
        System.out.println ( "Data Loaded." );
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
            bufferedReader.write ( ", " + word + "\nList last updated on " + final_date );
            bufferedReader.close ();
        } catch (Exception e) {

        }
    }
}
