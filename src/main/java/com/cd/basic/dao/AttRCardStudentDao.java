package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttRCardStudent;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttRCardStudentDao{
	/**
	 * 获得AttRCardStudent数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttRCardStudentRowCount(Assist assist);
	/**
	 * 获得AttRCardStudent数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttRCardStudent> selectAttRCardStudent(Assist assist);
	/**
	 * 获得一个AttRCardStudent对象,以参数AttRCardStudent对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttRCardStudent selectAttRCardStudentByObj(AttRCardStudent obj);
	/**
	 * 通过AttRCardStudent的id获得AttRCardStudent对象
	 * @param id
	 * @return
	 */
    AttRCardStudent selectAttRCardStudentById(Long id);
	/**
	 * 插入AttRCardStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRCardStudent(AttRCardStudent value);
	/**
	 * 插入AttRCardStudent中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttRCardStudent(AttRCardStudent value);
	/**
	 * 批量插入AttRCardStudent到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttRCardStudentByBatch(List<AttRCardStudent> value);
	/**
	 * 通过AttRCardStudent的id删除AttRCardStudent
	 * @param id
	 * @return
	 */
    int deleteAttRCardStudentById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttRCardStudent
	 * @param assist
	 * @return
	 */
    int deleteAttRCardStudent(Assist assist);
	/**
	 * 通过AttRCardStudent的id更新AttRCardStudent中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttRCardStudentById(AttRCardStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRCardStudent中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttRCardStudent(@Param("enti") AttRCardStudent value, @Param("assist") Assist assist);
	/**
	 * 通过AttRCardStudent的id更新AttRCardStudent中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttRCardStudentById(AttRCardStudent enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttRCardStudent中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttRCardStudent(@Param("enti") AttRCardStudent value, @Param("assist") Assist assist);
}
