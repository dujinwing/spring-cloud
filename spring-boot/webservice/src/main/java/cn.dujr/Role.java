package cn.dujr;

import lombok.Data;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@Data
public class Role {

    private String roleName;

    private int RoleLevel;

    List<RoleDetail> roleDetailList;
}
