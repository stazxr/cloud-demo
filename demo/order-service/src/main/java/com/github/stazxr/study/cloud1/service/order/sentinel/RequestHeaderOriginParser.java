package com.github.stazxr.study.cloud1.service.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class RequestHeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String origin = request.getHeader("origin");
        if (origin == null || "".equals(origin)) {
            origin = "blank";
        }

        return origin;
    }
}
