import javax.swing.JOptionPane;
public class EquationSolver {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("Choose:\n1. The first-degree equation (linear equation) with one variable\n2. The system of first-degree equations (linear system) with two variables\n3. The second-degree equation with one variable");
        int option = Integer.parseInt(choice);

        switch (option) {
            case 1:
                double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a: "));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b: "));
                
                if(a==0){
                    if(b==0){
                        JOptionPane.showMessageDialog(null, "Infinite solutions");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No solution");
                    }
                }
                else{
                    double x = -b / a;
                    JOptionPane.showMessageDialog(null, "x = " + x);
                }
                break;
            
            case 2:
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
                double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));
                
                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));

                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - b1 * a21;
                
                if(D != 0){
                    double x1 = D1 / D;
                    double x2 = D2 / D;
                    JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2);
                }
                else{
                    if(D1 == 0 && D2 == 0) JOptionPane.showMessageDialog(null, "Infinite Solutions");
                    else JOptionPane.showMessageDialog(null, "No solution"); 
                }
                break;

            case 3:
                double a3 = Double.parseDouble(JOptionPane.showInputDialog("Enter a3: "));
                double b3 = Double.parseDouble(JOptionPane.showInputDialog("Enter b3: "));
                double c3 = Double.parseDouble(JOptionPane.showInputDialog("Enter c3: "));

                if (a3 == 0){
                    if (b3 == 0){
                        if (c3 == 0) JOptionPane.showMessageDialog(null, "Infinite solutions");
                        else JOptionPane.showMessageDialog(null, "No solution");
                    } 
                    else{
                        double x = -c3 / b3;
                        JOptionPane.showMessageDialog(null, "x = " + x);
                    }
                } 
                else{
                    double delta = b3 * b3 - 4 * a3 * c3;

                    if(delta > 0){
                        double x1 = (-b3 + Math.sqrt(delta)) / (2 * a3);
                        double x2 = (-b3 - Math.sqrt(delta)) / (2 * a3);
                        JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\n" + "x2 = " + x2);
                    } else if (delta == 0) {
                        double x = -b3 / (2 * a3);
                        JOptionPane.showMessageDialog(null, "Double root x = " + x);
                    } else {
                        JOptionPane.showMessageDialog(null, "No real solution");
                    }
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Invalid choice");
        }
    }
}
