package logic;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {

    public ChessFrame() {
        ChessGame game = new ChessGame();

        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel statusLabel = new JLabel("Turn: white");
        BoardPanel boardPanel = new BoardPanel(game, statusLabel);

        JPanel topPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        saveButton.addActionListener(e -> game.saveGame("chess_save.bin"));
        loadButton.addActionListener(e -> {
            game.loadGame("chess_save.bin");
            statusLabel.setText("Turn: " + game.getTurnColor());
            boardPanel.refreshBoard();
        });

        topPanel.add(saveButton);
        topPanel.add(loadButton);

        add(topPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
