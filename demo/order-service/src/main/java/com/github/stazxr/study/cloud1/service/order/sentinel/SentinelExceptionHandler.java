package com.github.stazxr.study.cloud1.service.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SentinelExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        String message;
        int status = 429;
        if (e instanceof FlowException) {
            message = "请求被限流了！";
        } else if (e instanceof DegradeException) {
            message = "请求被降级了！";
        } else if (e instanceof ParamFlowException) {
            message = "热点参数限流！";
        } else if (e instanceof AuthorityException) {
            message = "请求没有权限！";
            status = 401;
        } else if (e instanceof SystemBlockException) {
            message = "系统规则限流！";
        } else {
            message = "未知异常";
        }

        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        response.getWriter().println("{\"message\": \"" + message + "\", \"status\": " + status + "}");
    }
}
