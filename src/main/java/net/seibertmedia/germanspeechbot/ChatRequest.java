package net.seibertmedia.germanspeechbot;

public class ChatRequest {

    private String input;

    // Must have no-argument constructor
    public ChatRequest() {

    }

    public ChatRequest(String input) {
        this.input = input;
    }

    public void setInput(String fname) {
        this.input = fname;
    }

    public String getInput() {
        return this.input;
    }

    @Override
    public String toString() {
        return input;
    }

}
