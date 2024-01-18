package com.example.saltfrontend.model;

import java.util.Date;

public class Konsumen {

    private Integer id;
    private String nama;

    private String alamat;

    private String kota;

    private String provinsi;

    private String tglRegistrasi;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getTglRegistrasi() {
        return tglRegistrasi;
    }

    public void setTglRegistrasi(String tglRegistrasi) {
        this.tglRegistrasi = tglRegistrasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{\"id\": " + id + ", \"nama\": \"" + nama + "\", \"alamat\": \"" + alamat + "\", \"kota\": \"" +
                kota + "\", \"provinsi\": \"" + provinsi + "\", \"tglRegistrasi\": \"" + tglRegistrasi +
                "\", \"status\": \"" + status + "\"}";
    }
}
