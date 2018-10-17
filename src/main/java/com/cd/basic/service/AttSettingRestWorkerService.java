package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttSettingRestWorker;
import com.cd.common.Assist;
public interface AttSettingRestWorkerService{
	/**
	 * 获得AttSettingRestWorker数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttSettingRestWorkerRowCount(Assist assist);
	/**
	 * 获得AttSettingRestWorker数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttSettingRestWorker> selectAttSettingRestWorker(Assist assist);
	/**
	 * 获得一个AttSettingRestWorker对象,以参数AttSettingRestWorker对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttSettingRestWorker selectAttSettingRestWorkerByObj(AttSettingRestWorker obj);
	/**
	 * 通过AttSettingRestWorker的id获得AttSettingRestWorker对象
	 * @param id
	 * @return
	 */
    AttSettingRestWorker selectAttSettingRestWorkerById(Long id);
	/**
	 * 插入AttSettingRestWorker到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingRestWorker(AttSettingRestWorker value);
	/**
	 * 插入AttSettingRestWorker中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttSettingRestWorker(AttSettingRestWorker value);
	/**
	 * 批量插入AttSettingRestWorker到数据库
	 * @param value
	 * @return
	 */
    int insertAttSettingRestWorkerByBatch(List<AttSettingRestWorker> value);
	/**
	 * 通过AttSettingRestWorker的id删除AttSettingRestWorker
	 * @param id
	 * @return
	 */
    int deleteAttSettingRestWorkerById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttSettingRestWorker
	 * @param assist
	 * @return
	 */
    int deleteAttSettingRestWorker(Assist assist);
	/**
	 * 通过AttSettingRestWorker的id更新AttSettingRestWorker中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttSettingRestWorkerById(AttSettingRestWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingRestWorker中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttSettingRestWorker(AttSettingRestWorker value,  Assist assist);
	/**
	 * 通过AttSettingRestWorker的id更新AttSettingRestWorker中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttSettingRestWorkerById(AttSettingRestWorker enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingRestWorker中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttSettingRestWorker(AttSettingRestWorker value, Assist assist);
}