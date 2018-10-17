package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttRecordStudent;
import com.cd.common.Assist;
public interface AttRecordStudentService{
	/**
	 * 获得AttRecordStudent数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttRecordStudentRowCount(Assist assist);
	/**
	 * 获得AttRecordStudent数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttRecordStudent> selectAttRecordStudent(Assist assist);
	/**
	 * 获得一个AttRecordStudent对象,以参数AttRecordStudent对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttRecordStudent selectAttRecordStudentByObj(AttRecordStudent obj);
	/**
	 * 通过AttRecordStudent的id获得AttRecordStudent对象
	 * @param id
	 * @return
	 */
    AttRecordStudent selectAttRecordStudentById(Long id);
	/**
	 * 插入AttRecordStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRecordStudent(AttRecordStudent value);
	/**
	 * 插入AttRecordStudent中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttRecordStudent(AttRecordStudent value);
	/**
	 * 批量插入AttRecordStudent到数据库
	 * @param value
	 * @return
	 */
    int insertAttRecordStudentByBatch(List<AttRecordStudent> value);
	/**
	 * 通过AttRecordStudent的id删除AttRecordStudent
	 * @param id
	 * @return
	 */
    int deleteAttRecordStudentById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttRecordStudent
	 * @param assist
	 * @return
	 */
    int deleteAttRecordStudent(Assist assist);
	/**
	 * 通过AttRecordStudent的id更新AttRecordStudent中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttRecordStudentById(AttRecordStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRecordStudent中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttRecordStudent(AttRecordStudent value,  Assist assist);
	/**
	 * 通过AttRecordStudent的id更新AttRecordStudent中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttRecordStudentById(AttRecordStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRecordStudent中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttRecordStudent(AttRecordStudent value, Assist assist);
}