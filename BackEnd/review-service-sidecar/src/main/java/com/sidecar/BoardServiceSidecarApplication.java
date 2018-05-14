package com.sidecar;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableSidecar
@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class BoardServiceSidecarApplication {

//	@Autowired
//	private SessionServiceSidecarProperties properties;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BoardServiceSidecarApplication.class, args);
	}
	
    /*
	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfigBead(InetUtils inetUtils)
	{
		
		final String sidecarHostname = properties.getHostname();
		final Integer sidecarPort = properties.getPort();
		
		try {
			
			final EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(inetUtils);
			instance.setHostname(sidecarHostname);
			instance.setIpAddress(inetUtils.convertAddress(InetAddress.getByName(sidecarHostname)).getIpAddress());
			instance.setNonSecurePort(sidecarPort);
			return instance;

    } catch(UnknownHostException e) {
        throw new IllegalStateException("Could not resolve IP address of sidecar application using hostname: " + sidecarHostname);
    }

	}*/
}
