package com.example.sagar.vehicledocumentverification;

class Vehicle_Insurence {
//    @SerializedName("product_name")

    private String v_no;
    private String o_name	;
    private String v_type;
    private String v_price;



    private String insurence_date;
    private String valid_upto;
    private String insurence_amount;
    private String address;


    public Vehicle_Insurence(String v_no, String o_name	, String v_type, String v_price,String insurence_date, String valid_upto, String insurence_amount, String address) {

        this.v_no = v_no;
        this.o_name	 = o_name	;
        this.v_type = v_type;
        this.v_price = v_price;



        this.insurence_date = insurence_date;
        this.valid_upto = valid_upto;
        this.insurence_amount = insurence_amount;
        this.address = address;





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




    public String getv_type() {
        return v_type;
    }

    public void setv_type(String v_type) {
        this.v_type = v_type;
    }

    public String getv_price() {
        return v_price;
    }

    public void setv_price(String v_price) {
        this.v_price = v_price;
    }










    public String getinsurence_date() {
        return insurence_date;
    }

    public void setinsurence_date(String insurence_date) {
        this.insurence_date = insurence_date;
    }






    public String getvalid_upto() {
        return valid_upto;
    }

    public void setvalid_upto(String valid_upto) {
        this.valid_upto = valid_upto;
    }




    public String getinsurence_amount() {
        return insurence_amount;
    }

    public void setinsurence_amount(String insurence_amount) {
        this.insurence_amount = insurence_amount;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }














}
