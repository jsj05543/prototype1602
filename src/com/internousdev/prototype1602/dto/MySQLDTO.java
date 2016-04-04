/**
 *
 */
package com.internousdev.prototype1602.dto;

/**
 * @author ユーザー情報を格納するDTOクラス
 *
 */
public class MySQLDTO {
    private int id;
    private String password;
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }

}
