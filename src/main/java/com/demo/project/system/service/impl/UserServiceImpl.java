package com.demo.project.system.service.impl;

import com.demo.project.system.entity.User;
import com.demo.project.system.mapper.UserMapper;
import com.demo.project.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author lkz
 * @since 2020-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
