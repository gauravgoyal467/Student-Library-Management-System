package com.example.StudentLibraryManagementSystem.DTO;

public class UpdateMobileRequestDTO {

    private int id;

    private String mobile_no;

    //constructors
    public UpdateMobileRequestDTO() {
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
}
