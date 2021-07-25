/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import tramdb.armor.ArmorDTO;

/**
 *
 * @author yiyangqianxi
 */
public class FileManipulaiton implements Serializable{
    
    /**
     * Reading file for server
     * @param nameFile
     * @return list of armor
     */
    public static List<ArmorDTO> readFile(String nameFile) {
        List<ArmorDTO> armorList = null;//store armor
        FileReader f = null;            //reading file base on name
        BufferedReader bf = null;       //create buffer to read
        SimpleDateFormat format = null; //create format date
        try {
            armorList = new Vector<>();  //new list
            f = new FileReader(nameFile);   //new read file
            bf = new BufferedReader(f);     //new buffer
            format = new SimpleDateFormat("dd/MM/yyyy");    //new date format
            while (bf.ready()) {            //reading from buffer
                String s = bf.readLine();   //reading line by line
                String[] arr = s.split("-");//slipt line readed to array's string
                if (arr.length == 6) {      //check if line read is not valid
                    //create new object(Arnor) for store in to list
                    ArmorDTO armor = new ArmorDTO(arr[0], arr[1], arr[2], arr[3], 
                            format.parse(arr[4]), Integer.parseInt(arr[5]));
                    //add armor to book
                    armorList.add(armor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //close buffer first
                if (bf != null) {
                    bf.close();
                }
                //close file reader
                if (f != null) {
                    f.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //return list
        return armorList;
    }
    
    /**
     * Write list armor to file
     * @param fileName
     * @param listArmor 
     */
    public static void writeFile(String fileName, Vector<ArmorDTO> listArmor) {
        PrintWriter w = null;   //create print writer
        
        try {
            w = new PrintWriter(fileName);  //new print writer
            //write each armor to file
            for (ArmorDTO armorDTO : listArmor) {
                w.println(armorDTO.toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //close print writer
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
