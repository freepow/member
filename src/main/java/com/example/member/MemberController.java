package com.example.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MemberController {

    protected static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

    @Value("${member.server.ip}")
    private String ip;

    @Value("${member.server.port}")
    private String port;

    @Value("${member.server.endpoint}")
    private String endpoint;

    @RequestMapping("/member")
    public String getMemberService() {
        String url = "http://" + ip + ":" + port + endpoint;
        LOG.warn("### URL : {}", url);

        return url;
    }


    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/database")
    public String getDatabaseInfo() {
        String message = "데이터베이스 정보\n";
        message += "driverName : " + driverName + "\n";
        message += "url : " + url + "\n";
        message += "username : " + username + "\n";
        message += "password : " + password + "\n";

        return message;
    }


    @RequestMapping("/")
    public String index() {
        return "Hello~ Member Service";
    }

}
