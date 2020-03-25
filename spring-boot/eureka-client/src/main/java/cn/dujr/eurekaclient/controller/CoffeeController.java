package cn.dujr.eurekaclient.controller;

import cn.dujr.eurekaclient.entity.CoffeeEntity;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CoffeeController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/test")
    public String test(@RequestParam(value = "name") String name) {
        return "hi " + name + " i'm from  " + port;
    }

    @GetMapping(value = "save")
    public String save(String name) {
        CoffeeEntity entity = CoffeeEntity.builder().name("espresso").price("20").createDate(new Date()).updateDate(new Date()).build();
        mongoTemplate.save(entity);
        return "success";
    }

    @GetMapping(value = "query")
    public List<CoffeeEntity> queryByName(String name){
        List<CoffeeEntity> list = this.mongoTemplate.find(Query.query(Criteria.where("name").is(name)), CoffeeEntity.class);
        return list;
    }
}
