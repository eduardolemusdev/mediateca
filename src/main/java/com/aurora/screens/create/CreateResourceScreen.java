package com.aurora.screens.create;

import com.aurora.database.InsertResourcesService;
import com.aurora.database.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CreateResourceScreen extends JPanel{
    JPanel formsContainer =new JPanel();
    JButton saveButton = new JButton("Crear nuevo recurso");
    public CreateResourceScreen() {
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        //Forms
        AddBookFormComponent addBookFormComponent = new AddBookFormComponent();
        AddCDFormComponent addCDFormComponent = new AddCDFormComponent();
        AddMagazineFormComponent addMagazineFormComponent = new AddMagazineFormComponent();
        AddDVDComponent addDVDComponent = new AddDVDComponent();

        ResourceTypeSelectComponent resourceTypeSelectComponent = new ResourceTypeSelectComponent(formsContainer, addBookFormComponent, addMagazineFormComponent, addCDFormComponent, addDVDComponent);

        add(resourceTypeSelectComponent, gbc);
        gbc.gridy++;
        add(formsContainer, gbc);
        gbc.gridy++;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(saveButton, gbc);

        gbc.gridy++;
        gbc.weighty = 1; // Peso adicional para llenar el espacio sobrante
        add(Box.createGlue(), gbc);



        //events
        this.handleSaveButton(resourceTypeSelectComponent, addBookFormComponent, addMagazineFormComponent, addCDFormComponent, addDVDComponent);
    }


    public void handleSaveButton(ResourceTypeSelectComponent r, AddBookFormComponent addBook, AddMagazineFormComponent addMagazine, AddCDFormComponent addCd, AddDVDComponent addDvd){
        InsertResourcesService resourcesRepository = new InsertResourcesService();

        this.saveButton.addActionListener((ActionEvent e) -> {
            Integer currentIndex = r.getCurrentResourceType();

            switch (currentIndex){
                case 0:
                    BookModel bookModel = addBook.getBookModel();
                    resourcesRepository.insert(bookModel);
                    break;
                case 1:
                    MagazineModel magazineModel = addMagazine.getMagazineModel();
                    resourcesRepository.insert(magazineModel);
                    break;
                case 2:
                    CDModel cdModel = addCd.getCDModel();
                    resourcesRepository.insert(cdModel);
                    break;
                case 3:
                    DVDModel dvdModel = addDvd.getDVDModel();
                    resourcesRepository.insert(dvdModel);
                    break;
            }


        });
    }
}
