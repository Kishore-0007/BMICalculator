import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {

    private JTextField heightField, weightField;
    private JLabel resultLabel;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initUI() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Height (in cm)"));
        heightField = new JTextField();
        inputPanel.add(heightField);

        inputPanel.add(new JLabel("Weight (in kg)"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        resultLabel = new JLabel();
        add(resultLabel, BorderLayout.CENTER);
    }

    private void calculateBMI() {
        String heightStr = heightField.getText();
        String weightStr = weightField.getText();

        if (heightStr.isEmpty() || !heightStr.matches("\\d+")) {
            resultLabel.setText("Provide a valid Height!");
        } else if (weightStr.isEmpty() || !weightStr.matches("\\d+")) {
            resultLabel.setText("Provide a valid Weight!");
        } else {
            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);

            double bmi = (weight / ((height * height) / 10000));

            if (bmi < 18.6) {
                resultLabel.setText("Under Weight: " + String.format("%.2f", bmi));
            } else if (bmi >= 18.6 && bmi < 24.9) {
                resultLabel.setText("Normal: " + String.format("%.2f", bmi));
            } else {
                resultLabel.setText("Over Weight: " + String.format("%.2f", bmi));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMICalculator());
    }
}
