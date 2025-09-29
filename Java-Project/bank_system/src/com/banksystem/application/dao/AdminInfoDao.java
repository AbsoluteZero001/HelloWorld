package com.banksystem.application.dao;

import com.banksystem.application.db.Database;
import com.banksystem.application.entity.AdminInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminInfoDao {
/**
 * 添加管理员信息的方法
 * @param adminInfo 包含管理员信息的AdminInfo对象
 */
    public static void addAdmin(AdminInfo adminInfo) {
        // 获取数据库连接
        Connection conn = Database.getConn();
        // 定义SQL插入语句，使用占位符防止SQL注入
        String sql = "INSERT INTO admin_info (password, nickname, name, mobile) VALUES (?,?,?,?)";
        try {
            // 创建PreparedStatement对象并设置参数
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置第一个参数为密码
            ps.setString(1, adminInfo.getPassword());
            // 设置第二个参数为昵称
            ps.setString(2, adminInfo.getNickname());
            // 设置第三个参数为姓名
            ps.setString(3, adminInfo.getName());
            // 设置第四个参数为手机号
            ps.setString(4, adminInfo.getMobile());
            // 执行更新操作，返回受影响的行数
            int i = ps.executeUpdate();
            // 如果受影响的行数大于0，表示添加成功
            if (i > 0) {
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            // 捕获SQL异常并转换为运行时异常抛出
            throw new RuntimeException(e);
        }
    }

    // 根据 mobile 查询 AdminInfo
    public static AdminInfo getAdminByMobile(String mobile) {
        Connection conn = Database.getConn();
        String sql = "SELECT id, password, nickname, name, mobile, state, deleted, create_by, update_by, create_time, update_time FROM admin_info WHERE mobile = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AdminInfo admin = new AdminInfo();
                admin.setId(rs.getLong("id"));
                admin.setPassword(rs.getString("password"));
                admin.setNickname(rs.getString("nickname"));
                admin.setName(rs.getString("name"));
                admin.setMobile(rs.getString("mobile"));
                return admin;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // 没有找到
    }

/**
 * 根据管理员ID获取管理员信息的方法
 * @param id 管理员ID
 * @return AdminInfo对象，如果未找到则返回null
 */
    public static AdminInfo getAdminById(Long id) {
    // 获取数据库连接
        Connection conn = Database.getConn();
    // SQL查询语句，根据id查询管理员信息
        String sql = "SELECT id, password, nickname, name, mobile, state, deleted, create_by, update_by, create_time, update_time FROM admin_info WHERE id = ?";
        try {
        // 创建PreparedStatement对象，防止SQL注入
            PreparedStatement ps = conn.prepareStatement(sql);
        // 设置查询参数
            ps.setLong(1, id);
        // 执行查询，获取结果集
            ResultSet rs = ps.executeQuery();
        // 如果结果集中有数据
            if (rs.next()) {
            // 创建AdminInfo对象
                AdminInfo admin = new AdminInfo();
            // 从结果集中获取id并设置
                admin.setId(rs.getLong("id"));
            // 从结果集中获取password并设置
                admin.setPassword(rs.getString("password"));
            // 从结果集中获取nickname并设置
                admin.setNickname(rs.getString("nickname"));
            // 从结果集中获取name并设置
                admin.setName(rs.getString("name"));
            // 从结果集中获取mobile并设置
                admin.setMobile(rs.getString("mobile"));
            // 返回查询到的管理员信息
                return admin;
            }
        } catch (SQLException e) {
        // 抛出运行时异常
            throw new RuntimeException(e);

        }
    // 如果没有找到对应的管理员，返回null
        return null; // 没有找到
    }


    //根据id删除数据库中的管理员信息
    public static void deleteAdminById(Long id) {
        // 获取数据库连接
        Connection conn = Database.getConn();
        // 定义SQL删除语句，使用占位符防止SQL注入
        String sql = "DELETE FROM admin_info WHERE id = ?";
        try {
            // 创建PreparedStatement对象并设置参数
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置第一个参数为id
            ps.setLong(1, id);
            // 执行更新操作，返回受影响的行数
            int i = ps.executeUpdate();
            // 如果受影响的行数大于0，表示删除成功
            if (i > 0)
                System.out.println("删除成功");
        }catch (SQLException e) {
            // 捕获SQL异常并转换为运行时异常抛出
            throw new RuntimeException(e);
        }
    }

}
