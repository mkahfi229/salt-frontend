package com.example.saltfrontend.model;

public class SearchFilter {

    private String idfilter;

    public String getIdfilter() {
        return idfilter;
    }

    public void setIdfilter(String idfilter) {
        this.idfilter = idfilter;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + idfilter + "\"}";
    }
}
