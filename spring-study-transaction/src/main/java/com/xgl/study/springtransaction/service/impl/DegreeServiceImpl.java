package com.xgl.study.springtransaction.service.impl;

import com.xgl.study.springtransaction.dao.DegreeDao;
import com.xgl.study.springtransaction.service.IDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@Service
public class DegreeServiceImpl implements IDegreeService {
    @Autowired
    private DegreeDao degreeDao;


    @Transactional(value="transactionManager2" ,readOnly = true)
    public void addDegree(Long userId ,String degree, String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);

        degreeDao.insert(userId ,degree, startDate, endDate);

        throw new RuntimeException("test degree exception");
    }
}
