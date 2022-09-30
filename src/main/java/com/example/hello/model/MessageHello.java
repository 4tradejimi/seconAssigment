package com.example.hello.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "messages", schema = "")
@NoArgsConstructor
public class MessageHello {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String language;
    private String textMessage;




    public MessageHello( String language, String textMessage) {

        this.language = language;
        this.textMessage = textMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
