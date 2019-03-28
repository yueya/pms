package com.yueya.auth.session;

import com.yueya.system.Application;
import org.apache.shiro.dao.DataAccessException;
import org.apache.shiro.session.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PmsSessionDaoTest {

    @Autowired
    PmsSessionDao sessionDao;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Before
    public void setUp() throws Exception {
      /*  redisTemplate.boundValueOps("1").set("1");
        redisTemplate.boundValueOps("2").set("2");
        redisTemplate.boundValueOps("3").set("3");
        redisTemplate.boundValueOps("4").set("4");*/
    }
    @Test
    public void getActiveSessions() {
      /*  SessionPage page=sessionDao.getActiveSessions(1,10);
        System.out.println(page.getCount());
        page.getList().stream().forEach(r-> System.out.println(r));*/
      int offset=0;int limit=6;
       /* Session session=new SimpleSession();
        ((SimpleSession) session).setId("1111");
        redisTemplate.boundValueOps("shiro_session_1111").set(session);*/
        Set<String> keys=redisTemplate.keys("shiro_session_*");
        SessionCallback<List<Session>> sessionCallback=new SessionCallback<List<Session>>() {
            @Override
            public List<Session> execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                int max=(offset+limit)>=keys.size()?keys.size():(offset+limit);
                keys.stream().collect(Collectors.toList()).subList(offset,max).forEach(key-> redisOperations.boundValueOps(key).get());
                return redisOperations.exec();
            }
        };
       List<Session> list=redisTemplate.execute(sessionCallback);
       list.forEach(r->{
           System.out.println(r);
       });
    }
}