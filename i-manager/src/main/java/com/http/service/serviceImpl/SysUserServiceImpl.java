package com.http.service.serviceImpl;

import com.http.model.SysUser;
import com.http.dao.SysUserDao;
import com.http.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author GR·cheng
 * @since 2017-11-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
	
}
