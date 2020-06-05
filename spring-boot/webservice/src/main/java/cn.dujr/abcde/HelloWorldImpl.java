package cn.dujr.abcde;

import cn.dujr.Dept;
import cn.dujr.Role;
import cn.dujr.RoleDetail;
import cn.dujr.User;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Service
@WebService(serviceName = "WebServiceDemoService", // 与接口中指定的name一致
        targetNamespace = "http://abcde.dujr.cn/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "cn.dujr.abcde.HelloWorld" // 接口地址
)
public class HelloWorldImpl implements HelloWorld{
    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    @Override
    public String goodBye() {
        return "<return>\n" +
                "\t<infos>\n" +
                "\t\t<info>\n" +
                "\t\t\t<id>60000001</id>\n" +
                "\t\t\t<hisCode>F000000001</hisCode>\n" +
                "\t\t\t<severity>3</severity>\n" +
                "\t\t\t<type>重复收费</type>\n" +
                "\t\t\t<hisName>气管切开护理</hisName>\n" +
                "\t\t\t<message>气管切开护理不可同时收取吸痰护理费。</message>\n" +
                "\t\t\t<advice>请核实费用。</advice>\n" +
                "\t\t\t<source>医保政策管理</source>\n" +
                "\t\t</info>\n" +
                "\t\t<info>\n" +
                "\t\t\t<id>60000002</id>\n" +
                "\t\t\t<hisCode>F000000002</hisCode>\n" +
                "\t\t\t<severity>5</severity>\n" +
                "\t\t\t<type>限频次</type>\n" +
                "\t\t\t<hisName>Ⅱ级护理</hisName>\n" +
                "\t\t\t<message>住院级别护理项目收费次数超过住院总天数。</message>\n" +
                "\t\t\t<advice>请核实费用。</advice>\n" +
                "\t\t\t<source>医保政策管理</source>\n" +
                "\t\t</info>\n" +
                "\t</infos>\n" +
                "\t<isSuccess>1</isSuccess>\n" +
                "\t<message>规则审核接口调用成功！</message>\n" +
                "\t<auditNo>Z1234567820200101235959</auditNo>\n" +
                "</return>";
    }

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setName(username);
        user.setAge(20);

        Role role1 = new Role();
        role1.setRoleLevel(1);
        role1.setRoleName("系统管理员");

        RoleDetail roleDetail1 = new RoleDetail();
        roleDetail1.setRoleDetailLevel("1");
        roleDetail1.setRoleDetailName("角色明细名称1");
        roleDetail1.setRoleDetailType("角色明细类型1");

        List roleDetails1 = new ArrayList();
        roleDetails1.add(roleDetail1);
        role1.setRoleDetailList(roleDetails1);

        RoleDetail roleDetail2 = new RoleDetail();
        roleDetail2.setRoleDetailLevel("2");
        roleDetail2.setRoleDetailName("角色明细名称2");
        roleDetail2.setRoleDetailType("角色明细类型2");

        RoleDetail roleDetail3 = new RoleDetail();
        roleDetail3.setRoleDetailLevel("3");
        roleDetail3.setRoleDetailName("角色明细名称3");
        roleDetail3.setRoleDetailType("角色明细类型3");

        List roleDetails2 = new ArrayList();
        roleDetails2.add(roleDetail1);
        roleDetails2.add(roleDetail2);

        Role role2 = new Role();
        role2.setRoleLevel(2);
        role2.setRoleName("普通用户");
        role2.setRoleDetailList(roleDetails2);

        Role role3 = new Role();
        role3.setRoleLevel(3);
        role3.setRoleName("超级管理员");
        List roleDetails3 = new ArrayList();
        roleDetails3.add(roleDetail1);
        roleDetails3.add(roleDetail2);
        roleDetails3.add(roleDetail3);
        role3.setRoleDetailList(roleDetails3);

        List roles = new ArrayList();
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        Dept dept = new Dept();
        dept.setDeptId("123");
        dept.setDeptName("科室名字");

        user.setRole(roles);
        user.setDept(dept);

        return user;
    }
}
