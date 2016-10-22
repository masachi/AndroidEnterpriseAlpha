package org.example.androidenterprise.model;

import java.io.Serializable;

/**
 * Created by sdlds on 2016/10/22.
 */
public class LoginResponseErrorEntity implements Serializable {
    private String Result;
    private int Type;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
