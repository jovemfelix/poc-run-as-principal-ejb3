package org.jboss.as.quickstarts.ejb.singleton;

import org.jboss.ejb3.annotation.SecurityDomain;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
@Local(WhoAmI.class)
@RolesAllowed("Admin")
@SecurityDomain("other")
public class StatelessBBean implements WhoAmI {
    @Resource
    private SessionContext ctx;

    public String getCallerPrincipal() {
        return ctx.getCallerPrincipal().getName();
    }
}
