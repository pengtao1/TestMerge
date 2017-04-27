package com.example.dto;

import com.example.annotations.FieldFormatAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wb-zhangkenan on 2017/4/19.
 *
 * @author wb-zhangkenan
 * @date 2017/04/19
 */
@ApiModel
public class SwaggerDemoDTO {

    /**
     * 注解ID值
     */
    @ApiModelProperty(value = "主键ID值")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    @FieldFormatAnnotation(stringLength = 12)
    private String passWord;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;
    /**
     * 国家
     */
    @ApiModelProperty(value = "国家",allowableValues = "AE,BR,CN,GB")
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
