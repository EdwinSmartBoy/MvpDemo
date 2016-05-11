package com.example.edwin.mvpdemo.bean;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        城市内容的bean对象
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class IPBean {

    String city;//城市
    String country;//地区
    String Province;//省份

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    @Override
    public String toString() {
        return "IPBean{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", Province='" + Province + '\'' +
                '}';
    }
}
