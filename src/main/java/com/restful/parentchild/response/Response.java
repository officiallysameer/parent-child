package com.restful.parentchild.response;

public class Response {

    private Integer personId;
    private String statusMessage;

    public Response(Integer id, String message) {
        this.personId = id;
        this.statusMessage = message;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}