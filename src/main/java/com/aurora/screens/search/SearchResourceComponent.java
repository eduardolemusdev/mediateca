package com.aurora.screens.search;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SearchResourceComponent extends JPanel {
    JTextField searchField;
    JButton searchButton;

    public SearchResourceComponent() {
        this.setLayout(new GridBagLayout());
        this.setBorder(new CompoundBorder(new TitledBorder("Buscador"), new EmptyBorder(10, 10, 10, 10)));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor  = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(new JLabel("Search:"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add((this.searchField = new JTextField(10)), gbc);

        gbc.gridx++;
        add((this.searchButton = new JButton("Buscar")), gbc);

    }
}
