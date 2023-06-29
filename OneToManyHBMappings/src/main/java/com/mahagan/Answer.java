package com.mahagan;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long ansId;

    private String ansName;

    private String ansPostedBy;

    public Answer() {
    }

    public Answer(Long ansId, String ansName, String ansPostedBy) {
        this.ansId = ansId;
        this.ansName = ansName;
        this.ansPostedBy = ansPostedBy;
    }

    public Long getAnsId() {
        return ansId;
    }

    public void setAnsId(Long ansId) {
        this.ansId = ansId;
    }

    public String getAnsName() {
        return ansName;
    }

    public void setAnsName(String ansName) {
        this.ansName = ansName;
    }

    public String getAnsPostedBy() {
        return ansPostedBy;
    }

    public void setAnsPostedBy(String ansPostedBy) {
        this.ansPostedBy = ansPostedBy;
    }
}
