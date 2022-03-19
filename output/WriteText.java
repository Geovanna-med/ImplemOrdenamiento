package output;

import java.io.*;

public class WriteText {

    public void write(String metrics){
        try {
            FileWriter myWriter= new FileWriter("output/metricas.txt");
                myWriter.write(metrics);
                myWriter.close();
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }

    }

}