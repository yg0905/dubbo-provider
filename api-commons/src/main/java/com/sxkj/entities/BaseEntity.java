package com.sxkj.entities;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity<T extends BaseEntity> extends Model<BaseEntity<T>> {

    /**
     * 主键(注解处理Long类型前后端传递精度缺失问题)
     *
     */
    @JsonSerialize(using= ToStringSerializer.class)
    protected Long id;

    /**
     * 版本号
     */
    @Version
    protected Long version;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    //@TableField(update = "now()")
    protected LocalDateTime updateTime;

    /**
     * 是否已删除
     */
    protected Boolean isDeleted;

    /**
     * 备注
     */
    protected String remark;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
