package uk.ac.ucl.patient;

public class Main {
    public static void main(String args[]) {
        Model func = new Model();

        func.ReadFile("C:\\Users\\sciso\\IdeaProjects\\CourseWork2\\src\\main\\java\\uk\\ac\\ucl\\patient\\book.csv");

        /*
        makes the files read by readCSV class ready to be stored to be executed upon
        essential method needs to be called in order for printing any data
        */

//        func.holdPatient();

        /*
        Prints all patient data
         */

//        func.printAllAge();

        /*
        prints single patient by the index no which starts from 1
         */

        //func.printSinglePatient(99);

        /*
        with func.printAll<x>, x can be any criteria in all Capital Letters
         */

        // func.printAllID();

        //func.printAllETHNICITY();

        /*
        Make GUI
         */
        func.showGUI();


    }
}
