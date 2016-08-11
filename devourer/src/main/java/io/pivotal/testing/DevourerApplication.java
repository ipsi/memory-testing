package io.pivotal.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevourerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevourerApplication.class, args);
	}

//	@Bean
//	public EmbeddedServletContainerFactory servletContainerFactory() {
//		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//
//		factory.addConnectorCustomizers(connector ->
//				{
//					ProtocolHandler protocolHandler = connector.getProtocolHandler();
//					System.out.println("Protocol handler is of type [" + protocolHandler.getClass() + "]");
//					final AbstractEndpoint endpoint;
//					if (protocolHandler instanceof AbstractProtocol) {
//						try {
//							Field declaredEndpoint = AbstractProtocol.class.getDeclaredField("endpoint");
//							declaredEndpoint.setAccessible(true);
//							endpoint = (AbstractEndpoint) declaredEndpoint.get(protocolHandler);
//						} catch (NoSuchFieldException | IllegalAccessException e) {
//							throw new RuntimeException(e);
//						}
//					}
//					else {
//						throw new RuntimeException("Unknown protocol type [" + protocolHandler.getClass() + "]");
//					}
//
//					SocketProperties socketProperties = endpoint.getSocketProperties();
//					socketProperties.setDirectBuffer(true);
//					socketProperties.setDirectSslBuffer(true);
//				}
//		);
//
//		// configure some more properties
//
//		return factory;
//	}
}
