package com.aurora.screens;

import com.aurora.screens.create.CreateResourceScreen;
import com.aurora.screens.list.ListResourcesScreen;
import com.aurora.screens.search.BookPropertiesComponent;
import com.aurora.screens.search.ResourceTypeComponent;
import com.aurora.screens.search.SearchResourceComponent;

import javax.swing.*;
import java.awt.*;

public class MediatecaScreen extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();

    private void buildInterface(){
        this.buildMainMediatecaScreen();
    }

    private void buildMainMediatecaScreen(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();


        SearchResourceComponent searchResourcePanel =  new SearchResourceComponent();
        BookPropertiesComponent bookFormPanel =  new BookPropertiesComponent();
        ResourceTypeComponent selectResourceType =  new ResourceTypeComponent();

        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1;
        gbcMain.weighty = 1;

        gbcMain.fill = GridBagConstraints.HORIZONTAL;

        gbcMain.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(searchResourcePanel, gbcMain);
        gbcMain.gridy++;
        mainPanel.add(selectResourceType, gbcMain);
        gbcMain.gridy++;
        mainPanel.add(bookFormPanel, gbcMain);


        //Sscreens

        CreateResourceScreen createResourceScreen = new CreateResourceScreen();
        ListResourcesScreen listResourcesScreen = new ListResourcesScreen();

        this.tabbedPane.addTab("Buscar", mainPanel);
        this.tabbedPane.addTab("Añadir", createResourceScreen);
        this.tabbedPane.addTab("Listar", listResourcesScreen);
    }





    public void runScreen(){
        this.buildInterface();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.tabbedPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(600, 400);
        this.setTitle("Mediateca");

    }
}
