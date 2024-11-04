package com.aurora.screens.create;

import com.aurora.database.models.MagazineModel;
import com.aurora.database.models.ResourceTypeEnum;

import javax.swing.*;
import java.awt.*;

public class AddMagazineFormComponent extends JPanel{
    JTextField titleTexField, editorialTextField, publicationDateTextField, stockTextField;
    JComboBox<String> periodicityCombo;
    public AddMagazineFormComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Titulo: "), gbc);
        gbc.gridx++;
        this.titleTexField = new JTextField(10);
        add(this.titleTexField, gbc);

        gbc.gridx++;
        add(new JLabel("Editorial: "), gbc);
        gbc.gridx++;
        this.editorialTextField = new JTextField(10);
        add(this.editorialTextField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        add(new JLabel("Periodicidad: "), gbc);
        gbc.gridx++;
        String[] frecuencies = {
                "DIARIO",
                "SEMANAL",
                "QUINCENAL",
                "MENSUAL",
                "BIMESTRAL",
                "TRIMESTRAL",
                "SEMESTRAL",
                "ANUAL"
        };
        this.periodicityCombo = new JComboBox<>(frecuencies);
        add(periodicityCombo, gbc);

        gbc.gridx++;
        add(new JLabel("Fecha de publicación: "), gbc);
        gbc.gridx++;
        this.publicationDateTextField = new JTextField(10);
        add(this.publicationDateTextField, gbc);

        gbc.gridy++;

        gbc.gridx=0;
        add(new JLabel("Uniades Disponibles: "), gbc);
        gbc.gridx++;
        this.stockTextField = new JTextField(10);
        add(this.stockTextField, gbc);
    }

    public MagazineModel getMagazineModel(){
        String title = this.titleTexField.getText();
        String editorial = this.editorialTextField.getText();
        String periodicity = this.periodicityCombo.getSelectedItem().toString();
        String publicationDate = this.publicationDateTextField.getText();
        Integer stock = Integer.parseInt(this.stockTextField.getText());

        MagazineModel magazineModel = new MagazineModel(
                title,
                ResourceTypeEnum.MAGAZINE,
                editorial,
                periodicity,
                publicationDate,
                stock
        );

        return magazineModel;
    }
}
