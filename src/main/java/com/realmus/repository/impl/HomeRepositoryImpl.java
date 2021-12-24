package com.realmus.repository.impl;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.ModuleEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.CompanyEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.repository.HomeRepository;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.mapper.CnHomeMapper;
import com.realmus.repository.model.HomeDO;
import com.realmus.repository.model.NavigationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:50
 */

@Repository
public class HomeRepositoryImpl implements HomeRepository {
    @Autowired
    private CnHomeMapper cnHomeMapper;


    @Override
    public HomeInfoEntity getHomeInfoChinese(LanguageEnum languageEnum) {
        List<HomeDO> homeDOList = null;
        //获取全量数据
        switch (languageEnum) {
            case CHINESE:
                homeDOList = cnHomeMapper.findAllHomeInfo();
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }

        //数据处理
        return dataAssembly(homeDOList);
    }

    private HomeInfoEntity dataAssembly(List<HomeDO> homeDOList) {
        HomeInfoEntity infoEntity = new HomeInfoEntity();
        //获取模块1 Banner 的数据
        List<BannerEntity> bannerEntityList = homeDOList.stream().filter(homeDO -> {
            return ModuleEnum.BANNER.getCode().equals(homeDO.getInfoType());
        }).sorted(Comparator.comparing(HomeDO::getInfoWeight).reversed())
                .map(DoTOEntity::toBannerEntity).collect(Collectors.toList());
        infoEntity.setBannerList(bannerEntityList);


        //获取模块2 公司信息
        Optional<CompanyEntity> optionalCompany = homeDOList.stream().filter(homeDO -> {
            return ModuleEnum.COMPANY.getCode().equals(homeDO.getInfoType());
        }).map(DoTOEntity::toCompanyEntity).findFirst();
        infoEntity.setCompany(optionalCompany.get());

        //获取模块3  优势小 Banner 的数据
        List<BannerEntity> advantageBannerList = homeDOList.stream().filter(homeDO -> {
            return ModuleEnum.ADVANTAGE_BANNER.getCode().equals(homeDO.getInfoType());
        }).sorted(Comparator.comparing(HomeDO::getInfoWeight).reversed())
                .map(DoTOEntity::toBannerEntity).collect(Collectors.toList());
        infoEntity.setAdvantageBanner(advantageBannerList);


        return infoEntity;
    }


}
