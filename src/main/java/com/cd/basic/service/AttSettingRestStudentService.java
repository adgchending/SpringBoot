package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttSettingRestStudent;
import com.cd.common.Assist;
public interface AttSettingRestStudentService{
	/**
	 * 获得AttSettingRestStudent数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttSettingRestStudentRowCount(Assist assist);
	/**
	 * 获得AttSettingRestStudent数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttSettingRestStudent> selectAttSettingRestStudent(Assist assist);
	/**
	 * 获得一个AttSettingRestStudent对象,以参数AttSettingRestStudent对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttSettingRestStudent selectAttSettingRestStudentByObj(AttSettingRestStudent obj);
	/**
	 * 通过AttSettingRestStudent的id获得AttSettingRestStudent对象
	 * @param id
	 * @return
	 */
    AttSettingRestStudent selectAttSettingRestStudentById(Long id);
	/**
	 * 插入AttSettingRestStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingRestStudent(AttSettingRestStudent value);
	/**
	 * 插入AttSettingRestStudent中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttSettingRestStudent(AttSettingRestStudent value);
	/**
	 * 批量插入AttSettingRestStudent到数据库
	 * @param value
	 * @return
	 */
    int insertAttSettingRestStudentByBatch(List<AttSettingRestStudent> value);
	/**
	 * 通过AttSettingRestStudent的id删除AttSettingRestStudent
	 * @param id
	 * @return
	 */
    int deleteAttSettingRestStudentById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttSettingRestStudent
	 * @param assist
	 * @return
	 */
    int deleteAttSettingRestStudent(Assist assist);
	/**
	 * 通过AttSettingRestStudent的id更新AttSettingRestStudent中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttSettingRestStudentById(AttSettingRestStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingRestStudent中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttSettingRestStudent(AttSettingRestStudent value,  Assist assist);
	/**
	 * 通过AttSettingRestStudent的id更新AttSettingRestStudent中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttSettingRestStudentById(AttSettingRestStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingRestStudent中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttSettingRestStudent(AttSettingRestStudent value, Assist assist);
}