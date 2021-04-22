package com.seven.boot.system.mapper;

import com.seven.boot.common.core.domain.entity.SysMenu;

import java.util.List;

/**
 * 菜单数据层
 *
 * @author QH
 */
public interface SysMenuMapper {

    /**
     * 查询菜单
     *
     * @return 菜单列表
     */
    List<SysMenu> selectMenuTreeAll();

    /**
     * 根据userid查询菜单
     *
     * @param userId 用户id
     * @return 菜单列表
     */
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根据用户id查询权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    List<String> selectMenuPermsByUserId(Long userId);
}
