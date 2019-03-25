package uk.ac.ucl.patient;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class PatientFinder {


    public PatientFinder(String s)
    {
        displayFrame0();
    }
    public  PatientFinder(int i)
    {
        displayFrame1();
    }

    public void displayFrame0()
    {
        // First Frame
        final JFrame f0 = new JFrame();
        f0.setTitle("Patient Database");
        JButton b0 = new JButton("Login");
        b0.setBounds(100,120,100,30);
        final JLabel l0 = new JLabel();
        l0.setBounds(20,150,200,50);
        final JPasswordField pf0 = new JPasswordField();
        pf0.setBounds(100,75,100,30);
        JLabel l01 = new JLabel("Username:");
        l01.setBounds(20,20,80,30);
        JLabel l02=new JLabel("Password:");
        l02.setBounds(20,75, 80,30);
        final JTextField t01 = new JTextField();
        t01.setBounds(100,20, 100,30);

        final JLabel l12 = new JLabel("Hint");
        l12.setText("username: \"ucl\" and password: \"123\"");
        l12.setBounds(20,220,250,40);

        f0.add(b0);
        f0.add(l0);
        f0.add(l01);
        f0.add(l02);
        f0.add(pf0);
        f0.add(t01);
        f0.add(l12);

        f0.setSize(300,300);
        f0.setLayout(null);
        f0.setLocationRelativeTo(null);
        f0.setVisible(true);
        f0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = t01.getText();
                String s = String.valueOf(pf0.getPassword());
                if(s.equals("123") && username.matches("ucl"))
                {
                    f0.setVisible(false);
                    displayFrame1();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect user id or password!\nPlease enter the correct login details");
                }
            }
        });
    }

    public void displayFrame1()
    {
        int a =150,b=100;
        //Second frame
        final JFrame f1 = new JFrame();
        f1.setTitle("Patient Database");

        //First Button
        final JButton b0 = new JButton("Open a File");
        b0.setBounds(a,30+b,200,30);
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==b0)
                {
                    JFileChooser choose = new JFileChooser();
                    int i = choose.showOpenDialog(null);
                    if(i==JFileChooser.APPROVE_OPTION)
                    {
                        File file1 = choose.getSelectedFile();
                        String name = file1.getName();
                        final String path = file1.getPath();

                        final String filename = file1.getName();
                        String extension = "";
                        int index = filename.lastIndexOf('.');
                        if (index > 0) {
                            extension = filename.substring(index+1);
                        }
                        System.out.println(extension);

                        if(extension.equals("csv"))
                        {
                            javax.swing.SwingUtilities.invokeLater(new Runnable()
                            {
                                public void run()
                                {
                                    LoadCSV p = new LoadCSV();
                                    p.frame(filename,path);
                                    f1.setVisible(false);
                                }
                            });
                        }
                        else {
                            try {
                                BufferedReader br = new BufferedReader(new FileReader(path));
                                String a = "";
                                String b = "";
                                while ((a = br.readLine()) != null) {
                                    b += a + "\n";
                                }
//                                area.setText(b);
                                f1.setVisible(false);
                                displayframe2(name,b);
                                br.close();
                            } catch (Exception x) {
                                x.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        f1.add(b0);

        //Second Button
        final JButton b1 = new JButton("Open CSV as List View");
        b1.setBounds(a,70+b,200,30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b1)
                {
                    JFileChooser choose = new JFileChooser();
                    int i = choose.showOpenDialog(null);
                    if(i==JFileChooser.APPROVE_OPTION)
                    {
                        File file1 = choose.getSelectedFile();
                        String name = file1.getName();
                        final String path = file1.getPath();

                        final String filename = file1.getName();
                        String extension = "";
                        int index = filename.lastIndexOf('.');
                        if (index > 0) {
                            extension = filename.substring(index+1);
                        }
                        System.out.println(extension);

                        if(extension.equals("csv"))
                        {
                            Model m = new Model();
                            m.ReadFile(path);
                            m.holdPatient();
                            ArrayList<String> list = new ArrayList<String>();
                            list = m.storeListAllLast();

                            ListView k = new ListView(list,path);
                            f1.setVisible(false);


                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"please select a csv file");
                        }
                    }
                }
            }

        });
        f1.add(b1);

        //Third Button
        final JButton b2 = new JButton("Search by name");
        b2.setBounds(a,110+b,200,30);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b2)
                {
                    JFileChooser choose = new JFileChooser();
                    int i = choose.showOpenDialog(null);
                    if(i==JFileChooser.APPROVE_OPTION)
                    {
                        File file1 = choose.getSelectedFile();
                        String name = file1.getName();
                        final String path = file1.getPath();

                        final String filename = file1.getName();
                        String extension = "";
                        int index = filename.lastIndexOf('.');
                        if (index > 0) {
                            extension = filename.substring(index+1);
                        }
                        System.out.println(extension);

                        if(extension.equals("csv"))
                        {
                            Model m = new Model();
                            m.ReadFile(path);
                            m.holdPatient();
                            ArrayList<String> listfirstname,listlastname;
                            listfirstname = m.storeListAllFirst();
                            listlastname  = m.storeListAllLast();

                            new SearchByName(listfirstname,listlastname,path);
                            f1.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"please select a csv file");
                        }
                    }
                }
            }

        });
        f1.add(b2);

        //Fourth Button
        final JButton b3 = new JButton("Statistics");
        b3.setBounds(a,150+b,200,30);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b3)
                {
                    JFileChooser choose = new JFileChooser();
                    int i = choose.showOpenDialog(null);
                    if(i==JFileChooser.APPROVE_OPTION)
                    {
                        File file1 = choose.getSelectedFile();
                        String name = file1.getName();
                        final String path = file1.getPath();

                        final String filename = file1.getName();
                        String extension = "";
                        int index = filename.lastIndexOf('.');
                        if (index > 0) {
                            extension = filename.substring(index+1);
                        }
                        System.out.println(extension);

                        if(extension.equals("csv"))
                        {
                            Model m = new Model();
                            m.ReadFile(path);
                            m.holdPatient();
                            ArrayList<Integer> agelist;
                            agelist=m.storeAllAge();

                            ArrayList<Integer> birthlist;
                            birthlist=m.storeAllBirthyear();

                            new Statistics(agelist,birthlist);
                            f1.setVisible(false);

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"please select a csv file");
                        }
                    }
                }

            }
        });
        f1.add(b3);


//====================================================================================================================================
        JMenuBar menubar = new JMenuBar();
        final JMenu file = new JMenu("File");
        final JMenuItem open = new JMenuItem("Open");
        menubar.setBounds(0,0,500,20);
        file.add(open);

        final JMenuItem open2 = new JMenuItem("Open CSV");
        menubar.add(file);

        f1.add(menubar);

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==open)
                {
                    JFileChooser choose = new JFileChooser();
                    int i = choose.showOpenDialog(null);
                    if(i==JFileChooser.APPROVE_OPTION)
                    {
                        File file1 = choose.getSelectedFile();
                        String name = file1.getName();
                        final String path = file1.getPath();

                        final String filename = file1.getName();
                        String extension = "";
                        int index = filename.lastIndexOf('.');
                        if (index > 0) {
                            extension = filename.substring(index+1);
                        }
                        System.out.println(extension);

                        if(extension.equals("csv"))
                        {
                            javax.swing.SwingUtilities.invokeLater(new Runnable()
                            {
                                public void run()
                                {
                                    LoadCSV p = new LoadCSV();
                                    p.frame(filename,path);
                                    f1.setVisible(false);
                                }
                            });
                        }
                        else {
                            try {
                                BufferedReader br = new BufferedReader(new FileReader(path));
                                String a = "";
                                String b = "";
                                while ((a = br.readLine()) != null) {
                                    b += a + "\n";
                                }
//                                area.setText(b);
                                f1.setVisible(false);
                                displayframe2(name,b);
                                br.close();
                            } catch (Exception x) {
                                x.printStackTrace();
                            }
                        }
                    }
                }
            }
        });


        f1.setSize(500,400);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f1.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(f1, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }

            public void windowClosed(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void displayframe2(String s,String texttobeshown)
    {
        final JFrame f22 = new JFrame(s);


        JTextArea area = new JTextArea(30,60);
        area.setBorder(new TitledBorder(new EtchedBorder(),"Notepad"));
        area.setEditable(false);
        area.setText(texttobeshown);
        area.setCaretPosition(0);
        JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



        JButton b22 = new JButton("BACK");
        b22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f22.setVisible(false);
                displayFrame1();
            }
        });

        b22.setBounds(0,0,100,30);




        f22.setBounds(0,0,700,700);

        f22.setLayout(new BorderLayout());


        f22.add(scroll,BorderLayout.CENTER);

        f22.add(b22,BorderLayout.SOUTH);
        f22.pack();
        f22.setLocationRelativeTo(null);
        f22.setVisible(true);
    }

}
