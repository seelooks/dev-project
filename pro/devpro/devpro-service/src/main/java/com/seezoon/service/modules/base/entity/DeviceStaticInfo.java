package com.seezoon.service.modules.base.entity;

import com.seezoon.boot.common.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class DeviceStaticInfo extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;
    /**
     * 设备编号
     */
    @NotNull
    @Length(min=1,max=200)
    private String devCode;

    /**
     * 设备名称
     */
    @NotNull
    @Length(min=1,max=100)
    private String devName;


    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }
}
