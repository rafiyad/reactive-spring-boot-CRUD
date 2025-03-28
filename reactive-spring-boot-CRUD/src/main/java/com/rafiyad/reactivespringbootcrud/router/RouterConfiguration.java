package com.rafiyad.reactivespringbootcrud.router;


import com.rafiyad.reactivespringbootcrud.handler.CustomerHandler;
import com.rafiyad.reactivespringbootcrud.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {
    
    @Autowired
    private CustomerHandler handler;

    @Autowired
    private CustomerStreamHandler streamHandler;
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
         return RouterFunctions.route()
                 .GET("/router/customers",handler::loadAllCustomersFromHandler)
                 .GET("/router/customers/stream",streamHandler::loadAllCustomersFromStreamHandler)
                 .GET("/router/customers/{input}",handler::findCustomerById)
                 .POST("router/customers/save", handler::saveCustomer)
                 .build();
    }


}
