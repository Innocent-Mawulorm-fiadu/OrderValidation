package nyansapo.ordervalidation;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@org.springframework.context.annotation.Configuration
public class Configuration extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messsageDispatcher(ApplicationContext context){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");

    }

    @Bean
    public XsdSchema orderSchema(){
        return new SimpleXsdSchema(new ClassPathResource("Order.xsd"));
    }

    @Bean(name = "order")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema orderSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(orderSchema);
        definition.setLocationUri("/ws");
        definition.setPortTypeName("OrderServ");
        definition.setTargetNamespace("http://nyansapo/ordervalidation/model");
        return definition;
    }

    }
