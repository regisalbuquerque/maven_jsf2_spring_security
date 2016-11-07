package config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecutiryWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer{
    public SecutiryWebApplicationInitializer()
    {
        super(SecurityConfig.class);
    }
}
