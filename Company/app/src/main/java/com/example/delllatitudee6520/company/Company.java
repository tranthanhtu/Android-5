package com.example.delllatitudee6520.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell latitude E6520 on 9/22/2016.
 */
public class Company implements Serializable {

    private String Name;
    private String Phone;
    private String Webside;

    public static List<Company> companyList;

    public static synchronized List<Company> getCompanyList(){
        if (companyList == null){
            companyList = new ArrayList<>();
            companyList.add(new Company("FPT Software", "0473007575", "https://www.fpt-software.com"));
            companyList.add(new Company("EWay", "+84432595450", "https://eway.vn"));
            companyList.add(new Company("KMS", "+84838486888", "http://www.kms-technology.com"));
            companyList.add(new Company("BraveBits", " +84463260066", "http://www.bravebits.vn"));
            companyList.add(new Company("TechKids", "+841653005670", "http://techkids.vn"));
        }
        return companyList;
    }
    public Company(String name, String phone, String webside) {
        Name = name;
        Phone = phone;
        Webside = webside;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getWebside() {
        return Webside;
    }

    public void setWebside(String webside) {
        Webside = webside;
    }
    public String toString(){
        return this.Name;
    }
}
