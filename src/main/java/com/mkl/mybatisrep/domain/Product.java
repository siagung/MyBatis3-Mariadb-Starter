/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkl.mybatisrep.domain;

/**
 *
 * @author agung
 */

public class Product {
    
    private Integer id;    
    private String cbarang;
    private String vnama_barang;
    private boolean banalisa;
    private boolean breduct;
    private int btipe;    
    private boolean baktif;
    private boolean updateType;
    private boolean breg;
    private Integer nourut;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nourut
     */
    public Integer getNourut() {
        return nourut;
    }

    /**
     * @param nourut the nourut to set
     */
    public void setNourut(Integer nourut) {
        this.nourut = nourut;
    }

    /**
     * @return the updateType
     */
    public boolean isUpdateType() {
        return updateType;
    }

    /**
     * @param updateType the updateType to set
     */
    public void setUpdateType(boolean updateType) {
        this.updateType = updateType;
    }

    /**
     * @return the cbarang
     */
    public String getCbarang() {
        return cbarang;
    }

    /**
     * @param cbarang the cbarang to set
     */
    public void setCbarang(String cbarang) {
        this.cbarang = cbarang;
    }

    /**
     * @return the vnama_barang
     */
    public String getVnama_barang() {
        return vnama_barang;
    }

    /**
     * @param vnama_barang the vnama_barang to set
     */
    public void setVnama_barang(String vnama_barang) {
        this.vnama_barang = vnama_barang;
    }

    /**
     * @return the banalisa
     */
    public boolean isBanalisa() {
        return banalisa;
    }

    /**
     * @param banalisa the banalisa to set
     */
    public void setBanalisa(boolean banalisa) {
        this.banalisa = banalisa;
    }

    /**
     * @return the breduct
     */
    public boolean isBreduct() {
        return breduct;
    }

    /**
     * @param breduct the breduct to set
     */
    public void setBreduct(boolean breduct) {
        this.breduct = breduct;
    }

    /**
     * @return the baktif
     */
    public boolean isBaktif() {
        return baktif;
    }

    /**
     * @param baktif the baktif to set
     */
    public void setBaktif(boolean baktif) {
        this.baktif = baktif;
    }

    /**
     * @return the btipe
     */
    public int isBtipe() {
        return getBtipe();
    }

    /**
     * @param btipe the btipe to set
     */
    public void setBtipe(int btipe) {
        this.btipe = btipe;
    }

    /**
     * @return the btipe
     */
    public int getBtipe() {
        return btipe;
    }

    /**
     * @return the breg
     */
    public boolean isBreg() {
        return breg;
    }

    /**
     * @param breg the breg to set
     */
    public void setBreg(boolean breg) {
        this.breg = breg;
    }

    
}
