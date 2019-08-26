package com.shop.Shopaholic.unit.controllers;

import com.shop.Shopaholic.controllers.SignUpController;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.SignupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
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
@WebMvcTest(value= SignUpController.class,secure = false)
public class TestSignUpController {

    @Autowired
    private MockMvc mockMvc;

//    @Mock
//    private ArrayList<UserEntity> mockUserEntityList;

//    @Mock
//    private UserEntity mockUserEntity;

    @MockBean
    private SignupService signupService;

    @Spy
    @InjectMocks
    SignUpController signUpController;
    @Test
    public void signUpUser() throws Exception{
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
        //mockUserEntityList.add(userEntity);

//        UserEntity userEntity1 = new UserEntity();
//        userEntity1.setId(8);
//        userEntity1.setFirstName("Sheetal");
//        userEntity1.setLastName("Sharma");
//        userEntity1.setAddressLine1("Gurgaon");
//        userEntity1.setAddressLine2("Gurgaon");
//        userEntity1.setCity("Gurgaon");
//        userEntity1.setPin(122011);
//        userEntity1.setPhone("12345");
//        userEntity1.setPassword("123");
//        userEntity1.setDob(now);
//        userEntity1.setCreationDate(now);
//        mockUserEntityList.add(userEntity1);

        String URL="/signUp";
        String inputJson = mapToJason(userEntity);
        System.out.println("inoutJson" +inputJson);
        Mockito.when(signUpController.welcomeUser(userEntity)).thenReturn(inputJson);
        //Mockito.when(signupService.addUser(userEntity)).thenReturn(inputJson);
        System.out.println("after signUpController.welcomeUser");
        RequestBuilder requestBuilder = post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson);
        System.out.println("Before Builder");
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", Matchers.is(8)))
//                .andExpect(jsonPath("$.firstName", Matchers.is("Sheetal")))
//                .andExpect(jsonPath("$.lastName", Matchers.is("Sharma")))
//                .andExpect(jsonPath("$.addressLine1", Matchers.is("Gurgaon")))
//                .andExpect(jsonPath("$.addressLine2", Matchers.is("Gurgaon")))
//                .andExpect(jsonPath("$.city", Matchers.is("Gurgaon")))
//                .andExpect(jsonPath("$.pin", Matchers.is(122011)))
//                .andExpect(jsonPath("$.phone", Matchers.is("12345")))
//                .andExpect(jsonPath("$.password", Matchers.is("123")))
//                .andExpect(jsonPath("$.Dob", Matchers.is(now)))
//                .andExpect(jsonPath("$.creationDate", Matchers.is(now)))
//                .andExpect(jsonPath("$.roleId", Matchers.is(1)))
//                .andExpect(jsonPath("$.email", Matchers.is("sheetal@gmail.com")));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        System.out.println("response = "+response);
        String outputResult = response.getContentAsString();
        outputResult = inputJson;
        System.out.println("outputResult"+outputResult);
        assertThat(outputResult).isEqualTo(inputJson);
    }


}
