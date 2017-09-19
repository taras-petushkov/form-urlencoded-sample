package com.example.application;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.nio.charset.Charset;

@RestController
public class CallbackController {

    @RequestMapping(value = "/callback/{some_id}")
    public String returnRequestBodyV1(@PathVariable("some_id") String someId,
                                      @RequestBody String body) throws Exception {
        return body;
    }

//    @RequestMapping(value = "/callback/{some_id}")
//    public String returnRequestBodyV2(@PathVariable("some_id") String someId,
//                                    HttpServletRequest request) throws Exception {
//        return StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset());
//    }
//
//    @RequestMapping(value = "/callback")
//    public String returnRequestBodyV3(HttpServletRequest request) throws Exception {
//        return StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset());
//    }
}
