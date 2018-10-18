package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttLeaveCount;
import com.cd.common.Assist;
public interface AttLeaveCountService{
	/**
	 * 获得AttLeaveCount数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttLeaveCountRowCount(Assist assist);
	/**
	 * 获得AttLeaveCount数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttLeaveCount> selectAttLeaveCount(Assist assist);
	/**
	 * 获得一个AttLeaveCount对象,以参数AttLeaveCount对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttLeaveCount selectAttLeaveCountByObj(AttLeaveCount obj);
	/**
	 * 通过AttLeaveCount的id获得AttLeaveCount对象
	 * @param id
	 * @return
	 */
    AttLeaveCount selectAttLeaveCountById(Long id);
	/**
	 * 插入AttLeaveCount到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttLeaveCount(AttLeaveCount value);
	/**
	 * 插入AttLeaveCount中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttLeaveCount(AttLeaveCount value);
	/**
	 * 批量插入AttLeaveCount到数据库
	 * @param value
	 * @return
	 */
    int insertAttLeaveCountByBatch(List<AttLeaveCount> value);
	/**
	 * 通过AttLeaveCount的id删除AttLeaveCount
	 * @param id
	 * @return
	 */
    int deleteAttLeaveCountById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttLeaveCount
	 * @param assist
	 * @return
	 */
    int deleteAttLeaveCount(Assist assist);
	/**
	 * 通过AttLeaveCount的id更新AttLeaveCount中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttLeaveCountById(AttLeaveCount enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttLeaveCount中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttLeaveCount(AttLeaveCount value,  Assist assist);
	/**
	 * 通过AttLeaveCount的id更新AttLeaveCount中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttLeaveCountById(AttLeaveCount enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttLeaveCount中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttLeaveCount(AttLeaveCount value, Assist assist);
}