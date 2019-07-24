package com.dotsub.controller;

import com.dotsub.utility.Constant;
import com.dotsub.utility.OutputResponse;
import com.dotsub.utility.ServerDetail;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sinoa
 */
@RestController
@RequestMapping("/api/server")
public class ServerDetailsController {

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OutputResponse getServerDetails() {
        ServerDetail serverDetail = new ServerDetail();
        try {

            serverDetail.setPort(environment.getProperty("local.server.port"));

            serverDetail.setLocalHostAddress(InetAddress.getLocalHost().getHostAddress());
            serverDetail.setLocalHostName(InetAddress.getLocalHost().getHostName());

            serverDetail.setRemoteHostAddress(InetAddress.getLoopbackAddress().getHostAddress());
            serverDetail.setRemoteHostName(InetAddress.getLoopbackAddress().getHostName());
            serverDetail.setMessage(Constant.SUCCESS_MSG);
            serverDetail.setCode(Constant.SUCCESS_CODE);
        } catch (UnknownHostException ex) {
            serverDetail.setMessage(Constant.ERROR_MSG + " : " + ex.getMessage());
            serverDetail.setCode(Constant.ERROR_CODE);
        }
        return serverDetail;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String pingServer() {

        return "Server is running";
    }

}
