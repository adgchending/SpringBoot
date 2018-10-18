package com.cd.basic.service;
import java.util.List;
import com.cd.basic.pojo.domain.AttStudentCard;
import com.cd.common.Assist;
public interface AttStudentCardService{
	/**
	 * 获得AttStudentCard数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttStudentCardRowCount(Assist assist);
	/**
	 * 获得AttStudentCard数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttStudentCard> selectAttStudentCard(Assist assist);
	/**
	 * 获得一个AttStudentCard对象,以参数AttStudentCard对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttStudentCard selectAttStudentCardByObj(AttStudentCard obj);
	/**
	 * 通过AttStudentCard的id获得AttStudentCard对象
	 * @param id
	 * @return
	 */
    AttStudentCard selectAttStudentCardById(Long id);
	/**
	 * 插入AttStudentCard到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttStudentCard(AttStudentCard value);
	/**
	 * 插入AttStudentCard中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttStudentCard(AttStudentCard value);
	/**
	 * 批量插入AttStudentCard到数据库
	 * @param value
	 * @return
	 */
    int insertAttStudentCardByBatch(List<AttStudentCard> value);
	/**
	 * 通过AttStudentCard的id删除AttStudentCard
	 * @param id
	 * @return
	 */
    int deleteAttStudentCardById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttStudentCard
	 * @param assist
	 * @return
	 */
    int deleteAttStudentCard(Assist assist);
	/**
	 * 通过AttStudentCard的id更新AttStudentCard中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttStudentCardById(AttStudentCard enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttStudentCard中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttStudentCard(AttStudentCard value,  Assist assist);
	/**
	 * 通过AttStudentCard的id更新AttStudentCard中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttStudentCardById(AttStudentCard enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttStudentCard中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttStudentCard(AttStudentCard value, Assist assist);
}