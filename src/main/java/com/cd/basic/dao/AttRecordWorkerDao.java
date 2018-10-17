package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttRecordWorker;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttRecordWorkerDao{
	/**
	 * 获得AttRecordWorker数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttRecordWorkerRowCount(Assist assist);
	/**
	 * 获得AttRecordWorker数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttRecordWorker> selectAttRecordWorker(Assist assist);
	/**
	 * 获得一个AttRecordWorker对象,以参数AttRecordWorker对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttRecordWorker selectAttRecordWorkerByObj(AttRecordWorker obj);
	/**
	 * 通过AttRecordWorker的id获得AttRecordWorker对象
	 * @param id
	 * @return
	 */
    AttRecordWorker selectAttRecordWorkerById(Long id);
	/**
	 * 插入AttRecordWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRecordWorker(AttRecordWorker value);
	/**
	 * 插入AttRecordWorker中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttRecordWorker(AttRecordWorker value);
	/**
	 * 批量插入AttRecordWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRecordWorkerByBatch(List<AttRecordWorker> value);
	/**
	 * 通过AttRecordWorker的id删除AttRecordWorker
	 * @param id
	 * @return
	 */
    int deleteAttRecordWorkerById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttRecordWorker
	 * @param assist
	 * @return
	 */
    int deleteAttRecordWorker(Assist assist);
	/**
	 * 通过AttRecordWorker的id更新AttRecordWorker中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttRecordWorkerById(AttRecordWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRecordWorker中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttRecordWorker(@Param("enti") AttRecordWorker value, @Param("assist") Assist assist);
	/**
	 * 通过AttRecordWorker的id更新AttRecordWorker中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttRecordWorkerById(AttRecordWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRecordWorker中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttRecordWorker(@Param("enti") AttRecordWorker value, @Param("assist") Assist assist);
}
