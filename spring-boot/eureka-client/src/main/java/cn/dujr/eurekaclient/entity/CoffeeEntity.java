package cn.dujr.eurekaclient.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@Builder
public class CoffeeEntity{
    @Id
    private String id;
    private String name;
    private String price;
    private Date createDate;
    private Date updateDate;
}
