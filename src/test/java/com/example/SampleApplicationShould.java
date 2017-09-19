package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SampleApplicationShould {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void returnHelloWorldForHelloEndpointWhenNameParamIsNotDefined() {
        String result = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        Assert.assertEquals("Response is wrong for request without name param", "Hello World!", result);
    }

    @Test
    public void returnHelloNameForHelloEndpointWhenNameParamIsDefined() {
        String result = restTemplate.getForObject("http://localhost:8080/hello?name=Brazil", String.class);
        Assert.assertEquals("Response is wrong for request with name param", "Hello Brazil!", result);
    }

    @Test
    public void returnOriginalBodyForCallbackEndpoint() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("param1", "value1");
        params.add("param2", "value2");
        params.add("param3", "value3");
        params.add("param4", "value4");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String result = restTemplate.postForObject("http://localhost:8080/callback/some-id", request, String.class);
//        String result = restTemplate.postForObject("http://localhost:8080/callback", request, String.class);
        Assert.assertEquals("Response is wrong", result, "param1=value1&param2=value2&param3=value3&param4=value4");
    }
}
