package com.whizzdreamer.divisha0404.projecttask.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataClass {
    @SerializedName("content")
    @Expose
    private List<Detail> contentList = null;

    public List<Detail> getContentList() {
        return contentList;
    }

    public void setContentList(List<Detail> contentList) {
        this.contentList = contentList;
    }
}
