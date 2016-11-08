package org.example.androidenterprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caishuang：确认订单里面选择地址model
 */
public class SelectAddressEntity implements Serializable {
    private List<ContentEntity> Content;

    public List<ContentEntity> getContent() {
        return Content;
    }

    public void setContent(List<ContentEntity> content) {
        Content = content;
    }

    public SelectAddressEntity() {
        Content = new ArrayList<ContentEntity>();
    }

    public static class ContentEntity {
        private String Recipient;
        private String Telephone;
        private String Address;

        public String getRecipient() {
            return Recipient;
        }

        public void setRecipient(String recipient) {
            Recipient = recipient;
        }

        public String getTelephone() {
            return Telephone;
        }

        public void setTelephone(String telephone) {
            Telephone = telephone;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }
    }
}
