package com.aurora.screens.search;

import javax.swing.*;
import java.awt.*;

public class BookPropertiesComponent extends JPanel {
    JLabel lblResourceId, lblTitle, lblAuthor, lblYearPublication, lblStock;

    public BookPropertiesComponent() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor  = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        lblResourceId = new JLabel("ID interno:");
        lblTitle = new JLabel("Title");
        lblAuthor = new JLabel("Author");
        lblYearPublication = new JLabel("Year Publication");
        lblStock = new JLabel("Stock");
        this.add(lblResourceId, gbc);
        gbc.gridx++;
        this.add(lblTitle, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        this.add(lblAuthor, gbc);
        gbc.gridx++;
        this.add(lblYearPublication, gbc);
        gbc.gridx++;
        this.add(lblStock, gbc);

    }
}
