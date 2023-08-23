package com.techelevator.tenmo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transfer {
    private int transferId;
    private int senderId;
    private int receiverId;
    private BigDecimal transferAmount;
    private String status;
    private Timestamp transferTimestamp;

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public Timestamp getTransferTimestamp() {
        return transferTimestamp;
    }

    public void setTransferTimestamp(Timestamp transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}
