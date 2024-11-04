package com.aurora.screens.list;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ListResourcesScreen extends JPanel {
    JComboBox<String> resourceTypeComboBox;
    JTable listTable = new JTable();
    DefaultTableModel listTableModel = new DefaultTableModel();


    public ListResourcesScreen() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.listTable.setModel(this.listTableModel);

        JScrollPane scrollPane = new JScrollPane(this.listTable);
        scrollPane.setPreferredSize(new Dimension(650, 375));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel resourceTypePanel = new JPanel();

        resourceTypePanel.add(new JLabel("Tipo de recurso: "),gbc);

        this.resourceTypeComboBox = new JComboBox<>();
        this.resourceTypeComboBox.addItem("1. Libro");
        this.resourceTypeComboBox.addItem("2. Revista");
        this.resourceTypeComboBox.addItem("3. CD");
        this.resourceTypeComboBox.addItem("4. DVD");
        resourceTypePanel.add(resourceTypeComboBox, gbc);
        this.add(resourceTypePanel, gbc);

        gbc.gridy++;
        this.add(scrollPane, gbc);

        gbc.gridy++;
        gbc.weighty = 1; // Peso adicional para llenar el espacio sobrante
        add(Box.createGlue(), gbc);

        this.loadBooks();
        this.resourceTypeChanged();

    }

    public void resourceTypeChanged() {
        this.resourceTypeComboBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                this.listTableModel.setColumnCount(0);
                this.listTableModel.setRowCount(0);

                switch (resourceTypeComboBox.getSelectedIndex()) {
                    case 0:
                        this.loadBooks();
                        break;
                    case 1:
                        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Editorial", "Periodicidad", "Fecha de publicación","Unidades Disponibles"});
                        break;
                    case 2:
                        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Artista","Género","Duración","Número de canciones","Unidades Disponibles"});
                        break;
                    case 3:
                        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Director","Género","Duración"});
                        break;
                }
            }
        });
    }

    public void loadBooks(){
        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Autor", "Número de páginas", "Editorial","ISBN","Año de Publicación","Unidades Disponibles"});
    }
}
