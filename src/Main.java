import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

class AgeCalculator extends JFrame implements ActionListener {

    private JTextField dayField, monthField, yearField;
    private JLabel resultLabel;
    private JButton calculateButton;

    public AgeCalculator() {
        setTitle("Age Calculator");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout
        setLayout(new GridLayout(6, 2, 10, 10));

        // Components
        add(new JLabel("Enter Birth Day (DD):"));
        dayField = new JTextField();
        add(dayField);

        add(new JLabel("Enter Birth Month (MM):"));
        monthField = new JTextField();
        add(monthField);

        add(new JLabel("Enter Birth Year (YYYY):"));
        yearField = new JTextField();
        add(yearField);

        calculateButton = new JButton("Calculate Age");
        calculateButton.addActionListener(this);
        add(calculateButton);

        resultLabel = new JLabel("Your age will appear here.");
        resultLabel.setForeground(Color.BLUE);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int day = Integer.parseInt(dayField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());

            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                resultLabel.setText("Birth date cannot be in the future!");
                return;
            }

            Period age = Period.between(birthDate, currentDate);

            resultLabel.setText("Age: " + age.getYears() + " Years, "
                    + age.getMonths() + " Months, "
                    + age.getDays() + " Days");

        } catch (Exception ex) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}
