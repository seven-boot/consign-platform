package com.seven.boot.dao.service.impl;

import com.seven.boot.common.core.domain.entity.SysRole;
import com.seven.boot.dao.mapper.SysRoleMapper;
import com.seven.boot.dao.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 角色业务处理层
 *
 * @author QH
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        perms.forEach(r -> {
            if (Objects.nonNull(r)) {
                permsSet.addAll(Arrays.asList(r.getRoleKey().trim().split(",")));
            }
        });
        return permsSet;
    }
}
