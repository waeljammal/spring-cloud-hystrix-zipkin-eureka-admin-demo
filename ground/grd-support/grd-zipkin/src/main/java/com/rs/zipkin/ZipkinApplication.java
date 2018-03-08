package com.rs.zipkin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@EnableZipkinStreamServer
@EnableDiscoveryClient
@Slf4j
public class ZipkinApplication {
    static {
        // For localhost testing only
        log.warn("Will now disable hostname check in SSL, only to be used during development");
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZipkinApplication.class).run(args);
    }
}
