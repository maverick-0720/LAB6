package com.cenfotec.journal.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="created")
    private Date created;
    @Column(name="summary")
    private String summary;
    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    public String getCreatedAsShort() {
        return format.format(created);
    }
    public Journal(String title, String summary, String date) throws
            ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(date);
    }
    public Journal() {
    }

}
