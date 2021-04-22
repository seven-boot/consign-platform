package com.seven.boot.admin.controller.system;

import com.seven.boot.common.annotation.CurrentUser;
import com.seven.boot.common.constant.Constants;
import com.seven.boot.common.core.domain.R;
import com.seven.boot.common.core.domain.entity.SysMenu;
import com.seven.boot.common.core.domain.entity.SysUser;
import com.seven.boot.common.core.domain.model.LoginBody;
import com.seven.boot.core.admin.service.SysLoginService;
import com.seven.boot.core.admin.service.SysPermissionService;
import com.seven.boot.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author QH
 */
@RestController
@Api(tags = "登录验证")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysMenuService menuService;

    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginBody loginBody) {
        R r = R.success();
        // 生成token
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        r.put(Constants.TOKEN, token);
        return r;
    }

    @GetMapping("get-info")
    @ApiOperation("获取用户信息")
    public R getInfo(@CurrentUser SysUser user) {
        // 查询角色集合
        Set<String> rolePerms = permissionService.getRolePermission(user);
        // 查询权限集合
        Set<String> menuPerms = permissionService.getMenuPermission(user);
        R r = R.success();
        r.put("user", user);
        r.put("roles", rolePerms);
        r.put("permissions", menuPerms);
        return r;
    }

    @GetMapping("get-routers")
    @ApiOperation("获取路由信息")
    public R getRouters(@CurrentUser SysUser user) {
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return R.success(menuService.buildMenus(menus));
    }

}
