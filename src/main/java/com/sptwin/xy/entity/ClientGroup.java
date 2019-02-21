package com.sptwin.xy.entity;

public class ClientGroup {
    private Long id;

    private Long clientAgentId;

    private String clientGroupNo;

    private String clientGroupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientAgentId() {
        return clientAgentId;
    }

    public void setClientAgentId(Long clientAgentId) {
        this.clientAgentId = clientAgentId;
    }

    public String getClientGroupNo() {
        return clientGroupNo;
    }

    public void setClientGroupNo(String clientGroupNo) {
        this.clientGroupNo = clientGroupNo == null ? null : clientGroupNo.trim();
    }

    public String getClientGroupName() {
        return clientGroupName;
    }

    public void setClientGroupName(String clientGroupName) {
        this.clientGroupName = clientGroupName == null ? null : clientGroupName.trim();
    }
}