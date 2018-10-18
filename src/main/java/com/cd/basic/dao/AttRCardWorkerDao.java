package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttRCardWorker;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttRCardWorkerDao{
	/**
	 * 获得AttRCardWorker数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttRCardWorkerRowCount(Assist assist);
	/**
	 * 获得AttRCardWorker数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttRCardWorker> selectAttRCardWorker(Assist assist);
	/**
	 * 获得一个AttRCardWorker对象,以参数AttRCardWorker对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttRCardWorker selectAttRCardWorkerByObj(AttRCardWorker obj);
	/**
	 * 通过AttRCardWorker的id获得AttRCardWorker对象
	 * @param id
	 * @return
	 */
    AttRCardWorker selectAttRCardWorkerById(Long id);
	/**
	 * 插入AttRCardWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRCardWorker(AttRCardWorker value);
	/**
	 * 插入AttRCardWorker中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttRCardWorker(AttRCardWorker value);
	/**
	 * 批量插入AttRCardWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRCardWorkerByBatch(List<AttRCardWorker> value);
	/**
	 * 通过AttRCardWorker的id删除AttRCardWorker
	 * @param id
	 * @return
	 */
    int deleteAttRCardWorkerById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttRCardWorker
	 * @param assist
	 * @return
	 */
    int deleteAttRCardWorker(Assist assist);
	/**
	 * 通过AttRCardWorker的id更新AttRCardWorker中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttRCardWorkerById(AttRCardWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRCardWorker中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttRCardWorker(@Param("enti") AttRCardWorker value, @Param("assist") Assist assist);
	/**
	 * 通过AttRCardWorker的id更新AttRCardWorker中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttRCardWorkerById(AttRCardWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRCardWorker中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttRCardWorker(@Param("enti") AttRCardWorker value, @Param("assist") Assist assist);
}
