package com.seven.boot.admin.controller.system;

import com.seven.boot.common.constant.Constants;
import com.seven.boot.common.core.domain.R;
import com.seven.boot.common.core.domain.model.LoginBody;
import com.seven.boot.core.admin.service.SysLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录验证
 *
 * @author QH
 */
@RestController
@Api(tags = "登录接口")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginBody loginBody) {
        R r = R.success();
        // 生成token
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        r.put(Constants.TOKEN, token);
        return r;
    }

}
