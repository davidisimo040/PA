package com.company;

import java.io.*;
public class InvalidCatalogException extends Exception  {

    public InvalidCatalogException(Exception ex)
    {
        super("Invalid catalog file.", ex);
    }
}
