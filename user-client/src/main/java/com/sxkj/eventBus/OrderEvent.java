package com.sxkj.eventBus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent implements Serializable {
    private static final long serialVersionUID = 8794979353646765379L;
    private String telePhone;
    private String email;
    private String goodsName;
}
