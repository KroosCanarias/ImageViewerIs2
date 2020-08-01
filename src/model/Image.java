/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 34667
 */
import java.io.InputStream;

public interface Image {
    String name();
    InputStream stream();
    Image next();
    Image prev();

    public byte[] data();
}
