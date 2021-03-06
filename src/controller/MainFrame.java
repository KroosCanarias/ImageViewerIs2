
package controller;

import commands.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import ui.ImageDisplay;
import ui.SwingImageDisplay;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;
    private Map <String, Command> commands=new HashMap<>();

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createCommands();
    }
    
    private JPanel toolbar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private Component prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get("prev").execute();
            }
        };
    }

    private Component nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get("next").execute();
            }
        };
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    private void createCommands() {
        commands.put("next", new NextCommand(imageDisplay));
        commands.put("prev", new PrevCommand(imageDisplay));
    }

}
