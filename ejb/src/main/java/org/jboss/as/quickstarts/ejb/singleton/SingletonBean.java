package org.jboss.as.quickstarts.ejb.singleton;

import org.jboss.ejb3.annotation.RunAsPrincipal;
import org.jboss.ejb3.annotation.SecurityDomain;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

@Singleton
@Startup
@Remote(WhoAmI.class)
//@RolesAllowed("Users")
@RunAs("Admin")
@RunAsPrincipal("Helloween")
@SecurityDomain("other")
public class SingletonBean implements WhoAmI {
    private static Logger LOGGER = Logger.getLogger(SingletonBean.class.getName());
    @EJB(beanName = "StatelessBBean")
    private WhoAmI beanB;

    private String principal;

    @PostConstruct
    public void init() {
        principal = beanB.getCallerPrincipal();
        LOGGER.info("principal: " + principal);
        assert "Helloween".equals(principal);
    }

    public String getCallerPrincipal() {
        return principal;
    }
}
