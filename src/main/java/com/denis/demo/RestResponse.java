package com.denis.demo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class RestResponse {
    private String inputString;
    private String recurringCharacters;
    private String inputWord;
    private String countWord;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getRecurringCharacters() {
        return recurringCharacters;
    }

    public void setRecurringCharacters(String recurringCharacters) {
        this.recurringCharacters = recurringCharacters;
    }

    public String getInputWord() {
        return inputWord;
    }

    public void setInputWord(String inputWord) {
        this.inputWord = inputWord;
    }

    public String getCountWord() {
        return countWord;
    }

    public void setCountWord(String countWord) {
        this.countWord = countWord;
    }
}
