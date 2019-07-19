package by.pvt.service;

import by.pvt.dao.ClientFeedbackMapper;
import by.pvt.dto.ClientFeedback;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ClientFeedbackServise {
    private SqlSessionFactory sqlSessionFactory;

    public ClientFeedbackServise() {
        try {
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("by/pvt/service/mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFeedback(ClientFeedback clientFeedback) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClientFeedbackMapper dao = sqlSession.getMapper(ClientFeedbackMapper.class);
        dao.insert(clientFeedback);
        System.out.println("Feedback add");
        sqlSession.commit();
        sqlSession.close();
    }

    public List<ClientFeedback> selectAllFeedback() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ClientFeedbackMapper dao = sqlSession.getMapper(ClientFeedbackMapper.class);

        List<ClientFeedback> list = dao.selectByExample(null);

        System.out.println("Feedback selected");
        sqlSession.close();
        return list;
    }

    public static void main(String[] args) {
        ClientFeedbackServise  clientFeedbackServise=  new ClientFeedbackServise();
        ClientFeedback clientFeedback= new ClientFeedback();
        clientFeedback.setProductId(1);
        clientFeedback.setMessage("sdsdsdsdsd");
        clientFeedback.setId(1);
        clientFeedback.setClientId(1);
        clientFeedback.setPostDate(new Date());
        clientFeedbackServise.selectAllFeedback();
        clientFeedbackServise.addFeedback(clientFeedback);
        clientFeedbackServise.selectAllFeedback();
    }
}
