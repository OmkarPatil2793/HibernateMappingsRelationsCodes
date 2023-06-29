package com.mahagan;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long queId;

    private String queName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "que_Id")
    @OrderColumn(name = "type")
    private List<Answer> answers;

    public Question() {
    }

    public Question(Long queId, String queName, List<Answer> answers) {
        this.queId = queId;
        this.queName = queName;
        this.answers = answers;
    }

    public Long getQueId() {
        return queId;
    }

    public void setQueId(Long queId) {
        this.queId = queId;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
