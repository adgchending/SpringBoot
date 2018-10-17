package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttWorkerCard;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttWorkerCardDao{
	/**
	 * 获得AttWorkerCard数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttWorkerCardRowCount(Assist assist);
	/**
	 * 获得AttWorkerCard数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttWorkerCard> selectAttWorkerCard(Assist assist);
	/**
	 * 获得一个AttWorkerCard对象,以参数AttWorkerCard对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttWorkerCard selectAttWorkerCardByObj(AttWorkerCard obj);
	/**
	 * 通过AttWorkerCard的id获得AttWorkerCard对象
	 * @param id
	 * @return
	 */
    AttWorkerCard selectAttWorkerCardById(Long id);
	/**
	 * 插入AttWorkerCard到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttWorkerCard(AttWorkerCard value);
	/**
	 * 插入AttWorkerCard中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttWorkerCard(AttWorkerCard value);
	/**
	 * 批量插入AttWorkerCard到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttWorkerCardByBatch(List<AttWorkerCard> value);
	/**
	 * 通过AttWorkerCard的id删除AttWorkerCard
	 * @param id
	 * @return
	 */
    int deleteAttWorkerCardById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttWorkerCard
	 * @param assist
	 * @return
	 */
    int deleteAttWorkerCard(Assist assist);
	/**
	 * 通过AttWorkerCard的id更新AttWorkerCard中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttWorkerCardById(AttWorkerCard enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttWorkerCard中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttWorkerCard(@Param("enti") AttWorkerCard value, @Param("assist") Assist assist);
	/**
	 * 通过AttWorkerCard的id更新AttWorkerCard中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttWorkerCardById(AttWorkerCard enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttWorkerCard中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttWorkerCard(@Param("enti") AttWorkerCard value, @Param("assist") Assist assist);
}
