package cn.hotel.entity;

import java.io.Serializable;

/**
 * @description:供应商实体类
 * @author: 汪志雄
 * @date: 2019-09-03 16:26
 */
public class WZXSupplierInfo implements Serializable {
    private Integer supplierNumber;
    private String supplierDepartmentName,detailAddress,openerBank,
            bankAccout,phone,linkman,linkmanPhone,email;

    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getSupplierDepartmentName() {
        return supplierDepartmentName;
    }

    public void setSupplierDepartmentName(String supplierDepartmentName) {
        this.supplierDepartmentName = supplierDepartmentName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getOpenerBank() {
        return openerBank;
    }

    public void setOpenerBank(String openerBank) {
        this.openerBank = openerBank;
    }

    public String getBankAccout() {
        return bankAccout;
    }

    public void setBankAccout(String bankAccout) {
        this.bankAccout = bankAccout;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
