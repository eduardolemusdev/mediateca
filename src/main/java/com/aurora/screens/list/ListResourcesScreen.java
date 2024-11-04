package com.aurora.screens.list;

import com.aurora.database.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.*;

public class ListResourcesScreen extends JPanel {
    JComboBox<String> resourceTypeComboBox;
    JTable listTable = new JTable();
    DefaultTableModel listTableModel = new DefaultTableModel();
    private final Logger logger = LogManager.getLogger();

     Connection connection;
    private void initConnection(){
        try {
            this.connection = DatabaseConnection.getConnection();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }



    public ListResourcesScreen() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.listTable.setModel(this.listTableModel);

        JScrollPane scrollPane = new JScrollPane(this.listTable);
        scrollPane.setPreferredSize(new Dimension(650, 375));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;

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

        initConnection();

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
                        this.loadMagazines();
                        break;
                    case 2:
                        this.loadCds();
                        break;
                    case 3:
                        this.loadDVDs();
                        break;
                }
            }
        });
    }

    public void loadBooks(){
        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Autor", "Número de páginas", "Editorial","ISBN","Año de Publicación","Unidades Disponibles"});
        PreparedStatement selectStatement = null;
        try {
            String selectBooks = "select * from books inner join material_metadata on books.material_id = material_metadata.id";


             selectStatement = connection.prepareStatement(selectBooks);
            ResultSet rs = selectStatement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int numberOfColumns = meta.getColumnCount();

            //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];

                fila[0] =  rs.getString("internal_id");
                fila[1] =  rs.getString("title");
                fila[2] =  rs.getString("author");
                fila[3] =  rs.getString("num_pages");
                fila[4] =  rs.getString("editorial");
                fila[5] =  rs.getString("isbn");
                fila[6] =  rs.getString("publication_date");
                fila[7] =  rs.getString("stock");

                listTableModel.addRow(fila);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            DatabaseConnection.close(selectStatement);
        }

    }

   public void loadMagazines(){
        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Editorial", "Periodicidad", "Fecha de Publicación","Unidades Disponibles"});
        PreparedStatement selectStatement = null;
        try {
            String selectBooks = "select * from magazines inner join material_metadata on magazines.material_id = material_metadata.id";


            selectStatement = connection.prepareStatement(selectBooks);
            ResultSet rs = selectStatement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int numberOfColumns = meta.getColumnCount();

            //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];

                fila[0] =  rs.getString("internal_id");
                fila[1] =  rs.getString("title");
                fila[2] =  rs.getString("editorial");
                fila[3] =  rs.getString("periodicity");
                fila[4] =  rs.getString("publication_date");
                fila[5] =  rs.getString("stock");

                listTableModel.addRow(fila);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            DatabaseConnection.close(selectStatement);
        }

    }
    public void loadCds(){
        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Artista", "Género", "Duración","Número de Canciones", "Unidades Disponibles"});
        PreparedStatement selectStatement = null;
        try {
            String selectBooks = "select * from cds inner join material_metadata on cds.material_id = material_metadata.id";


            selectStatement = connection.prepareStatement(selectBooks);
            ResultSet rs = selectStatement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int numberOfColumns = meta.getColumnCount();

            //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];

                fila[0] =  rs.getString("internal_id");
                fila[1] =  rs.getString("title");
                fila[2] =  rs.getString("artist");
                fila[3] =  rs.getString("gender");
                fila[4] =  rs.getString("duration");
                fila[5] =  rs.getString("num_songs");
                fila[6] =  rs.getString("stock");

                listTableModel.addRow(fila);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            DatabaseConnection.close(selectStatement);
        }

    }
    public void loadDVDs(){
        this.listTableModel.setColumnIdentifiers(new String[]{"ID","Título","Director", "Género", "Duración"});
        PreparedStatement selectStatement = null;
        try {
            String selectBooks = "select * from dvds inner join material_metadata on dvds.material_id = material_metadata.id";


            selectStatement = connection.prepareStatement(selectBooks);
            ResultSet rs = selectStatement.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            int numberOfColumns = meta.getColumnCount();

            //Creandolasfilaspara el JTable
            while (rs.next()) {
                Object[] fila = new Object[numberOfColumns];

                fila[0] =  rs.getString("internal_id");
                fila[1] =  rs.getString("title");
                fila[2] =  rs.getString("director");
                fila[3] =  rs.getString("gender");
                fila[4] =  rs.getString("duration");

                listTableModel.addRow(fila);
            }
        }catch (SQLException e){
            logger.error(e.getMessage());
        }finally {
            DatabaseConnection.close(selectStatement);
        }

    }
}
