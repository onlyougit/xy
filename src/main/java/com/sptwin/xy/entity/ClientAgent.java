package com.sptwin.xy.entity;

public class ClientAgent {
    private Long id;

    private String clientAgentNo;

    private String clientAgentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientAgentNo() {
        return clientAgentNo;
    }

    public void setClientAgentNo(String clientAgentNo) {
        this.clientAgentNo = clientAgentNo == null ? null : clientAgentNo.trim();
    }

    public String getClientAgentName() {
        return clientAgentName;
    }

    public void setClientAgentName(String clientAgentName) {
        this.clientAgentName = clientAgentName == null ? null : clientAgentName.trim();
    }
}