/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volumeprice;

// imports
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 *
 * @author wesley
 */
public class VolumePrice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variables
        final double COST_PER_CUBIC_FOOT = 0.23;
        final double CHARGE_PER_CUBIC_FOOT = 0.5;
        double tmp, volume, cost, charge, profit, percent;
        double length = 1;
        double width = 1;
        double height = 1;
        final String l = "length";
        final String w = "width";
        final String h = "height";
        String input;
        String question = "What is the %s of the crate?";
        String[] types = new String[]{l,w,h};
        
        for (int i = 0; i < 3; i++ ) {
            // ask each question
            input = JOptionPane.showInputDialog(question.replace("%s", types[i]));
            
            // validate
            try {
                tmp = Double.parseDouble(input);
            
                // assign vars
                switch(types[i]){
                    case l:
                        length = tmp;
                        break;
                    case w:
                        width = tmp;
                        break;
                    case h:
                        height = tmp;
                        break;
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.exit(-1);
            }
        }
        
        // calc
        volume = length * width * height;
        cost = COST_PER_CUBIC_FOOT * volume;
        charge = CHARGE_PER_CUBIC_FOOT * volume;
        profit = charge - cost;
        percent = ((profit/cost)-1)*100;
        
        // display
        JOptionPane.showMessageDialog(null, 
                "The volume of the crate to build is "
                + volume + " in cubic ft. \nIt will cost you $"
                + new DecimalFormat("#0.00").format(cost) + " to create. \n"
                + "This will cost the customer $"
                + new DecimalFormat("#0.00").format(charge) 
                + ". \nYou will make a " + (int) percent
                + "% profit, \nwhich amounts to $"
                + new DecimalFormat("#0.00").format(profit) + " dollars.");
    }
    
}
