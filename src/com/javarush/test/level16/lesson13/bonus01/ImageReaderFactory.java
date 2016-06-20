package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes type) {
        if (ImageTypes.JPG.equals(type)) {
            return new JpgReader();
        }  else if (ImageTypes.BMP.equals(type)) {
            return new BmpReader();
        }  else if (ImageTypes.PNG.equals(type)) {
            return new PngReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }

}
