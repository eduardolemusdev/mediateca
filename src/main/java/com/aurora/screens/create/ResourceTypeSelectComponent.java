package com.aurora.screens.create;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ResourceTypeSelectComponent extends JPanel {
    JComboBox<String> resourceTypeComboBox;
    private JPanel addBookForm, addMagazineForm, addCDForm, addDVDForm;

    private JPanel formContainerPanel;
    public ResourceTypeSelectComponent(JPanel formContainerPanel, JPanel addBookForm, JPanel addMagazineForm, JPanel addCDForm, JPanel addDVDForm) {

        this.formContainerPanel = formContainerPanel;
        this.addBookForm = addBookForm;
        this.addMagazineForm = addMagazineForm;
        this.addCDForm = addCDForm;
        this.addDVDForm = addDVDForm;

        this.add(new JLabel("Tipo de recurso: "));

        resourceTypeComboBox = new JComboBox<>();
        resourceTypeComboBox.addItem("1. Libro");
        resourceTypeComboBox.addItem("2. Revista");
        resourceTypeComboBox.addItem("3. CD");
        resourceTypeComboBox.addItem("4. DVD");

        this.formContainerPanel.add(addBookForm);

        this.add(resourceTypeComboBox);
        this.resourceTypeChanged();
    }

    public void resourceTypeChanged() {
        this.resourceTypeComboBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                switch (resourceTypeComboBox.getSelectedIndex()) {
                    case 0:
                        this.formContainerPanel.remove(0);
                        this.formContainerPanel.add(addBookForm);
                        break;
                    case 1:
                        this.formContainerPanel.remove(0);
                        this.formContainerPanel.add(addMagazineForm);
                        break;
                    case 2:
                        this.formContainerPanel.remove(0);
                        this.formContainerPanel.add(addCDForm);
                        break;
                    case 3:
                        this.formContainerPanel.remove(0);
                        this.formContainerPanel.add(addDVDForm);
                        break;
                }
            }
        });
    }

    public Integer getCurrentResourceType() {
        return resourceTypeComboBox.getSelectedIndex();
    }
}
