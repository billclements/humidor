package com.TDD.Humidor;

/**
 * Created with IntelliJ IDEA.
 * User: bill
 * Date: 2/18/13
 * Time: 8:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class CigarDataHolder {
    private int _id;
    private String brand;
    private String type;
    private String vitola;
    private String wrapper;
    private int quantity;


    public CigarDataHolder(int _id, String brand, String type, String vitola, String wrapper, int quantity){
        this._id = _id;
        this.brand = brand;
        this.type = type;
        this.vitola = vitola;
        this.wrapper = wrapper;
        this.quantity = quantity;
    }

    public void set_id(int id){
        this._id = id;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setVitola(String vitola){
        this.vitola = vitola;
    }
    public void setWrapper(String wrapper){
        this.wrapper = wrapper;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int get_id(){
        return _id;
    }
    public String getBrand(){
        return brand;
    }
    public String getType(){
        return type;
    }
    public String getVitola(){
        return vitola;
    }
    public String getWrapper(){
        return wrapper;
    }
    public int getQuantity(){
        return quantity;
    }

}