package com.peak.serurity.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName : UserRealm
 * @Author : Administrator
 * @Date: 2023/03/16 7:59
 * @Description : 自定义的Realm
 */

/**
 * 自定义的 Realm 类需要继承 AuthorizingRealm 类并实现其中的抽象方法，即授权和认证的方法；此处先让它们简单地执行输出。
 * 有了自定义 Realm 类之后，就可以回到 ShiroConfig 进行配置了
 */
public class UserRealm extends AuthorizingRealm {

    //授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了 授权 方法 doGetAuthorizationInfo！");
        return null;
    }


   //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了 认证 方法 doGetAuthenticationInfo！");
        return null;
    }
}
