package com.realmus.repository.impl;

import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.repository.MultimediaRepository;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.mapper.MultimediaMapper;
import com.realmus.repository.model.MultimediaDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/22 - 16:01
 */
@Repository
public class MultimediaRepositoryImpl implements MultimediaRepository {

    @Autowired
    private MultimediaMapper multimediaMapper;


    @Override
    public MultimediaEntity getMultimediaEntityOne(String relationId) {
        MultimediaDO multimediaDO = multimediaMapper.getMultimediaEntityOne(relationId);
        return DoTOEntity.toMultimediaEntity(relationId, multimediaDO);
    }

    @Override
    public List<MultimediaEntity> getMultimediaEntityList(String relationId) {
        List<MultimediaDO> multimediaDOList = multimediaMapper.getMultimediaEntityList(relationId);
        //转化
        List<MultimediaEntity> multimediaEntityList = new ArrayList<>();
        for (MultimediaDO multimediaDO : multimediaDOList) {
            multimediaEntityList.add(DoTOEntity.toMultimediaEntity(relationId, multimediaDO));
        }
        return multimediaEntityList;
    }
}
