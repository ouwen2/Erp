package com.upup.sys.shiro;

import com.upup.sys.mapper.SysEmpMapper;
import com.upup.sys.model.SysEmp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysEmpMapper sysEmpMapper;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = principalCollection.getPrimaryPrincipal().toString();

        Set<String> roles = sysEmpMapper.findRoles(username);
        System.out.println("roles:"+roles);

        Set<String> permissions = sysEmpMapper.findPermissions(username);
        System.out.println("permissions:"+permissions);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();

        SysEmp sysEmp = sysEmpMapper.selectByName(username);

        if(sysEmp==null)
            throw new UnknownAccountException("账号错误");

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sysEmp.getUsername(),
                sysEmp.getPwd(),
                ByteSource.Util.bytes(sysEmp.getSalt()),
                this.getName()
        );
        System.out.println(sysEmp);
        return simpleAuthenticationInfo;
    }


}
