package com.banksystem.application.dao;

import com.banksystem.application.entity.AdminInfo;
import junit.framework.TestCase;

public class AdminInfoDaoTest extends TestCase {


    public void testAddAdmin() {
        AdminInfoDao adminInfoDao = new AdminInfoDao();
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setPassword("12345678");
        adminInfo.setNickname("许三土");
        adminInfo.setName("土三许");
        adminInfo.setMobile("17740144414");
        AdminInfoDao.addAdmin(adminInfo);
        }


/**
 * 测试通过手机号获取管理员信息的方法
 * 该方法创建AdminInfoDao实例，并调用其getAdminByMobile方法查询指定手机号的管理员信息
 */
    public void testGetAdminByMobile() {
        // 创建AdminInfoDao实例，用于执行数据库操作
        AdminInfoDao adminInfoDao = new AdminInfoDao();
        // 调用getAdminByMobile方法，传入手机号参数"1774014441400"，获取管理员信息
        AdminInfo adminByMobile = adminInfoDao.getAdminByMobile("17740144414000");
        // 输出查询到的管理员信息到控制台
        System.out.println(adminByMobile);

    }


/**
 * 测试通过ID获取管理员信息的方法
 * 该方法用于验证AdminInfoDao中的getAdminById方法是否正常工作
 */
    public void testTestGetAdminById() {
        // 创建AdminInfoDao实例，用于访问数据库中的管理员信息
        AdminInfoDao adminInfoDao = new AdminInfoDao();
        // 调用getAdminById方法，传入ID参数13，获取对应的管理员信息 字符串转化为Long类型
        AdminInfo adminById = adminInfoDao.getAdminById(Long.valueOf(13));

        // 打印获取到的管理员信息，用于验证结果
        System.out.println(adminById);
    }
}
