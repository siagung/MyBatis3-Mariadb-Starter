/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkl.mybatisrep.utils;

/**
 *
 * @author agung
 */
public class CbOrderItem {

    private int id;
    private String strId;
    private String nodo;
    private int idcust;
    private int idbarang;
    private String lokasi;
    private double ntotal;
    private double nsisa;
    private String cbarang;

    public CbOrderItem(int id, String nodo) {
        this.id = id;
        this.nodo = nodo;
    }

    public CbOrderItem(String strId, String nodo) {
        this.strId = strId;
        this.nodo = nodo;
    }

    public CbOrderItem(int id, String nodo, int idcust, int idbarang) {
        this.id = id;
        this.nodo = nodo;
        this.idcust = idcust;
        this.idbarang = idbarang;
    }

    public CbOrderItem(int id, String nodo, int idcust, int idbarang, String lokasi) {
        this.id = id;
        this.nodo = nodo;
        this.idcust = idcust;
        this.idbarang = idbarang;
        this.lokasi = lokasi;
    }
    
      public CbOrderItem(int id, String nodo, int idcust, int idbarang, String lokasi, double ntotal) {
        this.id = id;
        this.nodo = nodo;
        this.idcust = idcust;
        this.idbarang = idbarang;
        this.lokasi = lokasi;
        this.ntotal = ntotal;
    }

    public CbOrderItem(String strId, String nodo, int idcust, int idbarang, String lokasi, double ntotal) {
        this.strId= strId;
        this.nodo = nodo;
        this.idcust = idcust;
        this.idbarang = idbarang;
        this.lokasi = lokasi;
        this.ntotal = ntotal;
    }
    
     public CbOrderItem(String strId, String nodo, int idcust, int idbarang, String cbarang, String lokasi, double ntotal, double nsisa) {
        this.strId= strId;
        this.nodo = nodo;
        this.idcust = idcust;
        this.idbarang = idbarang;
        this.cbarang = cbarang;
        this.lokasi = lokasi;
        this.ntotal = ntotal;
        this.nsisa = nsisa;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nodo
     */
    public String getNodo() {
        return nodo;
    }

    /**
     * @param nodo the nodo to set
     */
    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    /**
     * @return the idcust
     */
    public int getIdcust() {
        return idcust;
    }

    /**
     * @param idcust the idcust to set
     */
    public void setIdcust(int idcust) {
        this.idcust = idcust;
    }

    /**
     * @return the idbarang
     */
    public int getIdbarang() {
        return idbarang;
    }

    /**
     * @param idbarang the idbarang to set
     */
    public void setIdbarang(int idbarang) {
        this.idbarang = idbarang;
    }

    /**
     * @return the lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    /**
     * @param lokasi the lokasi to set
     */
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    /**
     * @return the ntotal
     */
    public double getNtotal() {
        return ntotal;
    }

    /**
     * @param ntotal the ntotal to set
     */
    public void setNtotal(double ntotal) {
        this.ntotal = ntotal;
    }
    
    public String toString() {
        return nodo;
    }

    /**
     * @return the strId
     */
    public String getStrId() {
        return strId;
    }

    /**
     * @param strId the strId to set
     */
    public void setStrId(String strId) {
        this.strId = strId;
    }

    /**
     * @return the nsisa
     */
    public double getNsisa() {
        return nsisa;
    }

    /**
     * @param nsisa the nsisa to set
     */
    public void setNsisa(double nsisa) {
        this.nsisa = nsisa;
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

}
