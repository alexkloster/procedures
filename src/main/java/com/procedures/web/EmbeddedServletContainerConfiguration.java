package com.procedures.web;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = "com.procedures")
@EntityScan("com.procedures.dao.entity")
@EnableJpaRepositories("com.procedures.dao.repository")
public class EmbeddedServletContainerConfiguration{

	@Value("${server.port}")
	private int port;


	private Connector redirectConnector() {

		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(port);

		return connector;
	}
}
