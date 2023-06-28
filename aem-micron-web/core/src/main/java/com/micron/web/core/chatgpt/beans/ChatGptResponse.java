package com.micron.web.core.chatgpt.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true )
public class ChatGptResponse {
    private List<Choice> choices;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true )
    @Getter
    public static class Choice {
        private Message message;

    }
}

