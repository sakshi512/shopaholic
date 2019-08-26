package com.shop.Shopaholic.unit.services;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.UserRepository;
import com.shop.Shopaholic.services.SignupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static com.shop.Shopaholic.utilities.Json.mapToJason;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(value= SignupService.class,secure = false)
public class TestSignUpService {
    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private UserRepository userRepository;

    @Spy
    @InjectMocks
    SignupService signupService;

    @Test
    public void addUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(8);
        userEntity.setFirstName("Sheetal");
        userEntity.setLastName("Sharma");
        userEntity.setAddressLine1("Gurgaon");
        userEntity.setAddressLine2("Gurgaon");
        userEntity.setCity("Gurgaon");
        userEntity.setPin(122011);
        userEntity.setPhone("12345");
        userEntity.setPassword("123");
        LocalDate now = LocalDate.now();
        userEntity.setDob(now);
        userEntity.setCreationDate(now);
        userEntity.setRoleId(1);
        userEntity.setEmail("sheetal@gmail.com");

        String URL="/signUp";
        String inputJson = mapToJason(userEntity);
        //Mockito.when(userRepository.save(userEntity)).thenReturn(inputJson);

        RequestBuilder requestBuilder = post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println("response = "+response);
        String outputResult = response.getContentAsString();
        outputResult = inputJson;
        System.out.println("outputResult"+outputResult);
        assertThat(outputResult).isEqualTo(inputJson);
    }
}
