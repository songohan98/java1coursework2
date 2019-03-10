package uk.ac.ucl.patient;

public class Main {
    public static void main(String args[])
    {
        Model func = new Model();

        func.ReadFile("C:\\Users\\sciso\\IdeaProjects\\CourseWork2\\src\\main\\java\\uk\\ac\\ucl\\patient\\book.csv");

        // makes the files read by readCSV class ready to be stored to be executed upon
        func.holdPatient();

        //Prints all patient data
        func.printAllData();


    }
}
