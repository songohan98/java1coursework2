package uk.ac.ucl.patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchByName {

    public SearchByName(final ArrayList<String> firstnames, final ArrayList<String> lastnames, final String path1)
    {
//        final String[] fnames = firstnames.toArray(new String[firstnames.size()]);
//        String[] lnames = lastnames.toArray(new String[lastnames.size()]);

        final String path = path1;
        final JFrame f41 = new JFrame("Search by name");

        JPanel inputPanel = new JPanel();
        JPanel textPanel = new JPanel();
        final JPanel displayPanel = new JPanel();
        final JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane();
        final JTextField field = new JTextField();
        JButton b41 = new JButton("Search by First Name");
        b41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(field.getText()!=null)
                {
                    String s = field.getText().toLowerCase();
                    int j = s.length();
                    for(int i=0;i<firstnames.size();i++)
                    {
                        if(s.substring(0,j-1).matches(firstnames.get(i).toLowerCase().substring(0,j-1)))
                        {

                            Model m = new Model();
                            m.ReadFile(path);
                            m.holdPatient();
                            i+=1;

                            String a="";
                            a= m.storeSinglePatient(i);
                            area.setText(a);
                        }
                    }
                }
            }
        });

        JButton b42 = new JButton("Search by Last Name");
        b41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(field.getText()!=null)
                {
                    String s = field.getText().toLowerCase();
                    int j = s.length();
                    for(int i=0;i<lastnames.size();i++)
                    {
                        if(s.substring(0,j-1).matches(lastnames.get(i).toLowerCase().substring(0,j-1)))
                        {

                            Model m = new Model();
                            m.ReadFile(path);
                            m.holdPatient();
                            i+=1;

                            String a="";
                            a= m.storeSinglePatient(i);
                            area.setText(a);
                        }
                    }
                }
            }
        });

        JButton b43 = new JButton("BACK");
        b43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PatientFinder(1);
                f41.setVisible(false);
            }
        });



        f41.setPreferredSize(new Dimension(500,500));
        f41.getContentPane().setLayout(new GridLayout());
        JSplitPane split = new JSplitPane();
        f41.getContentPane().add(split);

        split.setOrientation(JSplitPane.VERTICAL_SPLIT);
        split.setDividerLocation(50);
        split.setTopComponent(textPanel);
        split.setBottomComponent(displayPanel);

        displayPanel.setLayout(new BoxLayout(displayPanel,BoxLayout.Y_AXIS));
        displayPanel.add(scroll);
        displayPanel.add(b43);
        area.setEditable(false);
        scroll.setViewportView(area);
        textPanel.add(inputPanel);

        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        field.setPreferredSize(new Dimension(100,20));
        inputPanel.add(field);
        inputPanel.add(b41);
        inputPanel.add(b42);

        f41.pack();
        f41.setLocationRelativeTo(null);
        f41.setVisible(true);








    }

}
