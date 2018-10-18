package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttSettingStudent;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttSettingStudentDao{
	/**
	 * 获得AttSettingStudent数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttSettingStudentRowCount(Assist assist);
	/**
	 * 获得AttSettingStudent数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttSettingStudent> selectAttSettingStudent(Assist assist);
	/**
	 * 获得一个AttSettingStudent对象,以参数AttSettingStudent对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttSettingStudent selectAttSettingStudentByObj(AttSettingStudent obj);
	/**
	 * 通过AttSettingStudent的id获得AttSettingStudent对象
	 * @param id
	 * @return
	 */
    AttSettingStudent selectAttSettingStudentById(Long id);
	/**
	 * 插入AttSettingStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingStudent(AttSettingStudent value);
	/**
	 * 插入AttSettingStudent中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttSettingStudent(AttSettingStudent value);
	/**
	 * 批量插入AttSettingStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttSettingStudentByBatch(List<AttSettingStudent> value);
	/**
	 * 通过AttSettingStudent的id删除AttSettingStudent
	 * @param id
	 * @return
	 */
    int deleteAttSettingStudentById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttSettingStudent
	 * @param assist
	 * @return
	 */
    int deleteAttSettingStudent(Assist assist);
	/**
	 * 通过AttSettingStudent的id更新AttSettingStudent中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttSettingStudentById(AttSettingStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingStudent中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttSettingStudent(@Param("enti") AttSettingStudent value, @Param("assist") Assist assist);
	/**
	 * 通过AttSettingStudent的id更新AttSettingStudent中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttSettingStudentById(AttSettingStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttSettingStudent中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttSettingStudent(@Param("enti") AttSettingStudent value, @Param("assist") Assist assist);
}
