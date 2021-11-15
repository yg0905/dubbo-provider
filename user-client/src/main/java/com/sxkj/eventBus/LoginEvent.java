package com.sxkj.eventBus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 定义事件，使用普通的POJO即可，这里之所以定义两个pojo，并且字段名一样。
// 就是我之前有个疑问：事件驱动的时候会不会错乱
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEvent implements Serializable {
    private static final long serialVersionUID = -6787105919337013565L;
    private String telePhone;
    private String email;
    private String goodsName;
}

