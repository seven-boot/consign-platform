package com.seven.boot.system.service;

import com.seven.boot.common.core.domain.entity.SysMenu;
import com.seven.boot.system.domain.vo.RouterVO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 菜单业务层
 *
 * @author QH
 */
public interface ISysMenuService {

    /**
     * 根据用户id查询菜单树信息
     *
     * @param userId 用户id
     * @return 菜单列表
     */
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    List<RouterVO> buildMenus(List<SysMenu> menus);

    /**
     * 根据用户id查询权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    Set<String> selectMenuPermsByUserId(Long userId);
}
