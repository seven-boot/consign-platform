package com.seven.boot.dao.mapper;

import com.seven.boot.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * 角色数据层
 *
 * @author QH
 */
public interface SysRoleMapper {

    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<SysRole> selectRolePermissionByUserId(Long userId);
}
