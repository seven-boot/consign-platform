package com.seven.boot.dao.service;

import java.util.Set;

/**
 * 角色业务层
 *
 * @author QH
 */
public interface ISysRoleService {

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 权限列表
     */
    Set<String> selectRolePermissionByUserId(Long userId);
}
