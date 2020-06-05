package com.demo.project.system.service.impl;

import com.demo.project.system.entity.Role;
import com.demo.project.system.mapper.RoleMapper;
import com.demo.project.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author lkz
 * @since 2020-06-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
