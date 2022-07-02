package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Permission;
import cn.edu.guet.mapper.PermissionMapper;
import cn.edu.guet.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> permissionList() {
        return permissionMapper.permissionList();
    }

    @Override
    public boolean addpermission(Permission permission, String pidname) {
        String pid = permissionMapper.getPermissionid(pidname);
        permission.setpId(pid);
        int a = permissionMapper.addpermission(permission);
        return a!=0;
    }

    @Override
    public boolean updatepermission(Permission permission) {
        int a = permissionMapper.updatepermission(permission);
        return a!=0;
    }

    @Override
    public boolean deletepermission(String permissionname) {
        int a = permissionMapper.deletepermission(permissionname);
        return a!=0;
    }
}
