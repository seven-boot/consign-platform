package com.seven.boot.admin.security.handle;

import com.alibaba.fastjson.JSON;
import com.seven.boot.admin.service.TokenService;
import com.seven.boot.common.core.domain.R;
import com.seven.boot.common.core.domain.model.LoginUser;
import com.seven.boot.common.util.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 自定义退出处理类
 *
 * @author QH
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // TODO 处理退出逻辑
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (Objects.nonNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // TODO 记录用户退出日志
        }
        ServletUtils.renderString(response, JSON.toJSONString(R.error(HttpStatus.OK.value(), "退出成功")));
    }
}
