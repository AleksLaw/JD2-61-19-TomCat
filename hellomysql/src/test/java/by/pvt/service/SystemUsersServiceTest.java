package by.pvt.service;

import by.pvt.dto.SystemUsers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class SystemUsersServiceTest {
    SystemUsersService objUnderTest;


    @Test
    public void getSystemUsers() throws IOException {
        objUnderTest= new SystemUsersService();
        objUnderTest.setSqlSessionFactory(
                new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsStream("by/pvt/service/mybatis-config-junit.xml")
                )
        );

        List<SystemUsers> list = objUnderTest.getSystemUsers(null);

        assertEquals(4, list.size());
    }
}