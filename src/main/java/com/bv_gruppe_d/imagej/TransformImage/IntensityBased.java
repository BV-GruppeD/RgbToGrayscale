package com.bv_gruppe_d.imagej.TransformImage;

import ij.process.ImageProcessor;

import java.util.Arrays;

//Whydomath.org ImageCompression

public class IntensityBased implements TransformInterface {

    private int[] pixels;
    private int c,r,g,b;

    @Override
    public void transform(ImageProcessor ip) {

        pixels = (int[]) ip.getPixels();

        for (int i = 0; i < pixels.length; i++) {

            c = pixels[i];

            r = (c & 0xff0000) >> 16;
            g = (c & 0x00ff00) >> 8;
            b = (c & 0x0000ff);

            c = (int) (Math.sqrt(Math.pow(r,2) + Math.pow(g,2) + Math.pow(b,2)));

            pixels[i] = ((c & 0xff) << 16) | ((c & 0xff) << 8) | c & 0xff;

        }
    }
}
