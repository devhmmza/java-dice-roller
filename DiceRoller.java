import javax.swing.*;
import java.awt.*;          
import java.awt.event.*;    
import java.util.Random;    

public class DiceRoller extends JFrame {
    private JLabel diceLabel;
    private JButton rollButton;
    private ImageIcon[] diceIcons;
    private Random random;

    public DiceRoller() {
        setTitle("Java Dice Roller");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        diceLabel = new JLabel();
        diceLabel.setHorizontalAlignment(JLabel.CENTER);

        System.out.println("Working directory: " + System.getProperty("user.dir"));
        loadDiceImages(); 
        if (diceIcons[0] != null) {
            diceLabel.setIcon(diceIcons[0]); 
        }

        rollButton = new JButton("Roll Dice 🎲");
        rollButton.setFont(new Font("Arial", Font.BOLD, 18));
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollDiceOnce();
            }
        });

        add(diceLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);

        random = new Random();
        setVisible(true);
    }

    private void loadDiceImages() {
        diceIcons = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            String filename = "dice" + (i + 1) + ".png";
            ImageIcon icon = new ImageIcon(filename);

            if (icon.getIconWidth() == -1) {
                System.out.println("Failed to load image: " + filename);
                diceIcons[i] = null;
            } else {
                
                Image scaled = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                diceIcons[i] = new ImageIcon(scaled);
                System.out.println("Loaded: " + filename);
            }
        }
    }

    private void rollDiceOnce() {
        int roll = random.nextInt(6); 
        if (diceIcons[roll] != null) {
            diceLabel.setIcon(diceIcons[roll]);
        }
    }

    public static void main(String[] args) {
        new DiceRoller();
    }
}
