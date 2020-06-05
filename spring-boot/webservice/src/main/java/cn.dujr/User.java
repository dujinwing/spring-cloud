package cn.dujr;

import lombok.Data;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@Data
public class User {
    private String name;

    private int age;

    private List<Role> role;

    private Dept dept;
}
