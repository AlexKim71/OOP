package ua.opnu;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements ActionListener {

    // Оголошуємо кнопки як поля класу
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        // Ініціалізуємо кнопки
        rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        int n = (int)(Math.random() * 3);
        switch (n) {
            case 0: return new Rock();
            case 1: return new Scissors();
            default: return new Paper();
        }
    }

    private int checkWinner(GameShape computer, GameShape player) {
        if (computer.getClass() == player.getClass()) return 0;
        if (player instanceof Rock) {
            if (computer instanceof Scissors) return 1;
            if (computer instanceof Paper) return -1;
        } else if (player instanceof Scissors) {
            if (computer instanceof Paper) return 1;
            if (computer instanceof Rock) return -1;
        } else if (player instanceof Paper) {
            if (computer instanceof Rock) return 1;
            if (computer instanceof Scissors) return -1;
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape playerShape = null;
        if (e.getSource() == rockButton) {
            playerShape = new Rock();
        } else if (e.getSource() == scissorsButton) {
            playerShape = new Scissors();
        } else if (e.getSource() == paperButton) {
            playerShape = new Paper();
        }
        GameShape computerShape = generateShape();
        int result = checkWinner(computerShape, playerShape);

        // Сформувати повідомлення
        String message = "Player shape: " + playerShape + ". Computer shape: " + computerShape + ". ";
        switch (result) {
            case -1:
                message += "Computer has won!";
                break;
            case 0:
                message += "It's a tie!";
                break;
            case 1:
                message += "Player has won!";
        }

        // Вивести діалогове вікно з повідомленням
        JOptionPane.showMessageDialog(null, message);
    }
}
