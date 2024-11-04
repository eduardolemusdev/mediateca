package com.aurora.screens.search;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ResourceTypeComponent extends JPanel {
    JRadioButton bookResource, revResource, cdResource, vhsResource;
    ButtonGroup resourceTypeGroup;

    public ResourceTypeComponent() {
        this.setLayout(new GridBagLayout());
        this.setBorder(new CompoundBorder(new TitledBorder("Tipo de recurso"), new EmptyBorder(10, 10, 10, 10)));
        GridBagConstraints gbc = new GridBagConstraints();

        this.resourceTypeGroup = new ButtonGroup();

        gbc.gridx = 0;
        gbc.gridy = 0;

        bookResource = new JRadioButton("Libro");
        revResource = new JRadioButton("Revista");
        cdResource = new JRadioButton("CD");
        vhsResource = new JRadioButton("VHS");

        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(bookResource, gbc);
        resourceTypeGroup.add(bookResource);

        gbc.gridx++;
        this.add(revResource, gbc);
        resourceTypeGroup.add(revResource);

        gbc.gridx++;
        this.add(cdResource, gbc);
        resourceTypeGroup.add(cdResource);

        gbc.gridx++;
        this.add(vhsResource, gbc);
        resourceTypeGroup.add(vhsResource);

    }
}
