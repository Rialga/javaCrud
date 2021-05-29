package com.example.presensi.Model;

import java.util.List;

public class ResponseEmployee {

        private String message;
        private List<EmployeeModel> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<EmployeeModel> getEmployee() {
        return data;
    }

    public void setEmployee(List<EmployeeModel> employee) {
        this.data = employee;
    }
}
