package com.aurora.screens.create;

import com.aurora.database.models.BookModel;
import com.aurora.database.models.ResourceTypeEnum;

import javax.swing.*;
import java.awt.*;

public class AddBookFormComponent extends JPanel {
    JTextField authorTextField, titleTextField, pagesTextField, editorialTextField, isbnTextField, yearTextField, stockTextField;
    public AddBookFormComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Titulo: "), gbc);
        gbc.gridx++;
        this.titleTextField = new JTextField(10);
        add(this.titleTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Autor: "), gbc);
        gbc.gridx++;
        this.authorTextField = new JTextField(10);
        add(this.authorTextField, gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        add(new JLabel("Número de páginas: "), gbc);
        gbc.gridx++;
        this.pagesTextField = new JTextField(10);
        add(this.pagesTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Editorial: "), gbc);
        gbc.gridx++;
        this.editorialTextField = new JTextField(10);
        add(this.editorialTextField, gbc);

        gbc.gridy++;

        gbc.gridx = 0;
        add(new JLabel("ISBN: "), gbc);
        gbc.gridx++;
        this.isbnTextField = new JTextField(10);
        add(this.isbnTextField, gbc);

        gbc.gridx++;
        add(new JLabel("Año de Publicacion: "), gbc);
        gbc.gridx++;
        this.yearTextField = new JTextField(10);
        add(this.yearTextField, gbc);

        gbc.gridy++;
        gbc.gridx=0;
        add(new JLabel("Uniades Disponibles: "), gbc);
        gbc.gridx++;
        this.stockTextField = new JTextField(10);
        add(this.stockTextField, gbc);


    }

    public BookModel getBookModel() {
        String author = this.authorTextField.getText();
        String title = this.titleTextField.getText();
        Integer pages = Integer.parseInt(this.pagesTextField.getText());
        String editorial = this.editorialTextField.getText();
        String isbn = this.isbnTextField.getText();
        String year = this.yearTextField.getText();
        Integer stock = Integer.parseInt(this.stockTextField.getText());

        BookModel newBookModel = new BookModel(title, ResourceTypeEnum.BOOK, author, pages,editorial, isbn,stock,year);

        return newBookModel;

    }

}
