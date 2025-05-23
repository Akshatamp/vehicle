package com.example.sagar.vehicledocumentverification;

class Cart {
//    @SerializedName("product_name")
    private Integer id;
    private String stringet_pdetails;
    private String stringet_amount;
    private String stringet_mno;
    private String stringet_uname;
    private String stringet_address;



    public Cart(Integer id, String stringet_pdetails, String stringet_amount, String stringet_mno, String stringet_uname, String stringet_address)
    {
        this.id = id;
        this.stringet_pdetails = stringet_pdetails;
        this.stringet_amount = stringet_amount;
        this.stringet_mno = stringet_mno;
        this.stringet_uname = stringet_uname;
        this.stringet_address = stringet_address;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getstringet_pdetails() {
        return stringet_pdetails;
    }

    public void setstringet_pdetails(String stringet_pdetails) {
        this.stringet_pdetails = stringet_pdetails;
    }

    public String getstringet_amount() {
        return stringet_amount;
    }

    public void setstringet_amount(String stringet_amount) {
        this.stringet_amount = stringet_amount;
    }




    public String getstringet_mno() {
        return stringet_mno;
    }

    public void setstringet_mno(String stringet_mno) {
        this.stringet_mno = stringet_mno;
    }



    public String getstringet_uname() {
        return stringet_uname;
    }

    public void setstringet_uname(String stringet_uname) {
        this.stringet_uname = stringet_uname;
    }


    public String getstringet_address() {
        return stringet_address;
    }

    public void setstringet_address(String stringet_address) {
        this.stringet_address = stringet_address;
    }

}
