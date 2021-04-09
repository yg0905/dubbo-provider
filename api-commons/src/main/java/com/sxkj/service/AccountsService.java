package com.sxkj.service;

import java.math.BigDecimal;

public interface AccountsService {
    void decrease(Long userId, BigDecimal money);
}
