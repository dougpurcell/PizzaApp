import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApp {
    private JLabel sizeLabel;
    private JRadioButton sizeSmall;
    private JRadioButton sizeMed;
    private JRadioButton sizeLarge;
    private JCheckBox sausage;
    private JCheckBox pepperoni;
    private JCheckBox salami;
    private JLabel toppingsLabel;
    private JCheckBox olives;
    private JCheckBox mushrooms;
    private JCheckBox anchovies;
    private JTextField price;
    private JLabel priceLabel;
    private JButton calculateButton;
    private JButton exitButton;
    private JPanel mainPanel;

    private double totalCost;
    final double smallCost = 6.99;
    final double mediumCost = 8.99;
    final double largeCost = 10.99;
    private double sausageCost = 1.49;
    private double pepperoniCost = 1.49;
    private double salamiCost = 1.49;
    private double olivesCost = 0.99;
    private double mushroomsCost = 0.99;
    private double anchoviesCost = 0.99;

    ButtonGroup sizeRadioGroup;


    public PizzaApp() {
        price.setEditable(false);

        sizeRadioGroup = new ButtonGroup();
        sizeRadioGroup.add(sizeSmall);
        sizeRadioGroup.add(sizeMed);
        sizeRadioGroup.add(sizeLarge);

        calculateButton.addActionListener(new ActionListener() { // set calculate button to display the text
            @Override
            public void actionPerformed(ActionEvent e) {
                price.setText("$ "+ totalCost);
                System.out.println(totalCost);
            }
        });

        exitButton.addActionListener(new ActionListener() { // close the application
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        sizeSmall.addActionListener(new ActionListener() { //add small price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                totalCost = totalCost + smallCost;

            }
        });
        sizeMed.addActionListener(new ActionListener() { //add medium price to total.
            @Override
            public void actionPerformed(ActionEvent e) {
                totalCost = totalCost + mediumCost;
            }
        });
        //TODO: set up large.
        //TODO: set up checkboxes for toppings.
        //TODO: calculator must reset if Small/Medium/Large is selected after calculation.
        //TODO: calculator must remove toppings cost if checkbox is unchecked by user.

    }

    public double Total() {
        return totalCost;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza App");
        frame.setContentPane(new PizzaApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
