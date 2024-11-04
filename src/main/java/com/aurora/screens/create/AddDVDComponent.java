package com.aurora.screens.create;

import com.aurora.database.models.DVDModel;
import com.aurora.database.models.ResourceTypeEnum;

import javax.swing.*;
import java.awt.*;

public class AddDVDComponent extends JPanel {
    JTextField titleTextField, directorTextField, genreTextField, durationTextField;
    public AddDVDComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Titulo: "), gbc);
        gbc.gridx++;
        this.titleTextField = new JTextField(10);
        add(this.titleTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Director: "), gbc);
        gbc.gridx++;
        this.directorTextField = new JTextField(10);
        add(this.directorTextField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        add(new JLabel("Género: "), gbc);
        gbc.gridx++;
        this.genreTextField = new JTextField(10);
        add(this.genreTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Duración: "), gbc);
        gbc.gridx++;
        this.durationTextField = new JTextField(10);
        add(this.durationTextField, gbc);


    }




    public DVDModel getDVDModel() {
        String title = this.titleTextField.getText();
        String director = this.directorTextField.getText();
        String genre = this.genreTextField.getText();
        String duration = this.durationTextField.getText();

        return new DVDModel(title, ResourceTypeEnum.DVD, director,duration, genre);
    }
}
