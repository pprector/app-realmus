package com.realmus.repository.impl;

import com.realmus.domain.entity.InformEntity;
import com.realmus.domain.repository.InformRepository;
import com.realmus.repository.converter.EntityToDo;
import com.realmus.repository.mapper.InformMapper;
import com.realmus.repository.model.InformDO;
import com.realmus.service.InformFacadeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author hkpeng
 * @date 2022/3/9 - 15:05
 */
@Repository
public class InformRepositoryImpl implements InformRepository {
    private static final Logger logger = LoggerFactory.getLogger(InformRepositoryImpl.class);
    @Autowired
    private InformMapper informMapper;


    @Override
    public void addInform(InformEntity entity) {
        InformDO informDO = EntityToDo.toInformDO(entity);
        informMapper.insertSelective(informDO);
    }
}
