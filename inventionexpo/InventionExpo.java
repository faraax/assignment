package inventionexpo;

import javax.swing.*;
import java.util.ArrayList;

public class InventionExpo {
    public static void main(String[] args) {
        new InventionExpo().init();
    }

    private void init() {
        ArrayList<Inventor> inventors = new ArrayList<>(); // Change to Inventor
        int numOfInventors = 0;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(
                        "Welcome to the invention expo competition! \nPlease enter the number of inventors:");
                numOfInventors = Integer.parseInt(input);
                if (numOfInventors > 0)
                    break;
                else
                    JOptionPane.showMessageDialog(null, "Please enter a Valid Positive Number Greater than zero");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Input. Please Enter a valid Integer");
            }
        }
        for (int i = 0; i < numOfInventors; i++) {
            String name;
            int score = 0;
            while (true) {
                name = JOptionPane.showInputDialog("Please enter the name of the inventor " + (i + 1) + ":"); // Fixed index
                if (name != null && !name.trim().isEmpty())
                    break;
                JOptionPane.showMessageDialog(null, "Name Cannot be empty. Please enter a valid name");
            }
            while (true) {
                try {
                    String scoreInput = JOptionPane.showInputDialog(
                            "Please Enter the score for invention of inventor " + (i + 1) + " (out of 100):"); // Fixed index
                    score = Integer.parseInt(scoreInput);
                    if (score >= 1 && score <= 100)
                        break;
                    else
                        JOptionPane.showMessageDialog(null, "Enter a number between 1 and 100");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a valid Integer ");
                }
            }
            inventors.add(new Inventor(name, score)); // Corrected type to Inventor
        }
        Inventor topInventor = findTopInventor(inventors); // Corrected type to Inventor
        JOptionPane.showMessageDialog(null, "The top inventor is " + topInventor.getName()
                + " with an invention score of: " + topInventor.getScore() + " out of 100");
        JOptionPane.showMessageDialog(null,
                "Thanks for participating in the expo competition\nDeveloped by BC210426301");
    }

    public Inventor findTopInventor(ArrayList<Inventor> inventors) { // Corrected type to Inventor
        Inventor topInventor = inventors.get(0);
        for (Inventor inventor : inventors) {
            if (inventor.getScore() > topInventor.getScore()) {
                topInventor = inventor;
            }
        }
        return topInventor; // Move the return statement outside the loop
    }

    private class Inventor {
        private String name;
        private int score;

        public Inventor() {
        }

        public Inventor(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public Inventor(Inventor other) {
            this.name = other.name;
            this.score = other.score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
