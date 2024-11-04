package com.aurora.screens.create;

import com.aurora.database.models.CDModel;
import com.aurora.database.models.ResourceTypeEnum;

import javax.swing.*;
import java.awt.*;

public class AddCDFormComponent extends JPanel {
    JTextField titleTextField, artistTextField, genreTextField, numSongsTextField, stockTextField, durationTextField;
    public AddCDFormComponent() {
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
        add(new JLabel("Artista: "), gbc);
        gbc.gridx++;
        this.artistTextField = new JTextField(10);
        add(this.artistTextField, gbc);

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

        gbc.gridy++;

        gbc.gridx=0;
        add(new JLabel("Número de canciones: "), gbc);
        gbc.gridx++;
        this.numSongsTextField = new JTextField(6);
        add(this.numSongsTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Unidades Disponibles: "), gbc);
        gbc.gridx++;
        this.stockTextField = new JTextField(6);
        add(this.stockTextField, gbc);

    }

    public CDModel getCDModel(){
        String title = titleTextField.getText();
        String artist = artistTextField.getText();
        String genre = genreTextField.getText();
        String duration = durationTextField.getText();
        String numSongs = numSongsTextField.getText();
        String stock = stockTextField.getText();

        return new CDModel(title,
                ResourceTypeEnum.CD,
                artist,
                genre,
                duration,
                numSongs,
                stock);
    }
}
