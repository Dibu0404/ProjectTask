package com.whizzdreamer.divisha0404.projecttask.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName("sport")
    @Expose
    private String sport;

    @SerializedName("fact")
    @Expose
    private String fact;

    @SerializedName("icon")
    @Expose
    private String icon;

    public Detail(String sport, String fact, String icon) {
        this.sport = sport;
        this.fact = fact;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

}
