package com.hapi;

public class InsuranceShowInfo {

    public InsuranceShowInfo() {
    }

    public InsuranceShowInfo(String insuranceNo, String insuranceName, int payer, double premium, String noticeUrl, String consignUrl) {
        this.insuranceNo = insuranceNo;
        this.insuranceName = insuranceName;
        this.payer = payer;
        this.premium = premium;
        this.noticeUrl = noticeUrl;
        this.consignUrl = consignUrl;
    }
    private String insuranceNo;

    private String insuranceName;

    private int payer;

    private  double premium;

    private String noticeUrl;

    private String consignUrl;

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getPayer() {
        return payer;
    }

    public void setPayer(int payer) {
        this.payer = payer;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getNoticeUrl() {
        return noticeUrl;
    }

    public void setNoticeUrl(String noticeUrl) {
        this.noticeUrl = noticeUrl;
    }

    public String getConsignUrl() {
        return consignUrl;
    }

    public void setConsignUrl(String consignUrl) {
        this.consignUrl = consignUrl;
    }
}
