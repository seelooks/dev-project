package com.seezoon.service.modules.base.entity;

import com.seezoon.boot.common.entity.BaseEntity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
/**
 * 设备信息
 * Copyright &copy; 2018 powered by huangdf, All rights reserved.
 * @author hdf 2019-3-27 21:07:56
 */
public class DeviceInfo extends BaseEntity<Integer> {

   private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @Length(max = 255)
    private String code;
    /**
     * 名称
     */
    @Length(max = 255)
    private String name;
    /**
     * 备注
     */
    @Length(max = 255)
    private String descInfo;
    /**
     * 插入时间
     */
    private Date inserttime;
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public Date getInserttime(){
        return inserttime;
    }
    public void setInserttime(Date inserttime){
        this.inserttime = inserttime;
    }
}