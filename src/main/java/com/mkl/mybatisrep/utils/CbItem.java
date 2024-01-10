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
public class CbItem {

    private int id;
    private String strId;
    private String description;
    private String code;
    private String lokasi;
    private boolean bolval;
    private double tare;

    
   
     public CbItem(String strId) {
         this.strId = strId;
    }
     
    public CbItem(int id, String description) {
        this.id = id;
        this.description = description;
    }
    
     public CbItem(int id, String description, double tare) {
        this.id = id;
        this.description = description;
         this.tare = tare;
    }
    
    public CbItem(String strId, String description) {
        this.strId = strId;
        this.description = description;
    }
    
      public CbItem(String id, double tare) {
        this.strId = id;
        this.tare = tare;
    }
    
      public CbItem(String id, String description, double tare) {
        this.strId = id;
        this.description = description;
        this.tare = tare;
    }
    
      public CbItem(int id, String description,boolean bolval) {
        this.id = id;
        this.description = description;
        this.bolval = bolval;
    }
    
     public CbItem(int id, String description, String code) {
        this.id = id;
        this.description = description;
        this.code = code;
    }
    
     public CbItem(String id, String description, String code) {
        this.strId = id;
        this.description = description;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    public String getCode() {
        return code;
    }

    public String toString() {
        return description;
    }

    /**
     * @return the strId
     */
    public String getStrId() {
        return strId;
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
     * @return the bolval
     */
    public boolean isBolval() {
        return bolval;
    }

    /**
     * @param bolval the bolval to set
     */
    public void setBolval(boolean bolval) {
        this.bolval = bolval;
    }

    /**
     * @return the tare
     */
    public double getTare() {
        return tare;
    }

    /**
     * @param tare the tare to set
     */
    public void setTare(double tare) {
        this.tare = tare;
    }
}
