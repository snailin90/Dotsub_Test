package com.dotsub.utility;

/**
 *
 * @author Snailin Inoa
 */
public class ServerDetail extends OutputResponse {

    private String localHostAddress;
    private String localHostName;
    private String port;
    private String remoteHostAddress;
    private String remoteHostName;

    public String getLocalHostAddress() {
        return localHostAddress;
    }

    public void setLocalHostAddress(String localHostAddress) {
        this.localHostAddress = localHostAddress;
    }

    public String getLocalHostName() {
        return localHostName;
    }

    public void setLocalHostName(String localHostName) {
        this.localHostName = localHostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRemoteHostAddress() {
        return remoteHostAddress;
    }

    public void setRemoteHostAddress(String remoteHostAddress) {
        this.remoteHostAddress = remoteHostAddress;
    }

    public String getRemoteHostName() {
        return remoteHostName;
    }

    public void setRemoteHostName(String remoteHostName) {
        this.remoteHostName = remoteHostName;
    }

}
