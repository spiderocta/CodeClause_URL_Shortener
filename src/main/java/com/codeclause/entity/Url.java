package com.codeclause.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String longUrl;

    @Column
    private Date createdDate;

    private Date expiresDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Date expireDate) {
        this.expiresDate = expireDate;
    }
}
