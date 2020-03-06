package com.example.ngontinhapp.object;

public class TruyenTranh {
    private String tenTruyen,tenChap,linkAnh;

    public TruyenTranh() {
    }

    public TruyenTranh(String tenTruyen, String tenChap, String linkAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linkAnh = linkAnh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public String getLinkAnh() {
        return linkAnh;
    }
}
