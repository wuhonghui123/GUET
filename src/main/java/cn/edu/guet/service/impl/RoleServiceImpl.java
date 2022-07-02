package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.mapper.RoleMapper;
import cn.edu.guet.mapper.RolePermissionMapper;
import cn.edu.guet.mapper.UserRoleMapper;
import cn.edu.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(noRollbackFor = RuntimeException.class)
    public boolean deleteRoleById(String roleId) {
        rolePermissionMapper.deleteRolePermission(roleId);//成功
        userRoleMapper.deleteUserRole(roleId);//成功
        /*
        Spring事务管理，默认针对运行时异常回滚
         */
        int a = roleMapper.deleteRoleById(roleId);//失败
        return a!=0;
    }

    @Override
    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    @Override
    public boolean addrole(String rolename, String roleinfor) {
        String roleid = UUID.randomUUID().toString().replace("-","");
        int b = roleMapper.addrole(rolename,roleid);
        int a = (roleinfor.length()+1)/33;
        System.out.println("菜单个数"+a);
        String[] result = roleinfor.split(",");
        for(String r : result){
            System.out.println("分割结果" + r);
        }
        for(int i = 0;i<a;i++){
            rolePermissionMapper.addrolePermission(roleid,result[i]);
        }
        return b!=0;
    }

    @Override
    public List<Role> getRolePermissionList() {
        return rolePermissionMapper.getRolePermissionList();
    }

    @Override
    public boolean upaterole(String roleid, String rolename, String roleinfor) {
        int a = (roleinfor.length()+1)/33;
        System.out.println("菜单个数"+a);
        String[] result = roleinfor.split(",");
        for(String r : result){
            System.out.println("分割结果" + r);
        }
        rolePermissionMapper.deleteRolePermission(roleid);
        for(int i = 0;i<a;i++){
            rolePermissionMapper.addrolePermission(roleid,result[i]);
        }
        int b = roleMapper.updaterole(rolename,roleid);
        return b!=0;
    }
}
