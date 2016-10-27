package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cs:乐器详情model
 */
public class InstrumentDetailEntity implements Serializable {
    private int Instrument_id;
    private String Instrument_name;
    private int Instrument_pre_price;
    private int Instrument_now_price;
    private double Freight;
    private String Instrument_location;
    private List<ProductInfoEntity> Product;
    private String Description;
    private List<PicUrlInfoEntity> Pic_url;

    public InstrumentDetailEntity() {
        Product = new ArrayList<ProductInfoEntity>();
        Pic_url = new ArrayList<PicUrlInfoEntity>();
    }

    public int getInstrument_id() {
        return Instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        Instrument_id = instrument_id;
    }

    public String getInstrument_name() {
        return Instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        Instrument_name = instrument_name;
    }

    public int getInstrument_pre_price() {
        return Instrument_pre_price;
    }

    public void setInstrument_pre_price(int instrument_pre_price) {
        Instrument_pre_price = instrument_pre_price;
    }

    public int getInstrument_now_price() {
        return Instrument_now_price;
    }

    public void setInstrument_now_price(int instrument_now_price) {
        Instrument_now_price = instrument_now_price;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    public String getInstrument_location() {
        return Instrument_location;
    }

    public void setInstrument_location(String instrument_location) {
        Instrument_location = instrument_location;
    }

    public List<ProductInfoEntity> getProduct() {
        return Product;
    }

    public void setProduct(List<ProductInfoEntity> product) {
        Product = product;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<PicUrlInfoEntity> getPic_url() {
        return Pic_url;
    }

    public void setPic_url(List<PicUrlInfoEntity> pic_url) {
        Pic_url = pic_url;
    }

    public static class ProductInfoEntity {
        private String Product_Parameter;

        public String getProduct_Parameter() {
            return Product_Parameter;
        }

        public void setProduct_Parameter(String product_Parameter) {
            Product_Parameter = product_Parameter;
        }
    }

    public static class PicUrlInfoEntity {
        private String Ins_pic_url;

        public String getIns_pic_url() {
            return Ins_pic_url;
        }

        public void setIns_pic_url(String ins_pic_url) {
            Ins_pic_url = ins_pic_url;
        }
    }
}
