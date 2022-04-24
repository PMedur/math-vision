package com.pi.math_vision_android.Maker;

import android.graphics.Bitmap;

import com.pi.math_vision_android.recognition_model.SymbolRecognitionModelInterface;

import java.util.List;

public class EquationMaker {

    public static String imageToEquation(Bitmap wholeImage){
        List<Bitmap> symbolImages = ImageProcessingUtility.preprocessImage(wholeImage);
        StringBuilder equationBuilder = new StringBuilder();
        String equation;

        for(Bitmap symbolImage : symbolImages) {
            equationBuilder.append(SymbolRecognitionModelInterface.getPrediction(symbolImage));
        }

        if(equationBuilder.toString().contains("--")) {
            equation = equationBuilder.toString().replace("--", "=");
        }
        else equation = equationBuilder.toString();

        return equation;
    }
}
