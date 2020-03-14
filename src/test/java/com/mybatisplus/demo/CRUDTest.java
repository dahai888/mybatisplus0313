package com.mybatisplus.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.demo.entity.User;
import com.mybatisplus.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CRUDTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("Helen6");
        user.setAge(46);
        user.setEmail("120@qq.com");
        int result  = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }



    @Test
    public void testUpdata(){
        User user  = new User();
        user.setId(1L);
        user.setName("jom");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }


    @Test
    public void testSelectId(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    /**
     完成了动态sql的foreach的功能
     通过多个id批量查询
    */
    @Test
    public void testSelectBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 8));
        users.forEach(System.out::println);
    }

    /**
     * 组装多个查询条件
     *
     */
    @Test
    public void testSelectByMap(){
        HashMap<String , Object> map = new HashMap<>();
//        map.put("name","Billie");
        map.put("name","Helen1");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);


    }

    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(1,2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());

    }

    @Test
    public void testSelectPages(){
        Page<User> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println("page.getCurrent():"+page.getCurrent());
        System.out.println("page.getRecords(:"+page.getRecords());
        System.out.println("page.getSize():"+page.getSize());
        System.out.println("page.getPages():"+page.getPages());
        System.out.println("page.hasPrevious():"+page.hasPrevious());
        System.out.println("page.hasNext():"+page.hasNext());

    }



    @Test
    public void testDeleteId(){
        int i = userMapper.deleteById(1238464889048014854L);
        System.out.println(i);
    }

    //逻辑删除
    @Test
    public void testLogicDelete(){
        int result = userMapper.deleteById(4L);
        System.out.println(result);

    }


}
