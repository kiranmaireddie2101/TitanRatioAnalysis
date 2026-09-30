import financialdata.FinancialDataForm;

import javax.swing.*;

public class MainDashBoard extends JFrame {

    public MainDashBoard() {

        setTitle("Titan Company - Ratio Analysis Dashboard");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel(
                "TITAN COMPANY LIMITED"
        );

        title.setBounds(180, 30, 300, 30);
        panel.add(title);

        JLabel subtitle = new JLabel(
                "Ratio Analysis System"
        );

        subtitle.setBounds(220, 60, 200, 25);
        panel.add(subtitle);

        JButton addData = new JButton(
                "Enter Financial Data"
        );

        addData.setBounds(180, 110, 240, 40);
        panel.add(addData);

        JButton manageData = new JButton(
                "Manage Financial Data"
        );

        manageData.setBounds(180, 170, 240, 40);
        panel.add(manageData);

        JButton calculate = new JButton(
                "Calculate Ratios"
        );

        calculate.setBounds(180, 230, 240, 40);
        panel.add(calculate);

        JButton report = new JButton(
                "View Report"
        );

        report.setBounds(180, 290, 240, 40);
        panel.add(report);

        JButton exit = new JButton(
                "Exit"
        );

        exit.setBounds(180, 350, 240, 40);
        panel.add(exit);

        addData.addActionListener(e ->
                new FinancialDataForm().setVisible(true)
        );

        manageData.addActionListener(e ->
                new ManageFinancialData()
        );

        calculate.addActionListener(e ->
                new RatioAnalysis()
        );

        report.addActionListener(e ->
                new Report()
        );

        exit.addActionListener(e ->
                System.exit(0)
        );


        add(panel);
        setVisible(true);
    }
}