package com.aurora.services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchResourceService {
    private JButton searchButton;
    public SearchResourceService(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public void handleSearchEvent(){
        this.searchButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, searchButton.getText());
        });
    }
}
