package cn.edu.guet.test;

import cn.edu.guet.service.IRoleService;
import cn.edu.guet.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RoleTest {


    @Autowired
    private IRoleService roleServiceImpl;

    @Test
    public void testDeleteRole(){
        roleServiceImpl.deleteRoleById("26f627db863442a9966c69a9e69712a2");
    }
}
