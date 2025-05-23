package com.example.sagar.vehicledocumentverification;

class Vehicle_Missing {
//    @SerializedName("product_name")

    private String v_no;
    private String o_name;
    private String address;
    private String v_type;

    private String v_name;
    private String complete_date;
    private String desc_details;
    private String complete_station;


    public Vehicle_Missing(String v_no, String o_name, String address, String v_type,String v_name,String complete_date,String desc_details,String complete_station) {

        this.v_no = v_no;
        this.o_name = o_name;
        this.address = address;
        this.v_type = v_type;


        this.v_name = v_name;
        this.complete_date = complete_date;
        this.desc_details = desc_details;
        this.complete_station = complete_station;




    }







    public String getv_no() {
        return v_no;
    }

    public void setv_no(String v_no) {
        this.v_no = v_no;
    }


    public String geto_name() {
        return o_name;
    }

    public void seto_name(String o_name) {
        this.o_name = o_name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }


    public String getv_type() {
        return v_type;
    }

    public void setv_type(String v_type) {
        this.v_type = v_type;
    }




    public String getv_name() {
        return v_name;
    }

    public void setv_name(String v_name) {
        this.v_name = v_name;
    }


    public String getcomplete_date() {
        return complete_date;
    }

    public void setcomplete_date(String complete_date) {
        this.complete_date = complete_date;
    }

    public String getdesc_details() {
        return desc_details;
    }

    public void setdesc_details(String desc_details) {
        this.desc_details = desc_details;
    }


    public String getcomplete_station() {
        return complete_station;
    }

    public void setcomplete_station(String complete_station) {
        this.complete_station = complete_station;
    }




}
