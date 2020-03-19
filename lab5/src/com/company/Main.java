package com.company;
import java.io.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidCatalogException, IOException {

        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }

    private void testCreateSave() throws IOException {

        Catalog catalog =  new Catalog("Java Resources", "C:\\Users\\david\\Desktop\\AN2SEM1\\catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "C:\\Users\\david\\Desktop\\poza.png");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\david\\Desktop\\AN2SEM1\\catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);

    }

}
