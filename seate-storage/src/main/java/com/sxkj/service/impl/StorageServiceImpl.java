package com.sxkj.service.impl;

import com.sxkj.dao.StorageDao;
import com.sxkj.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {

        storageDao.decrease(productId, count);
    }

}
