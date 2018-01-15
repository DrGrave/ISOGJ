package com.vidnichuk.isogj.api.dto.model;

import com.vidnichuk.isogj.api.model.type.TypeOfLink;

public class UserLinkDto {
    private long id;
    private TypeOfLink typeOfLink;
    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfLink getTypeOfLink() {
        return typeOfLink;
    }

    public void setTypeOfLink(TypeOfLink typeOfLink) {
        this.typeOfLink = typeOfLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
