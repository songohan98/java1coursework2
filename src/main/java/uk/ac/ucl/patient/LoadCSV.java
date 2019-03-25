package uk.ac.ucl.patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadCSV extends JPanel {

    static JFrame f21;
    JButton jb2;
    String filepath;
    public LoadCSV()
    {

    }

    //reads csv file row and returns an array of individual strings in that row
    public class readCSV
    {
        private ArrayList<String[]> array = new ArrayList<String[]>();
        private String[] eachrow;

        public ArrayList<String[]> csvReader(File file)
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                while (br.ready()) {
                    String str = br.readLine();
                    eachrow = str.split(",|\\s|;");
                    array.add(eachrow);
                    //System.out.println(Arrays.toString(eachrow));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return array;

        }
    }

    class Table extends AbstractTableModel
    {
        private final String[] colNames =
                { "ID", "BIRTHDATE", "DEATHDATE", "SSN", "DRIVERS",
                        "PASSPORT", "PREFIX", "FIRST", "LAST", "SUFFIX",
                        "MAIDEN", "MARITAL", "RACE", "ETHNICITY", "GENDER",
                        "BIRTHPLACE", "ADDRESS", "CITY", "STATE", "ZIP" };
        private ArrayList<String[]> ar1 = new ArrayList<String[]>();

        public void loadCSVdata(ArrayList<String[]> data)
        {
            this.ar1 = data;
            this.fireTableDataChanged();
        }

        public int getRowCount() {
            return ar1.size();
        }

        public int getColumnCount() {
            return colNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return ar1.get(rowIndex)[columnIndex];
        }
    }


    public LoadCSV(String filepath)
    {

        super(new BorderLayout(3,3));
        this.filepath=filepath;
        JTable form = new JTable(new Table());
        form.setPreferredScrollableViewportSize(new Dimension(1000,700));
        JPanel b21 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(b21, BorderLayout.SOUTH);
        JScrollPane scroller = new JScrollPane(form);
        add(scroller, BorderLayout.CENTER);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        readCSV reader = new readCSV();
        Table model = new Table();
        form.setModel(model);
        //File DataFile = new File("C:\\Users\\sciso\\Documents\\temp\\examplefile\\src\\book.csv");
        File inputdata = new File(filepath);
        ArrayList<String[]> loader = reader.csvReader(inputdata);
        model.loadCSVdata(loader);

//        JMenuBar mb = new JMenuBar();
//        mb.setBounds(0,0,500,20);
        JButton jb1 = new JButton("BACK");
        jb1.setBounds(20,20,100,100);
//        mb.add(jb1);
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f21.setVisible(false);
              PatientFinder pf = new PatientFinder(1);

            }
        });
        b21.add(jb1);

        jb2 = new JButton("Save as JSON");
        jb2.addActionListener(new SaveJSON());

        b21.add(jb2);
    }

    class SaveJSON implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            WriteFile wr;
            Model read = new Model();

            JFileChooser jf2 = new JFileChooser();
            int i = jf2.showSaveDialog(jb2);
            if(i == JFileChooser.APPROVE_OPTION)
            {
                File file = jf2.getSelectedFile();
                if(file==null)
                {
                    return;
                }
                if(file.getName().toLowerCase().endsWith(".json"))
                {
                    file = new File(file.getParentFile(),file.getName());

                    read.ReadFile(filepath);
                    read.holdPatient();
                    String s = read.storetextAllPatient();

                    wr = new WriteFile(file.getPath(),s);
                    JOptionPane.showMessageDialog(null, "Saved!");
                }
                else
                {
                    file = new File(file.getParentFile(),file.getName()+".json");

                    read.ReadFile(filepath);
                    read.holdPatient();
                    String s = read.storetextAllPatient();

                    wr = new WriteFile(file.getPath(),s);
                    JOptionPane.showMessageDialog(null, "Saved!");
                }
                }
                try
                {

                } catch (Exception x) {
                    x.printStackTrace();
                }



            }

    }

    public static void frame(String name, String path)
    {
        f21 = new JFrame(name);
        f21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoadCSV LCSV = new LoadCSV(path);
        f21.setContentPane(LCSV);
        f21.pack();
        f21.setLocationRelativeTo(null);
        f21.setVisible(true);
    }



}
