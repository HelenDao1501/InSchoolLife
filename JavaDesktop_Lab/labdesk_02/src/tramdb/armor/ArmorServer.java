/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.armor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Vector;
import tramdb.util.FileManipulaiton;

/**
 *
 * @author yiyangqianxi
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    //create list for storage
    private List<ArmorDTO> listArmor = null;
    //create file name
    private final String fileName = "ArmorData.txt";

    public ArmorServer() throws RemoteException {
    }

    /**
     * Create armor
     * @param dto
     * @return true or false
     * @throws RemoteException 
     */
    @Override
    public boolean createArmor(ArmorDTO dto) throws RemoteException {
        //check ID is existed or not
        if (findByArmorID(dto.getArmorID()) != null) {
            return false;
        } else {
            //add to list
            listArmor.add(dto);
            //write to file
            FileManipulaiton.writeFile(fileName, (Vector<ArmorDTO>) listArmor);
            return true;
        }
    }

    /**
     * Find armor by ID
     * @param id
     * @return
     * @throws RemoteException 
     */
    @Override
    public ArmorDTO findByArmorID(String id) throws RemoteException {
        //load armor
        findAllArmor();
        //find armor by ID
        for (ArmorDTO armorDTO : listArmor) {
            //if match return this armor found
            if (armorDTO.getArmorID().matches(id)) {
                return armorDTO;
            }
        }
        //else return null
        return null;
    }

    /**
     * Load all armor
     * @return
     * @throws RemoteException 
     */
    @Override
    public List<ArmorDTO> findAllArmor() throws RemoteException {
        //load armor
        listArmor = FileManipulaiton.readFile(fileName);
        return listArmor;
    }

    /**
     * remove armor
     * @param id
     * @return
     * @throws RemoteException 
     */
    @Override
    public boolean removeArmor(String id) throws RemoteException {
        //find armor
        ArmorDTO armor = findByArmorID(id);
        //remove armor from list
        listArmor.remove(armor);
        //write to file
        FileManipulaiton.writeFile(fileName, (Vector<ArmorDTO>) listArmor);
        return true;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) throws RemoteException {
        //find armor
        ArmorDTO armor = findByArmorID(dto.getArmorID());
        //remove armor from list
        listArmor.remove(armor);
        //add new armor updated
        listArmor.add(dto);
        //write to file
        FileManipulaiton.writeFile(fileName, (Vector<ArmorDTO>) listArmor);
        return true;
    }
}
