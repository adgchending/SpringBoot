package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttSettingWorker;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttSettingWorkerDao{
	/**
	 * 获得AttSettingWorker数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttSettingWorkerRowCount(Assist assist);
	/**
	 * 获得AttSettingWorker数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttSettingWorker> selectAttSettingWorker(Assist assist);
	/**
	 * 获得一个AttSettingWorker对象,以参数AttSettingWorker对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttSettingWorker selectAttSettingWorkerByObj(AttSettingWorker obj);
	/**
	 * 通过AttSettingWorker的id获得AttSettingWorker对象
	 * @param id
	 * @return
	 */
    AttSettingWorker selectAttSettingWorkerById(Long id);
	/**
	 * 插入AttSettingWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingWorker(AttSettingWorker value);
	/**
	 * 插入AttSettingWorker中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttSettingWorker(AttSettingWorker value);
	/**
	 * 批量插入AttSettingWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingWorkerByBatch(List<AttSettingWorker> value);
	/**
	 * 通过AttSettingWorker的id删除AttSettingWorker
	 * @param id
	 * @return
	 */
    int deleteAttSettingWorkerById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttSettingWorker
	 * @param assist
	 * @return
	 */
    int deleteAttSettingWorker(Assist assist);
	/**
	 * 通过AttSettingWorker的id更新AttSettingWorker中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttSettingWorkerById(AttSettingWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingWorker中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttSettingWorker(@Param("enti") AttSettingWorker value, @Param("assist") Assist assist);
	/**
	 * 通过AttSettingWorker的id更新AttSettingWorker中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttSettingWorkerById(AttSettingWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingWorker中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttSettingWorker(@Param("enti") AttSettingWorker value, @Param("assist") Assist assist);
}
