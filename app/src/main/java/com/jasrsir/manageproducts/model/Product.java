package com.jasrsir.manageproducts.model;

import java.util.Locale;
import java.util.UUID;

/**
 * Class Product that copy a medical product
 * @author jasrsir
 * Class Variables
 *  - Id
 *  - Name
 *  - Description
 *  - Brand (marca)
 *  - Dosage (dosis)
 *  - Price
 *  - Stock
 *  - Image
 */
public class Product {

    //region Product's Variables Getter and Setter
    private String mId;
    private String mName;
    private String mDescription;
    private String mBrand;
    private String mDosage;
    private double mPrice;
    private int mStock;
    private int mImage;

    //Instance constructor
    public Product(String name, String brand, String dosage, String descriptio, double price, int stock, int image) {

        this.mId = UUID.randomUUID().toString();//UUID.randomUUID() "always" generate random numbers without repetition
        this.mName = name;
        this.mBrand = brand;
        this.mDescription = descriptio;
        this.mDosage = dosage;
        this.mPrice = price;
        this.mStock = stock;
        this.mImage = image;
    }
    public String getmId() {
        return mId;
    }
    public void setmId(String mId) {
        this.mId = mId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmBrand() {
        return mBrand;
    }
    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }
    public String getmDosage() {
        return mDosage;
    }
    public void setmDosage(String mDosage) {
        this.mDosage = mDosage;
    }
    public String getmDescription() {
        return mDescription;
    }
    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
    public double getmPrice() {
        return mPrice;
    }
    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }
    public int getmStock() {
        return mStock;
    }
    public void setmStock(int mStock) {
        this.mStock = mStock;
    }
    public int getmImage() {
        return mImage;
    }
    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getFormattedPrice() {
        return String.format("%s €", mPrice);
    }
    public String getFormattedStock() {
        return String.format(Locale.getDefault(),"%d u.", mStock);
    }
    //endregion

    @Override
    public String toString() {
        return mName + " " + mDosage;
    }

    //2 productos son iguales cuando tienen el mismo nombre, marca y concentración

    //Override equals
    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {

            Product product = (Product) o;

            if (mName.equals(product.mName) && mBrand.equals(product.mBrand) && mDosage.equals(product.mDosage))
                return true;
        }
        return false;
    }

    //Override hasCode
    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mBrand.hashCode();
        result = 31 * result + mDosage.hashCode();
        return result;
    }
}
