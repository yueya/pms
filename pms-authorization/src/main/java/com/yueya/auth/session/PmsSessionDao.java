package com.yueya.auth.session;

import com.yueya.common.web.RestPage;
import org.apache.shiro.dao.DataAccessException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.yueya.auth.config.AuthConstant.ATTRIBUTE_LOGIN_NAME;

@Component
public class PmsSessionDao extends EnterpriseCacheSessionDAO implements SessionDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private String CACHE_PREFIX="shiro_session_";
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps(CACHE_PREFIX + sessionId.toString());
        sessionValueOperations.set(session);
        sessionValueOperations.expire(30, TimeUnit.MINUTES);
        return sessionId;
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if(session == null){
            BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps(CACHE_PREFIX + sessionId.toString());
            session = (Session) sessionValueOperations.get();
        }
        return session;
    }
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        BoundValueOperations<String, Object> sessionValueOperations = redisTemplate.boundValueOps("shiro_session_" + session.getId().toString());
        sessionValueOperations.set(session);
        sessionValueOperations.expire(30, TimeUnit.MINUTES);
    }

    /**
     * 删除失效session
     */
    @Override
    protected void doDelete(Session session) {
        redisTemplate.delete(CACHE_PREFIX + session.getId().toString());
        super.doDelete(session);
    }

    @Override
    public RestPage getActiveSessions(int offset, int limit) {
        Set<String> keys=redisTemplate.keys(CACHE_PREFIX+"*");
        SessionCallback<List<Session>> sessionCallback=new SessionCallback<List<Session>>() {
            @Override
            public List<Session> execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                int max=(offset+limit)>=keys.size()?keys.size():(offset+limit);
                keys.stream().collect(Collectors.toList()).subList(offset,max).forEach(key-> redisOperations.boundValueOps(key).get());
                return redisOperations.exec();
            }
        };
        List<Session> list =redisTemplate.execute(sessionCallback)
                .stream().map(r->{
                    SimpleSession session=new SimpleSession();
                    session.setId(r.getId());
                    session.setHost(r.getHost());
                    session.setAttribute(ATTRIBUTE_LOGIN_NAME,r.getAttribute(ATTRIBUTE_LOGIN_NAME));
                    session.setStartTimestamp(r.getStartTimestamp());
                    session.setLastAccessTime(r.getLastAccessTime());
                    return session;
                }).collect(Collectors.toList());
        return new RestPage(list,keys.size());
    }

    @Override
    public void forceOut(String ids) {

    }
}
