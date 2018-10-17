package com.cd.basic.dao;
import com.cd.basic.pojo.domain.AttManage;
import java.util.List;
import com.cd.common.Assist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttManageDao{
	/**
	 * 获得AttManage数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAttManageRowCount(Assist assist);
	/**
	 * 获得AttManage数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AttManage> selectAttManage(Assist assist);
	/**
	 * 获得一个AttManage对象,以参数AttManage对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AttManage selectAttManageByObj(AttManage obj);
	/**
	 * 通过AttManage的id获得AttManage对象
	 * @param id
	 * @return
	 */
    AttManage selectAttManageById(Long id);
	/**
	 * 插入AttManage到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttManage(AttManage value);
	/**
	 * 插入AttManage中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAttManage(AttManage value);
	/**
	 * 批量插入AttManage到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAttManageByBatch(List<AttManage> value);
	/**
	 * 通过AttManage的id删除AttManage
	 * @param id
	 * @return
	 */
    int deleteAttManageById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AttManage
	 * @param assist
	 * @return
	 */
    int deleteAttManage(Assist assist);
	/**
	 * 通过AttManage的id更新AttManage中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAttManageById(AttManage enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttManage中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAttManage(@Param("enti") AttManage value, @Param("assist") Assist assist);
	/**
	 * 通过AttManage的id更新AttManage中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAttManageById(AttManage enti);
 	/**
	 * 通过辅助工具Assist的条件更新AttManage中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAttManage(@Param("enti") AttManage value, @Param("assist") Assist assist);
}
