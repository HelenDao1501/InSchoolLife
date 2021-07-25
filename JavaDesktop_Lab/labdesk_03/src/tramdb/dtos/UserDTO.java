/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tramdb.dtos;

/**
 *
 * @author yiyangqianxi
 */
public class UserDTO {

    String id;
    String pass;

    public UserDTO() {
        id = "";
        pass = "";
    }

    public UserDTO(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
