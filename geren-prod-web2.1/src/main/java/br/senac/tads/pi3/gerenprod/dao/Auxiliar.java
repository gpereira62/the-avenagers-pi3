/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mac-ale
 */
public class Auxiliar {
        
    public static Date InputDateToUtilDate(String inputDate)
            throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

        try {

            Date resultado = format.parse(inputDate);

            return resultado;

        } catch (Exception e) {
            throw new ParseException("Erro ao formatar data de input para util date.", 0);
        }

    }
}
