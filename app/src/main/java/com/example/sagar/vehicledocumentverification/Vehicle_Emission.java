package com.example.sagar.vehicledocumentverification;

class Vehicle_Emission {
//    @SerializedName("product_name")

    private String v_no;
    private String o_name;
    private String v_name;
    private String emission_test_date;

    private String emission_valid_upto;
    private String v_type;
    private String v_condition;
    private String carbon_value;


    public Vehicle_Emission(String v_no, String o_name, String v_name, String emission_test_date,String emission_valid_upto, String v_type, String v_condition, String carbon_value) {

        this.v_no = v_no;
        this.o_name = o_name;
        this.v_name = v_name;
        this.emission_test_date = emission_test_date;


        this.emission_valid_upto = emission_valid_upto;
        this.v_type = v_type;
        this.v_condition = v_condition;
        this.carbon_value = carbon_value;




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

    public String getv_name() {
        return v_name;
    }

    public void setv_name(String v_name) {
        this.v_name = v_name;
    }










    public String getemission_test_date() {
        return emission_test_date;
    }

    public void setemission_test_date(String emission_test_date) {
        this.emission_test_date = emission_test_date;
    }







    public String getemission_valid_upto() {
        return emission_valid_upto;
    }

    public void setemission_valid_upto(String emission_valid_upto) {
        this.emission_valid_upto = emission_valid_upto;
    }




    public String getv_type() {
        return v_type;
    }

    public void setv_type(String v_type) {
        this.v_type = v_type;
    }

    public String getv_condition() {
        return v_condition;
    }

    public void setv_condition(String v_condition) {
        this.v_condition = v_condition;
    }










    public String getcarbon_value() {
        return carbon_value;
    }

    public void setcarbon_value(String carbon_value) {
        this.carbon_value = carbon_value;
    }



}
