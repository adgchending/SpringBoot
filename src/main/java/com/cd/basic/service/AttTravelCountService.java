package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttTravelCount;
import com.cd.common.Assist;
public interface AttTravelCountService{
	/**
	 * 获得AttTravelCount数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttTravelCountRowCount(Assist assist);
	/**
	 * 获得AttTravelCount数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttTravelCount> selectAttTravelCount(Assist assist);
	/**
	 * 获得一个AttTravelCount对象,以参数AttTravelCount对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttTravelCount selectAttTravelCountByObj(AttTravelCount obj);
	/**
	 * 通过AttTravelCount的id获得AttTravelCount对象
	 * @param id
	 * @return
	 */
    AttTravelCount selectAttTravelCountById(Long id);
	/**
	 * 插入AttTravelCount到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttTravelCount(AttTravelCount value);
	/**
	 * 插入AttTravelCount中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttTravelCount(AttTravelCount value);
	/**
	 * 批量插入AttTravelCount到数据库
	 * @param value
	 * @return
	 */
    int insertAttTravelCountByBatch(List<AttTravelCount> value);
	/**
	 * 通过AttTravelCount的id删除AttTravelCount
	 * @param id
	 * @return
	 */
    int deleteAttTravelCountById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttTravelCount
	 * @param assist
	 * @return
	 */
    int deleteAttTravelCount(Assist assist);
	/**
	 * 通过AttTravelCount的id更新AttTravelCount中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttTravelCountById(AttTravelCount enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttTravelCount中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttTravelCount(AttTravelCount value,  Assist assist);
	/**
	 * 通过AttTravelCount的id更新AttTravelCount中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttTravelCountById(AttTravelCount enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttTravelCount中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttTravelCount(AttTravelCount value, Assist assist);
}