package com.cd.basic.service.serviceImpl;
import java.util.List;
import com.cd.basic.dao.AttSettingRestStudentDao;
import com.cd.basic.pojo.domain.AttSettingRestStudent;
import com.cd.common.Assist;
import com.cd.basic.service.AttSettingRestStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AttSettingRestStudentServiceImpl implements AttSettingRestStudentService{
    @Autowired
    private AttSettingRestStudentDao attSettingRestStudentDao;
    @Override
    public long getAttSettingRestStudentRowCount(Assist assist){
        return attSettingRestStudentDao.getAttSettingRestStudentRowCount(assist);
    }
    @Override
    public List<AttSettingRestStudent> selectAttSettingRestStudent(Assist assist){
        return attSettingRestStudentDao.selectAttSettingRestStudent(assist);
    }
    @Override
    public AttSettingRestStudent selectAttSettingRestStudentByObj(AttSettingRestStudent obj){
        return attSettingRestStudentDao.selectAttSettingRestStudentByObj(obj);
    }
    @Override
    public AttSettingRestStudent selectAttSettingRestStudentById(Long id){
        return attSettingRestStudentDao.selectAttSettingRestStudentById(id);
    }
    @Override
    public int insertAttSettingRestStudent(AttSettingRestStudent value){
        return attSettingRestStudentDao.insertAttSettingRestStudent(value);
    }
    @Override
    public int insertNonEmptyAttSettingRestStudent(AttSettingRestStudent value){
        return attSettingRestStudentDao.insertNonEmptyAttSettingRestStudent(value);
    }
    @Override
    public int insertAttSettingRestStudentByBatch(List<AttSettingRestStudent> value){
        return attSettingRestStudentDao.insertAttSettingRestStudentByBatch(value);
    }
    @Override
    public int deleteAttSettingRestStudentById(Long id){
        return attSettingRestStudentDao.deleteAttSettingRestStudentById(id);
    }
    @Override
    public int deleteAttSettingRestStudent(Assist assist){
        return attSettingRestStudentDao.deleteAttSettingRestStudent(assist);
    }
    @Override
    public int updateAttSettingRestStudentById(AttSettingRestStudent enti){
        return attSettingRestStudentDao.updateAttSettingRestStudentById(enti);
    }
    @Override
    public int updateAttSettingRestStudent(AttSettingRestStudent value, Assist assist){
        return attSettingRestStudentDao.updateAttSettingRestStudent(value,assist);
    }
    @Override
    public int updateNonEmptyAttSettingRestStudentById(AttSettingRestStudent enti){
        return attSettingRestStudentDao.updateNonEmptyAttSettingRestStudentById(enti);
    }
    @Override
    public int updateNonEmptyAttSettingRestStudent(AttSettingRestStudent value, Assist assist){
        return attSettingRestStudentDao.updateNonEmptyAttSettingRestStudent(value,assist);
    }

    public AttSettingRestStudentDao getAttSettingRestStudentDao() {
        return this.attSettingRestStudentDao;
    }

    public void setAttSettingRestStudentDao(AttSettingRestStudentDao attSettingRestStudentDao) {
        this.attSettingRestStudentDao = attSettingRestStudentDao;
    }

}