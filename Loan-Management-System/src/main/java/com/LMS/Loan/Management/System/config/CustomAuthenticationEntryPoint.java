package com.LMS.Loan.Management.System.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence ( HttpServletRequest request , HttpServletResponse response ,
                           AuthenticationException authException )
            throws IOException {
        response.setContentType ( "application/json" );
        response.setStatus ( HttpServletResponse.SC_UNAUTHORIZED );

        Map < String, Object > body = new HashMap <> ( );
        body.put ( "status" , HttpServletResponse.SC_UNAUTHORIZED );
        body.put ( "error" , "Forbidden" );
        body.put ( "message" , "Invalid or missing token" );

        OutputStream out = response.getOutputStream ( );
        ObjectMapper mapper = new ObjectMapper ( );
        mapper.writeValue ( out , body );
        out.flush ( );
    }
}
