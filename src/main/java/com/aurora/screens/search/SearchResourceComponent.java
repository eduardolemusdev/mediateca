package com.aurora.screens.search;

import com.aurora.database.DatabaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchResourceComponent extends JPanel {
    JTextField searchField;
    JButton searchButton;

    JPanel propertiesContainer;
    private Connection connection;
    private void initConnection(){
        try {
            this.connection = DatabaseConnection.getConnection();
        }catch (SQLException e){
            logger.error(e.getMessage());
        }
    }
    private Logger logger = LogManager.getLogger();

    public SearchResourceComponent(JPanel propertiesContainer) {
        this.propertiesContainer = propertiesContainer;

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
        add((this.searchButton = new JButton("Buscar por ID:")), gbc);

        initConnection();
        this.handleSearch();
    }

    public void handleSearch(){
        this.searchButton.addActionListener((ActionEvent ev) -> {
            String text = this.searchField.getText();
            PreparedStatement searchResourceStatement = null;
            String searchQuery = "select * from material_metada where id = ?";
            try {
                searchResourceStatement = this.connection.prepareStatement(searchQuery);
                searchResourceStatement.setString(1, text);
                ResultSet rs = searchResourceStatement.executeQuery();

                if (rs.next()){
                    this.propertiesContainer.remove(0);
                    logger.info(rs.getString("material_type"));
                }else{
                    JOptionPane.showMessageDialog(this, "No se encontro el registro");
                }

            }catch (SQLException e){
                logger.error(e.getMessage());
            }finally {
                DatabaseConnection.close(this.connection);
                DatabaseConnection.close(searchResourceStatement);
            }

        });
    }
}
