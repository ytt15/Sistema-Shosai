/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Mahecha Ortiz
 */
public class UploadFile {

    @Autowired
    Producto lstProducto;

    public List<Producto> guardarFile(MultipartFile path) throws IOException, CsvValidationException {
        List<Producto> lstProducto = new ArrayList<>();

        String ruta = "C:\\cargas\\" + path.getOriginalFilename();
        File localFile = new File(ruta);
        path.transferTo(localFile);

        CSVReader csvReader = new CSVReader(new FileReader(ruta));
        String[] fila = null;
        csvReader.readNext();
        while ((fila = csvReader.readNext()) != null) {

            String[] datos = fila[0].split(";");

            Producto p = new Producto();
            //p.setId(Integer.parseInt(datos[0]));

            p.setCodigo(datos[0]);
            p.setExistencia(Float.parseFloat(datos[1]));
            p.setNombre((datos[2]));
            p.setPrecio(Float.parseFloat(datos[3]));
            lstProducto.add(p);

        }
        csvReader.close();
        return lstProducto;
    }
}
