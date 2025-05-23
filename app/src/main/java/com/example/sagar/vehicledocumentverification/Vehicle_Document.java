package com.example.sagar.vehicledocumentverification;

class Vehicle_Document {
//    @SerializedName("product_name")

    private String v_no;
    private String register_date;
    private String v_name;
    private String v_type;
    private String o_name;
    private String address;
    private String fuel;
    private String manu_facture;
    private String validate_upto;
    private String seating_no;



    public Vehicle_Document(String v_no, String register_date, String v_name, String v_type,String o_name,String address,String fuel,String manu_facture,String validate_upto,String seating_no) {

        this.v_no = v_no;
        this.register_date = register_date;
        this.v_name = v_name;
        this.v_type = v_type;
        this.o_name = o_name;
        this.address = address;
        this.fuel = fuel;
        this.manu_facture = manu_facture;
        this.validate_upto = validate_upto;
        this.seating_no = seating_no;







    }







    public String getv_no() {
        return v_no;
    }

    public void setv_no(String v_no) {
        this.v_no = v_no;
    }




    public String getregister_date() {
        return register_date;
    }

    public void setregister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getv_name() {
        return v_name;
    }

    public void setv_name(String v_name) {
        this.v_name = v_name;
    }










    public String getv_type() {
        return v_type;
    }

    public void setv_type(String v_type) {
        this.v_type = v_type;
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

    public void setaddress(String v_type) {
        this.address = address;
    }


    public String getfuel() {
        return fuel;
    }

    public void setfuel(String fuel) {
        this.fuel = fuel;
    }


    public String getmanu_facture() {
        return manu_facture;
    }

    public void setmanu_facture(String manu_facture) {
        this.manu_facture = manu_facture;
    }



    public String getvalidate_upto() {
        return validate_upto;
    }

    public void setvalidate_upto(String validate_upto) {
        this.validate_upto = validate_upto;
    }



    public String getseating_no() {
        return seating_no;
    }

    public void setseating_no(String seating_no) {
        this.seating_no = seating_no;
    }




}
