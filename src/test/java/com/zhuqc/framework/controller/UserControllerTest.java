package com.zhuqc.framework.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zhuqc.framework.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Zhu.Qianchang
 * @date 2020-06-01
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    private static Gson gson = new GsonBuilder().serializeNulls().create();

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "classpath:h2/user/init-data.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "classpath:h2/user/clean-data.sql")
    })
    void getUser() throws Exception {
        // 模拟GET请求
        mvc.perform(get("/user/1")
                // 请求参数类型
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                // 接收参数类型
                .accept(MediaType.APPLICATION_JSON_UTF8))
                // 结果验证
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(200))
                .andExpect(jsonPath("data").exists())
                .andExpect(jsonPath("$['data']['account']").value("zhuqc1"))
                .andExpect(jsonPath("$['data']['password']").value("password"))
                .andExpect(jsonPath("$['data']['nickname']").value("zhuqc1"))
                .andExpect(jsonPath("$['data']['email']").value("zqc@zqc.com"))
                .andExpect(jsonPath("$['data']['phone']").value("13345678901"))
                // 结果处理器
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "classpath:h2/user/init-data.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "classpath:h2/user/clean-data.sql")
    })
    void getUser2() throws Exception {
        // 模拟GET请求，并返回结果
        MvcResult result = mvc.perform(get("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        JsonObject apiResult = JsonParser.parseString(response.getContentAsString()).getAsJsonObject();
        JsonObject data = apiResult.getAsJsonObject("data").getAsJsonObject();

        // 断言验证数据
        Assertions.assertEquals(response.getStatus(), HttpStatus.OK.value());
        Assertions.assertEquals(data.get("account").getAsString(), "zhuqc1");
        Assertions.assertEquals(data.get("password").getAsString(), "password");
        Assertions.assertEquals(data.get("nickname").getAsString(), "zhuqc1");
        Assertions.assertEquals(data.get("email").getAsString(), "zqc@zqc.com");
        Assertions.assertEquals(data.get("phone").getAsString(), "13345678901");
    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "classpath:h2/user/clean-data.sql")
    })
    void addUser() throws Exception {
        User user = new User();
        user.setAccount("zhuqc1");
        user.setPassword("password");
        user.setNickname("zhuqc1");
        user.setEmail("zqc@zqc.com");
        user.setPhone("13345678901");

        // 模拟POST请求
        mvc.perform(post("/user")
                // 请求参数类型
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                // 接收参数类型
                .accept(MediaType.APPLICATION_JSON_UTF8)
                // 请求参数
                .content(gson.toJson(user)))
                // 结果验证
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(200));
    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "classpath:h2/user/init-data.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "classpath:h2/user/clean-data.sql")
    })
    void deleteUser() throws Exception {
        mvc.perform(delete("/user/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(200));
    }

    @Test
    @SqlGroup({
            @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "classpath:h2/user/init-data.sql"),
            @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "classpath:h2/user/clean-data.sql")
    })
    void updateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setAccount("zhuqc1");
        user.setPassword("password");
        user.setNickname("zhuqc2");
        user.setEmail("zqc@zqc.com");
        user.setPhone("13345678901");

        mvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(gson.toJson(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(200));
    }
}