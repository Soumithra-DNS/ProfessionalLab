//File Name StudentList.java

import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
//		Check arguments
        if(args == null || args.length != 1){
            System.out.println ("Wrong arguments");
            return;
        }
        if (args[0].equals ( "a" )) {
            System.out.println ( "Loading data ..." );
            try {
                BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( "students.txt" ) ) );
                String readLine = bufferedReader.readLine ();
                String words[] = readLine.split ( "," );
                for ( String word : words ) {
                    System.out.println ( word.trim () );
                }
            } catch (Exception e) {
            }
            System.out.println ( "Data Loaded." );
        } else if (args[0].equals ( "r" )) {
            System.out.println ( "Loading data ..." );
            try {
                BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( "students.txt" ) ) );
                String readLine = bufferedReader.readLine ();
                String words[] = readLine.split ( "," );
                Random random = new Random ();
                int randomInt = random.nextInt ( words.length );
                System.out.println ( words[randomInt] );
            } catch (Exception e) {
            }
            System.out.println ( "Data Loaded." );
        } else if (args[0].contains ( "+" )) {
            System.out.println ( "Loading data ..." );
            try {
                BufferedWriter bufferedReader = new BufferedWriter ( new FileWriter ( "students.txt", true ) );
                String word = args[0].substring ( 1 );
                Date date = new Date ();
                String dataFormetSample = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat ( dataFormetSample );
                String finalDate = dateFormat.format ( date );
                bufferedReader.write ( ", " + word + "\nList last updated on " + finalDate );
                bufferedReader.close ();
            } catch (Exception e) {
            }
            System.out.println ( "Data Loaded." );
        } else if (args[0].contains ( "?" )) {
            System.out.println ( "Loading data ..." );
            try {
                BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( "students.txt" ) ) );
                String readLine = bufferedReader.readLine ();
                String words[] = readLine.split ( "," );
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
            System.out.println ( "Data Loaded." );
        } else if (args[0].contains ( "c" )) {
            System.out.println ( "Loading data ..." );
            try {
                BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader ( new FileInputStream ( "students.txt" ) ) );
                String readLine = bufferedReader.readLine ();
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
            System.out.println ( "Data Loaded." );
        }
    }
}
