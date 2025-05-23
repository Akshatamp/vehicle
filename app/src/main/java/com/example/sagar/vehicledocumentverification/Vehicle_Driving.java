package com.example.sagar.vehicledocumentverification;

class Vehicle_Driving {
//    @SerializedName("product_name")

    private String v_no;
    private String o_name;
    private String v_name;
    private String mno;

    private String address;
    private String dob;
    private String validate_till;
    private String blood_group;
    private String doi;
    private String d_type;


    public Vehicle_Driving(String v_no, String o_name, String v_name, String mno,String address, String dob, String validate_till, String blood_group,String doi,String d_type) {

        this.v_no = v_no;
        this.o_name = o_name;
        this.v_name = v_name;
        this.mno = mno;

        this.address = address;
        this.dob = dob;
        this.validate_till = validate_till;
        this.blood_group = blood_group;
        this.doi = doi;
        this.d_type = d_type;




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

    public void setso_name(String o_name) {
        this.o_name = o_name;
    }

    public String getv_name() {
        return v_name;
    }

    public void setv_name(String v_name) {
        this.v_name = v_name;
    }










    public String getmno() {
        return mno;
    }

    public void setmno(String mno) {
        this.mno = mno;
    }






    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }




    public String getdob() {
        return dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }





    public String getvalidate_till() {
        return validate_till;
    }

    public void setvalidate_till(String validate_till) {
        this.validate_till = validate_till;
    }





    public String getblood_group() {
        return blood_group;
    }

    public void setblood_group(String blood_group) {
        this.blood_group = blood_group;
    }





    public String getdoi() {
        return doi;
    }

    public void setdoi(String doi) {
        this.doi = doi;
    }






    public String getd_type() {
        return d_type;
    }

    public void setd_type(String d_type) {
        this.d_type = d_type;
    }




}
