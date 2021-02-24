package com.example.pmikotadepok;

public class Donors {
    private String tgldonor;
    private String tempatdonor;

    public Donors(String tgldonor, String tempatdonor) {
        this.tgldonor = tgldonor;
        this.tempatdonor = tempatdonor;
    }

    public String getTgldonor() {
        return tgldonor;
    }

    public void setTgldonor(String tgldonor) {
        this.tgldonor = tgldonor;
    }

    public String getTempatdonor() {
        return tempatdonor;
    }

    public void setTempatdonor(String tempatdonor) {
        this.tempatdonor = tempatdonor;
    }
}