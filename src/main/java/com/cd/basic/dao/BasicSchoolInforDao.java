package com.cd.basic.dao;

import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BasicSchoolInforDao{
	/**
	 * 获得BasicSchoolInfor数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getBasicSchoolInforRowCount(Assist assist);
	/**
	 * 获得BasicSchoolInfor数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<BasicSchoolInfor> selectBasicSchoolInfor(Assist assist);
	/**
	 * 获得一个BasicSchoolInfor对象,以参数BasicSchoolInfor对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    BasicSchoolInfor selectBasicSchoolInforByObj(BasicSchoolInfor obj);
	/**
	 * 通过BasicSchoolInfor的id获得BasicSchoolInfor对象
	 * @param id
	 * @return
	 */
    BasicSchoolInfor selectBasicSchoolInforById(Long id);
	/**
	 * 插入BasicSchoolInfor到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBasicSchoolInfor(BasicSchoolInfor value);
	/**
	 * 插入BasicSchoolInfor中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyBasicSchoolInfor(BasicSchoolInfor value);
	/**
	 * 批量插入BasicSchoolInfor到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertBasicSchoolInforByBatch(List<BasicSchoolInfor> value);
	/**
	 * 通过BasicSchoolInfor的id删除BasicSchoolInfor
	 * @param id
	 * @return
	 */
    int deleteBasicSchoolInforById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除BasicSchoolInfor
	 * @param assist
	 * @return
	 */
    int deleteBasicSchoolInfor(Assist assist);
	/**
	 * 通过BasicSchoolInfor的id更新BasicSchoolInfor中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateBasicSchoolInforById(BasicSchoolInfor enti);
 	/**
	 * 通过辅助工具Assist的条件更新BasicSchoolInfor中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateBasicSchoolInfor(@Param("enti") BasicSchoolInfor value, @Param("assist") Assist assist);
	/**
	 * 通过BasicSchoolInfor的id更新BasicSchoolInfor中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyBasicSchoolInforById(BasicSchoolInfor enti);
 	/**
	 * 通过辅助工具Assist的条件更新BasicSchoolInfor中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyBasicSchoolInfor(@Param("enti") BasicSchoolInfor value, @Param("assist") Assist assist);
}
