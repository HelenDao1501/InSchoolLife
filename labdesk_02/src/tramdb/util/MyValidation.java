/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.util;

import java.io.Serializable;

/**
 *
 * @author yiyangqianxi
 */
public class MyValidation implements Serializable {

    /**
     * Check ArmorID not contain [@#$] and length not less than 0 or more than 10
     * @param armorID
     * @return true or false
     */
    public static boolean checkArmorID(String armorID) {
	return armorID.matches("^[^@#$]*$") && (armorID.length() <= 10 && armorID.length() > 0);
    }

    /**
     * Check classification length not less than 0 or more than 30
     * @param classification
     * @return true or false
     */
    public static boolean checkClassification(String classification) {
	return classification.length() > 0 && classification.length() <= 30;
    }

    /**
     * Check description length not than 0 and more than 300
     * @param description
     * @return true or false
     */
    public static boolean checkDescription(String description) {
	return description.length() > 0 && description.length() <= 300;
    }

    /**
     * Check defense is a number and not less than 0
     * @param defense
     * @return true or false
     */
    public static boolean checkDefense(String defense) {
	if (!defense.matches("^[0-9]+$")) {
	    return false;
	} else if (Integer.parseInt(defense) <= 0) {
	    return false;
	}
	return true;
    }

    /**
     * Check date with format dd/MM/yyyy
     * @param date
     * @return true of false
     */
    public static boolean checkDate(String date) {
	return date.matches("^(0[1-9]|[12][0-9]|3[01])([/])(0[1-9]|1[012])([/])\\d\\d\\d\\d$");
    }
}
