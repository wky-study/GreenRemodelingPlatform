package com.team.green.common.callapi;

public class ProductRequest {
    private String mem_id;

    public ProductRequest(String mem_id) {
        this.mem_id = mem_id;
    }

    public String getMem_id() {
        return mem_id;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }
}