package com.seezoon.service.modules.base.entity;
import com.seezoon.boot.common.entity.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

/**
 * @Auther: wangb
 * @Date: 2019/4/1/001 18:02
 * @Description:
 */
@Data
public class DeviceType extends BaseEntity<String> {

    private static final long serialVersionUID = 1L;

    /**
     * 类型编号
     */
    @NotNull
    @Length(min=1,max=36)
    private String typeCode;
    /**
     * 类型编号
     */
    private String parentId;
    /**
     * 父类型编号s
     */
    private String parentIds;
    /**
     * 类型名称
     */
    @NotNull
    @Length(min=1,max=36)
    private String typeName;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}