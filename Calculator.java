import javax.swing.JOptionPane;
public class Calculator {
    public static void main(String[] args){
        String strNum1 = JOptionPane.showInputDialog("Enter first number:");
        String strNum2 = JOptionPane.showInputDialog("Enter second number:");
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;

        String result;

        if(num2 !=0){
            double quot = num1 / num2;
            result = "Sum: " + sum + "\n" + "Difference: " + diff + "\n" + "Product: " + prod + "\n" + "Quotient: " + quot + "\n"; 
        }
        else{
            result = "Sum: " + sum + "\n" + "Difference: " + diff + "\n" + "Product: " + prod + "\n" + "Cannot be divided by 0." + "\n"; 
        }

        JOptionPane.showMessageDialog(null, result);
    }
}
