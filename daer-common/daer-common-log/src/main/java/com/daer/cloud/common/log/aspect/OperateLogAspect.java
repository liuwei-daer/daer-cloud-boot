package com.daer.cloud.common.log.aspect;

import com.daer.cloud.common.log.util.OperateLogUtils;
import com.daer.cloud.common.log.vo.OperatLogVO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author liuwei
 * @date 2020-12-07
 */
@Slf4j
@Aspect
public class OperateLogAspect {


    @SneakyThrows
    @Around("@annotation(operateLog)")
    public Object around(ProceedingJoinPoint point, com.daer.cloud.common.log.annotation.OperateLog operateLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        OperatLogVO logVo = OperateLogUtils.getOperateLog();
        logVo.setTitle(operateLog.value());

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            log.debug("logVo:{}", logVo);
        }
        return obj;
    }
}
