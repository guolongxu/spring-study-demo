package com.xgl.study.springtransaction.service;

import java.text.ParseException;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
public interface IDegreeService {

    void addDegree(Long userId ,String degree , String startTime , String endTime) throws ParseException;
}
