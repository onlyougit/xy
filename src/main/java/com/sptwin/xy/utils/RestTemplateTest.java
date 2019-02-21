/*
package com.sptwin.xy.utils;

import com.alibaba.fastjson.JSONObject;
import com.sptwin.xy.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RestTemplateTest {
    @Autowired
    private RestTemplate restTemplate;

    */
/**
     * 无参数的 getForEntity 方法
     *
     * @return
     *//*

    public List<SysUser> getAll2() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost/getAll", List.class);
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int code = statusCode.value();
        List<SysUser> list = responseEntity.getBody();
        System.out.println(list.toString());
        return list;
    }

    */
/**
     * 有参数的 getForEntity 请求,参数列表,可以使用 {} 进行url路径占位符
     *
     * @param id
     * @return
     *//*

    public SysUser getById2(@PathVariable(name = "id") String id) {
        ResponseEntity<SysUser> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}", SysUser.class, id);
        SysUser userEntity = responseEntity.getBody();
        return userEntity;
    }

    */
/**
     * 有参数的 get 请求,使用map封装参数
     *
     * @param id
     * @return
     *//*

    public SysUser getById4(@PathVariable(name = "id") String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        ResponseEntity<SysUser> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}", SysUser.class, map);
        SysUser userEntity = responseEntity.getBody();
        return userEntity;
    }
    //但是,通常情况下我们并不想要Http请求的全部信息,只需要相应体即可.-------------------------

    */
/**
     * 无参数的 getForObject 请求
     *
     * @return
     *//*

    public List<SysUser> getAll() {
        List<SysUser> list = restTemplate.getForObject("http://localhost/getAll", List.class);
        System.out.println(list.toString());
        return list;
    }

    */
/**
     * 有参数的 getForObject 请求,使用参数列表
     *
     * @param id
     * @return
     *//*

    public SysUser getById(@PathVariable(name = "id") String id) {
        SysUser userEntity = restTemplate.getForObject("http://localhost/get/{id}", SysUser.class, id);
        return userEntity;
    }

    */
/**
     * 有参数的 get 请求,使用map封装请求参数
     *
     * @param id
     * @return
     *//*

    public SysUser getById3(@PathVariable(name = "id") String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        SysUser userEntity = restTemplate.getForObject("http://localhost/get/{id}", SysUser.class, map);
        return userEntity;
    }
    //POST-------------------------------------------

    */
/**
     * 保存 UserEntity 对像
     *
     * @param userEntity
     * @return
     *//*

    public String save(SysUser userEntity) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", userEntity, String.class);
        String body = responseEntity.getBody();
        return body;
    }

    */
/**
     * 有参数的 postForEntity 请求
     *
     * @param userEntity
     * @param type
     * @return
     *//*

    public String save2(SysUser userEntity, @PathVariable("type") String type) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class, type);
        String body = responseEntity.getBody();
        return body;
    }

    */
/**
     * 有参数的 postForEntity 请求,使用map封装
     *
     * @param userEntity
     * @param type
     * @return
     *//*

    public String save3(SysUser userEntity, @PathVariable("type") String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class, map);
        String body = responseEntity.getBody();
        return body;
    }

    public void test(){
        JSONObject msg = new JSONObject();
        msg.put("key","@*2y9$jl");
        msg.put("receiver",receiverEcommerceId);
        msg.put("title",title);
        msg.put("content",content);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(msg.toJSONString(), headers);
        JSONObject result = restTemplate.postForObject(url, request, JSONObject.class);

        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("deptId","30001821");
        postParameters.add("ipList","192.1.1.1,192.3.2.1");
        postParameters.add("alarmGrd","1");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                postParameters, headers);
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        ResponseEntity<UserEntity> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}", UserEntity.class, map);
        UserEntity userEntity = responseEntity.getBody();


        //http://you domainn name/test?empNo={empNo}
        ResponseEntity<List<KyArea>> result = restTemplate.exchange(DIVIDE_PLATE_API, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<KyArea>>() {}, map("empNo", empNo));
        List<KyArea> list = result.getBody();

        ResponseEntity<KyArea> result = restTemplate.exchange(DIVIDE_PLATE_API, HttpMethod.GET, HttpEntity.EMPTY, KyArea.class, map("empNo", empNo));
        KyArea kyArea = result.getBody();

        RestTemplate sslRestTemplate = new RestTemplate(new HttpsClientRequestFactory());
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;
            }
            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        };
        sslRestTemplate.setErrorHandler(responseErrorHandler);
    }
}
*/
