package com.bv_gruppe_d.imagej.TransformImage;

import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class StateOfTheArt implements TransformInterface{

    private int[] pixels;
    private int c,r,g,b;
    private double wr = 0.299, wg = 0.587, wb = 0.114;

    @Override
    public void transform(ImageProcessor ip) {

        pixels = (int[]) ip.getPixels();

        for (int i = 0; i < pixels.length; i++) {

            c = pixels[i];

            r = (c & 0xff0000) >> 16;
            g = (c & 0x00ff00) >> 8;
            b = (c & 0x0000ff);

            c = (int) (wr*r + wg*g + wb*b);

            pixels[i] = ((c & 0xff) << 16) | ((c & 0xff) << 8) | c & 0xff;

        }



    }

}
