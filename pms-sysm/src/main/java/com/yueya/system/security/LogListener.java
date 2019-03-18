package com.yueya.system.security;

import com.yueya.auth.model.PmsLog;
import com.yueya.common.util.ObjectUtils;
import com.yueya.system.dao.tables.pojos.SysLogDO;
import com.yueya.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

import static com.yueya.auth.config.AuthConstant.LOG_CHANNEL;

@Service
public class LogListener implements MessageListener {
    @Autowired
    private SysLogService logService;
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String channel=new String(message.getChannel());
        if(LOG_CHANNEL.equals(channel)){
            PmsLog pmsLog= (PmsLog) ObjectUtils.unserialize(message.getBody());
            SysLogDO logDO=new SysLogDO();
            logDO.setCreateDate(new Timestamp(new Date().getTime()));
            logDO.setCreateBy(pmsLog.getUserName());
            logDO.setTitle(pmsLog.getTitle());
            logDO.setAppId(pmsLog.getAppId());
            logDO.setType(pmsLog.getType());
            logDO.setMethod(pmsLog.getMethod());
            logDO.setParams(pmsLog.getParams());
            logDO.setRemoteAddr(pmsLog.getRemoteAddress());
            logDO.setRequestUri(pmsLog.getRequestUri());
            logDO.setUserAgent(pmsLog.getUserAgent());
            logService.saveLog(logDO);
        }
    }
}
